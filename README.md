# 🏥 医保报销系统

[![Java](https://img.shields.io/badge/Java-1.8+-orange.svg)]()
[![Spring Boot](https://img.shields.io/badge/SpringBoot-2.x-brightgreen.svg)]()
[![MyBatis](https://img.shields.io/badge/MyBatis-ORM-blue.svg)]()
[![Vue3](https://img.shields.io/badge/Vue-3.x-brightgreen.svg)]()
[![Element UI](https://img.shields.io/badge/Element_UI-2.x-blue.svg)]()
[![License](https://img.shields.io/badge/license-MIT-green.svg)]()
[![Build](https://img.shields.io/badge/Build-Passing-brightgreen.svg)]()

> 基于 **Spring Boot + MyBatis + Vue3 + Element UI** 开发的医保报销系统，集成丰富的报销等级、患者管理、医疗订单、药品、医疗器械等功能模块，支持前后端分离，提供完整的可视化 Swagger API 文档。  
> 适合医疗机构报销管理、二次开发与教学演示。

---

## 📖 目录
- [项目简介](#-项目简介)
- [技术栈说明](#-技术栈说明)
- [功能模块](#-功能模块)
- [运行环境](#-运行环境)
- [安装与运行](#-安装与运行)
- [API 文档](#-api-文档)
- [目录结构](#-目录结构)
- [注意事项](#-注意事项)
- [开源协议](#-开源协议)

---

## 📌 项目简介
医保报销系统针对医疗机构的医保报销流程，设计实现了报销等级配置、患者信息管理、费用明细管理、医疗订单管理等核心功能模块。  
系统采用前后端分离架构，后端基于Spring Boot+MyBatis，前端采用Vue3和Element UI，提供了完善的API接口和可视化文档，支持高效开发与维护。

---

## 🛠 技术栈说明
| 技术 | 用途 |
|------|------|
| **Spring Boot** | 后端服务框架，快速搭建RESTful接口 |
| **MyBatis** | 数据持久层框架，简化SQL操作 |
| **MySQL** | 关系型数据库存储 |
| **Vue3** | 前端框架，构建响应式页面 |
| **Element UI** | 前端UI组件库，提升开发效率 |
| **Swagger (Knife4j)** | API接口文档生成与在线测试 |
| **Maven** | 依赖管理与项目构建 |
| **Lombok** | 简化Java代码，自动生成getter/setter |

---

## 📂 功能模块
- **报销等级管理**：新增、编辑、删除、状态管理、复制配置、等级匹配和验证  
- **菜单权限管理**：菜单增删改查，权限树管理，角色权限分配  
- **费用明细管理**：费用账单管理，状态更新，费用统计分析  
- **患者管理**：患者信息增删改查，按年龄、性别、医保卡等多维度查询与统计  
- **疾病管理**：疾病编码维护，状态管理，分页查询  
- **权限管理**：权限增删改查，层级结构管理，权限验证  
- **统一用户管理**：用户登录、注册、角色管理、密码修改等  
- **药品管理**：药品信息维护，批量导入，统计分析  
- **医疗订单管理**：订单增删改查，结算审批，状态流转，历史记录查询  
- **医疗器械管理**：器械信息维护，状态管理，分页查询  
- **医疗服务管理**：医疗服务项目管理，医保分类及报销比例设置  
- **Excel导入**：支持批量导入数据及模板下载  
- **角色管理**：角色权限配置及状态管理  
- **结算管理**：结算单生成、统计、审批及导出

---

## 💻 运行环境
- **JDK**：1.8+
- **Maven**：3.6+
- **MySQL**：5.7 或以上
- **Node.js**：14+ （用于前端构建）
- **IDE**：推荐 IntelliJ IDEA / VSCode
- **操作系统**：Windows / macOS / Linux

---

## 🚀 安装与运行

### 1️⃣ 克隆项目
```bash
git clone https://github.com/your_repo/your_project.git
cd your_project

2️⃣ 数据库初始化
创建数据库：
CREATE DATABASE neuinsurance DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

3️⃣ 修改配置文件
编辑后端 application.yml，配置数据库账号密码及端口等：
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/neuinsurance?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai
    username: root
    password: your_password
  server:
    port: 8080

4️⃣ 启动后端服务
mvn clean package
mvn spring-boot:run

5️⃣ 启动前端项目
进入前端目录，安装依赖并启动：
cd frontend
pnpm install
pnpm run serve

6️⃣ 访问系统
后端API文档（Swagger/Knife4j）：http://localhost:8080/swagger-ui.html

前端页面：http://localhost:7777

📑 API 文档
系统集成了 Swagger UI ，支持接口在线测试和文档查看：
http://localhost:8080/swagger-ui/index.html#/

⚠ 注意事项
请确保数据库和配置文件的账号密码正确

前后端端口避免冲突，必要时修改配置

生产环境请关闭Swagger接口文档公开访问，保护接口安全

运行时请确认MySQL数据库已启动

前端默认端口为7777，后端默认8080，可根据实际修改

📄 开源协议
本项目基于 MIT License 许可证开源，欢迎学习、修改与传播，转载请注明出处。
作者联系方式：1329330944@qq.com
             kaitoyouka@163.com
