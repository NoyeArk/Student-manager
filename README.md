# 学生信息管理系统
## 简介
该项目是大二学习java课程的大作业：学生信息管理系统
## 功能实现
要求1：带有图形界面  
要求2：有管理员和学生两种用户，登录时各自输入用户名密码  
要求3：系统至少能够管理100名学生，每一个学生有高数、英语、大学物理等三项成绩，每个学生登录后能够查看自己的成绩  
要求4：管理员登录后能够录入、修改、查询、删除任意学生任意课程的成绩  
要求5：能够将学生信息保存到硬盘，下次打开程序时还能够从硬盘读取  

## 程序概述
1. 本程序采用前后端框架，成功设计网页版的学生信息管理系统，用到的技术栈有Spring Boot + Vue + MySql + MyBatias。  
2. 通过Spring Boot来搭建后端框架，接受来自网页前端发送过来的请求，其中Spring Boot 是一个用于构建独立的、生产级的 Spring 应用程序的框架。它基于 Java 平台，并提供了一种简化的方式来创建和部署应用程序。Spring Boot 集成了 Spring 框架的各种功能和模块，同时还提供了一些自动化配置和约定。   
3. 采用Vue来设计学生信息管理系统前端登录界面，Vue是一个流行的前端 JavaScript 框架，用于构建用户界面。它专注于实现视图层的响应式和组件化开发，使得构建交互性和可复用的 Web 应用程序变得更加简单和高效，利用Vue发送请求给后端来进行相关业务的处理。  
4. 学生和管理员的相关信息是在MySql数据库中进行存放和处理，MySQL 是一个流行的开源关系型数据库管理系统（RDBMS），广泛用于 Web 应用程序和其他类型的软件开发中，同时在MySql进行相关表的设计，便于数据的管理和查询等处理操作。  
5. 连接数据库是通过MyBatias来进行，MyBatias是一个持久层框架，用于将 Java 对象与数据库进行映射。它提供了一种简单、直观的方式来访问和操作数据库，使得程序设计者能够更加轻松地处理数据库操作。综合上述技术成功设计出网页版学生信息管理系统。  

## 效果展示
![image](https://github.com/NoyeArk/student-manager/assets/112805800/53ccc05b-05dd-4eca-9366-294c2d52578b)
![image](https://github.com/NoyeArk/student-manager/assets/112805800/b7f4b679-54c9-420f-abe9-bae2d224b369)
![image](https://github.com/NoyeArk/student-manager/assets/112805800/98484358-2319-4342-9f81-1ccc197b9715)
![image](https://github.com/NoyeArk/student-manager/assets/112805800/fdd21670-21c1-457f-8188-35bb887067f4)
