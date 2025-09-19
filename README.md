# SpringBoot2 适配 TongWeb7 示例项目

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.5-green.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/license-Apache--2.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![Java](https://img.shields.io/badge/Java-8+-blue.svg)](https://www.oracle.com/java/technologies/)

这是一个 Spring Boot 2 应用程序适配 TongWeb 7 服务器的参考示例项目。该项目演示了如何将 Spring Boot 默认的 Tomcat 服务器替换为 TongWeb 服务器。

## 目录

- [项目简介](#项目简介)
- [功能特性](#功能特性)
- [技术栈](#技术栈)
- [项目结构](#项目结构)
- [快速开始](#快速开始)
    - [环境要求](#环境要求)
    - [安装步骤](#安装步骤)
    - [构建项目](#构建项目)
    - [运行项目](#运行项目)
- [配置说明](#配置说明)
    - [Maven 配置](#maven-配置)
    - [应用配置](#应用配置)
- [API 接口](#api-接口)
- [依赖说明](#依赖说明)
- [常见问题](#常见问题)
- [许可证](#许可证)

## 项目简介

本项目是一个简单的 Spring Boot 2.5.5 应用程序，展示了如何将默认的 Tomcat 嵌入式服务器替换为 TongWeb 7 服务器。通过排除 Tomcat 依赖并引入 TongWeb 相关依赖，实现应用程序在 TongWeb 服务器上的运行。

## 功能特性

- Spring Boot 2.5.5 应用程序
- TongWeb 7 服务器集成
- 简单的 RESTful API 接口
- Maven 构建支持
- YAML 配置文件支持

## 技术栈

- Java 8
- Spring Boot 2.5.5
- TongWeb 7 (嵌入式应用服务器)
- Maven 3+

## 项目结构

```
.
├── src
│   └── main
│       ├── java
│       │   └── org
│       │       └── example
│       │           ├── App.java           // Spring Boot 启动类
│       │           └── TestController.java // 测试控制器
│       └── resources
│           └── application.yaml           // 应用配置文件
├── README.md                              // 项目说明文件
└── pom.xml                                // Maven 配置文件
```


## 快速开始

### 环境要求

- JDK 8 或更高版本
- Maven 3.6 或更高版本
- TongWeb 7 许可证（用于生产环境）

### 安装步骤

1. 克隆项目仓库：
```bash
git clone <repository-url>
cd springboot2-adapter-tongweb7-example
```


### 构建项目

使用 Maven 编译和打包项目：
```bash
mvn clean package
```


### 运行项目

有两种方式运行项目：

1. 使用 Maven 插件运行：
```bash
mvn spring-boot:run
```


2. 运行打包后的 JAR 文件：
```bash
java -jar target/springboot2-adapter-tongweb7-example-1.0-SNAPSHOT.jar
```


## 配置说明

### Maven 配置

关键的 Maven 配置包括：

1. 排除默认的 Tomcat 依赖：
```xml
<exclusion>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-tomcat</artifactId>
</exclusion>
```


2. 引入 TongWeb Starter 依赖：
```xml
<dependency>
    <groupId>tech.riemann</groupId>
    <artifactId>tongweb-embed</artifactId>
    <version>7.0.E.2_P1</version>
</dependency>
```


### 应用配置

在 [src/main/resources/application.yaml](file:///Users/yangzhao/Projects/IdeaProjects/springboot2-adapter-tongweb7-example/src/main/resources/application.yaml) 中配置 TongWeb 特定属性：

```yaml
server:
  port: 8080
  tongweb:
    uri-encoding: UTF-8
    license:
      type: file
      path: classpath:tongweb/license.dat
```


## API 接口

项目提供了一个简单的测试接口：

```
GET /msg/{message}
```


示例请求：
```
GET http://localhost:8080/msg/Hello
```


响应结果：
```
Hello World，Hello
```


## 依赖说明

项目主要依赖包括：

- `spring-boot-starter-web`：Spring Boot Web starter（已排除 Tomcat）
- `tech.riemann:tongweb-embed`：TongWeb 嵌入式服务器
- `spring-boot-starter-test`：测试相关依赖

## 常见问题

### 1. 依赖无法下载

如果遇到 TongWeb 相关依赖无法下载的问题：

- 确认可以访问包含 TongWeb 依赖的 Maven 仓库
- 检查版本号是否正确
- 如有需要，可替换为其他可用版本

### 2. 许可证问题

- 确保 [license.dat](file:///Users/yangzhao/Projects/IdeaProjects/springboot2-adapter-tongweb7-example/src/main/resources/tongweb/license.dat) 文件存在于 classpath 中
- 验证许可证的有效性

### 3. 主类配置问题

确保 pom.xml 中的 `mainClass` 配置正确：
```xml
<mainClass>org.example.App</mainClass>
```


## 许证证

本项目采用 Apache License 2.0 许可证。详情请见 [LICENSE](LICENSE) 文件。

**注意**：TongWeb 是商业软件，使用前请确保已获得相应授权。
