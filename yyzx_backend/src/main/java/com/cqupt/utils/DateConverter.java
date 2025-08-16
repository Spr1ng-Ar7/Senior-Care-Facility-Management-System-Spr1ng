package com.cqupt.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//日期转换
public class DateConverter implements Converter<String, Date> {
    private static final List<String> formats = new ArrayList<>();
    static {
        formats.add("yyyy-MM");
        formats.add("yyyy-MM-dd");
        formats.add("yyyy-MM-dd HH:mm");
        formats.add("yyyy-MM-dd HH:mm:ss");
    }


    @Override
    public Date convert(String source) {
        String value = source.trim();
        if("".equals(value)){
            return null;
        }
        if (source.matches( "^\\d{4}-\\d{1,2}$")) {
            return parseDate(source, formats.get(0));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            return parseDate(source, formats.get(1));
            //"空格{1}表示一个空格"
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
            return parseDate(source, formats.get(2));
        } else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            return parseDate(source, formats.get(3));
        } else {
            throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
        }
    }
    //日期格式化
    public Date parseDate(String dateStr, String format) {
        Date date = null;
        try {
            SimpleDateFormat dateFormat= new SimpleDateFormat(format);
            date = dateFormat.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}
