package com.cqupt.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.dto.NurseItemDTO;
import com.cqupt.mapper.NurseContentMapper;
import com.cqupt.mapper.NurseLevelItemMapper;
import com.cqupt.pojo.NurseContent;
import com.cqupt.pojo.NurseLevelItem;
import com.cqupt.service.NurseContentService;
import com.cqupt.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class NurseContenServiceImpl extends ServiceImpl<NurseContentMapper, NurseContent> implements NurseContentService {

    @Autowired
    private NurseContentMapper nurseContentMapper;
    @Autowired
    private NurseLevelItemMapper nurseLevelItemMapper;

    @Override
    public ResultVo<List<NurseContent>> listNurseItemByLevel(Integer levelId) throws Exception {
        //先查询级别的项目配置-只查询item_id
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("level_id", levelId);
        qw.select("item_id");
        List<Integer> itemIds =nurseLevelItemMapper.selectObjs(qw);
        List<NurseContent> nurseContents = new ArrayList<>();
        //判断是否有记录
        if(itemIds.size()>0){
            //查询护理项目信息
            nurseContents = nurseContentMapper.selectBatchIds(itemIds);
        }
        return ResultVo.ok(nurseContents);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo updateNurseItem(NurseContent nurseContent) throws Exception {
        //如果修改状态为2停用，需要之间提出护理级别护理项目列表中的对应的记录，保证列表中的项目都是可用状态
        if (nurseContent.getStatus() == 2) {
            //查询当前护理项目是否在护理级别项目列表中存在，如果在就需要进行剔除
            QueryWrapper qwCount = new QueryWrapper<>();
            qwCount.eq("item_id", nurseContent.getId());
            int count = nurseLevelItemMapper.selectCount(qwCount);
            if (count > 0) {
                QueryWrapper qw = new QueryWrapper<>();
                qw.eq("item_id", nurseContent.getId());
                int row =nurseLevelItemMapper.delete(qw);
                //更新护理项目
                boolean temp =updateById(nurseContent);
                if(!(temp&&row>0)){
                    throw new Exception("更新失败");
                }
                return ResultVo.ok("更新成功");
            }
        }
        //更新护理项目
        boolean temp =updateById(nurseContent);
        if (!temp) {
            throw new Exception("更新失败");
        }
        return ResultVo.ok("更新成功");
    }

    @Override
    public ResultVo delNurseItem(Integer id) throws Exception {
        NurseContent nurseContent = new NurseContent();
        nurseContent.setId(id);
        nurseContent.setIsDeleted(1);
        //查询当前护理项目是否在护理级别项目列表中存在，如果在就需要进行剔除
        QueryWrapper qwCount = new QueryWrapper();
        qwCount.eq("item_id", id);
        int count =nurseLevelItemMapper.selectCount(qwCount);
        if (count > 0) {
            QueryWrapper qw = new QueryWrapper<>();
            qw.eq("item_id", id);
            int row = nurseLevelItemMapper.delete(qw);
            //更新逻辑删除标志为‘1’隐藏
            boolean temp =updateById(nurseContent);
            if(!(temp&&row>0)){
                throw new Exception("删除失败");
            }
            return ResultVo.ok("删除成功");
        }
        //更新逻辑删除标志为‘1’隐藏
        boolean temp =updateById(nurseContent);
        if (!temp) {
            throw new Exception("删除失败");
        }
        return ResultVo.ok("删除成功");
    }

    @Override
    public ResultVo<Page<NurseContent>> listNurseContentByPage(NurseItemDTO nurseItemDTO) throws Exception {
        //查询护理项目信息
        Page<NurseContent> p = new Page<>(nurseItemDTO.getPageSize(),6);
        QueryWrapper qw = new QueryWrapper();
        if(nurseItemDTO.getItemName()!=null&&nurseItemDTO.getItemName()!=""){
            qw.like("nursing_name","%"+nurseItemDTO.getItemName()+"%");
        }
        if(nurseItemDTO.getStatus()!=null){
            qw.eq("status",nurseItemDTO.getStatus());
        }
        qw.eq("is_deleted",0);
        //
        page(p,qw);
        return ResultVo.ok(p);
    }

    @Override
    public ResultVo addNurseItem(NurseContent nurseContent) throws Exception {
        nurseContentMapper.insert(nurseContent);
        return ResultVo.ok("添加成功");
    }

}
