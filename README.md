# 🏥 养老院管理系统

[![Java](https://img.shields.io/badge/Java-1.8+-orange.svg)]()
[![Spring Boot](https://img.shields.io/badge/SpringBoot-2.x-brightgreen.svg)]()
[![MyBatis](https://img.shields.io/badge/MyBatis-ORM-blue.svg)]()
[![Vue3](https://img.shields.io/badge/Vue-3.x-brightgreen.svg)]()
[![Element Plus](https://img.shields.io/badge/Element_Plus-2.x-blue.svg)]()
[![License](https://img.shields.io/badge/license-MIT-green.svg)]()
[![Build](https://img.shields.io/badge/Build-Passing-brightgreen.svg)]()

> 基于 **Spring Boot + MyBatis + Vue3 + Element Plus** 开发的养老院管理系统。
> 系统涵盖老人入住管理、房间分配、护理服务、医疗记录、药品与设备管理、员工排班等模块，支持前后端分离，提供完整的 Swagger API 文档，方便二次开发与扩展。

---

## 📖 目录

* [项目简介](#-项目简介)
* [技术栈说明](#-技术栈说明)
* [功能模块](#-功能模块)
* [运行环境](#-运行环境)
* [安装与运行](#-安装与运行)
* [API 文档](#-api-文档)
* [目录结构](#-目录结构)
* [注意事项](#-注意事项)
* [开源协议](#-开源协议)

---

## 📌 项目简介

养老院管理系统旨在为养老院提供一体化的信息化管理解决方案。
系统实现了老人信息管理、房间与床位管理、护理与医疗记录、药品与器械管理、员工与角色权限管理等核心功能。
采用前后端分离架构，后端基于 Spring Boot + MyBatis，前端基于 Vue3 + Element Plus，确保良好的扩展性与可维护性。

---

## 🛠 技术栈说明

| 技术                    | 用途                            |
| --------------------- | ----------------------------- |
| **Spring Boot**       | 后端服务框架，快速搭建 RESTful 接口        |
| **MyBatis**           | 数据持久层框架，简化 SQL 操作             |
| **MySQL**             | 关系型数据库存储                      |
| **Vue3**              | 前端框架，构建响应式页面                  |
| **Element Plus**      | 前端 UI 组件库，提升开发效率              |
| **Swagger (Knife4j)** | API 接口文档生成与在线测试               |
| **Maven**             | 依赖管理与项目构建                     |
| **Lombok**            | 简化 Java 代码，自动生成 getter/setter |

---

## 📂 功能模块

* **老人信息管理**：老人基本信息、健康状况、入住/退住管理
* **房间与床位管理**：房间分配、床位状态、入住统计
* **护理服务管理**：护理服务记录、护理等级设置、护理人员分配
* **医疗记录管理**：老人病历、就诊记录、用药情况
* **药品与器械管理**：药品信息维护、库存管理、出入库记录
* **费用管理**：住宿费、护理费、医疗费的统计与账单生成
* **员工管理**：员工档案、岗位分配、排班管理
* **权限与角色管理**：用户登录、注册、权限分配、角色控制
* **数据导入导出**：支持 Excel 批量导入、模板下载
* **统计报表**：入住率统计、费用统计、服务质量分析

---

## 💻 运行环境

* **JDK**：1.8+
* **Maven**：3.6+
* **MySQL**：5.7 或以上
* **Node.js**：14+ （用于前端构建）
* **IDE**：推荐 IntelliJ IDEA / VSCode
* **操作系统**：Windows / macOS / Linux

---

## 🚀 安装与运行

### 1️⃣ 克隆项目

```bash
git clone https://github.com/your_repo/nursing_home_system.git
cd nursing_home_system
```

### 2️⃣ 数据库初始化

```sql
CREATE DATABASE nursing_home DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
```

### 3️⃣ 修改配置文件

编辑后端 `application.yml`，配置数据库账号密码：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/nursing_home?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai
    username: root
    password: your_password
server:
  port: 8080
```

### 4️⃣ 启动后端服务

```bash
mvn clean package
mvn spring-boot:run
```

### 5️⃣ 启动前端项目

```bash
cd frontend
pnpm install
pnpm run dev
```

### 6️⃣ 访问系统

* 后端 API 文档：[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* 前端页面：[http://localhost:7777](http://localhost:7777)

---

## 📑 API 文档

系统集成了 **Swagger UI / Knife4j**，支持接口在线调试与文档查看：
[http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

---

## ⚠ 注意事项

* 请确保数据库和配置文件的账号密码正确
* 前后端端口避免冲突，可根据实际修改
* 生产环境请关闭 Swagger 文档公开访问，提升安全性
* 确认 MySQL 服务已启动
* 前端默认端口为 7777，后端默认端口为 8080

---

## 📄 开源协议

本项目基于 **MIT License** 开源，欢迎学习、修改与传播，转载请注明出处。

作者联系方式：
📧 [1329330944@qq.com](mailto:1329330944@qq.com)
📧 [kaitoyouka@163.com](mailto:kaitoyouka@163.com)

---
