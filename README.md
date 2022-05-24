## 前言

- **icu** 项目刚刚成立，后继会继续更新维护
- 开源不易，点个 star 鼓励一下吧！
- [文档](https://console-docs.apipost.cn/preview/aa8ebdbc68707824/e24bf5dfe1624a8c?target_id=8c31e96c-7cdb-4ee6-b0e0-f4e0d8477798#001)

## icu 介绍

**icu** 是一个 **spring boot** 微服务框架，技术质量自我感觉良好，哈哈。

## 数据库

- **icu** 默认数据库 **PostgreSQL** 简称 **PG**，**PG** 具备更高的可靠性，对数据一致性完整性的支持高于 **MySQL**，因此 **PG** 更加适合严格的企业应用场景(比如金融、电信、ERP、CRM)；而 **MySQL** 查询速度较快，更加适合业务逻辑相对简单、数据可靠性要求较低的互联网场景(比如google、facebook、alibaba)。
- 如果不习惯 **PG** 的朋友，可以考虑使用 **MariaDB**，**MariaDB** 经常与 **MySQL** 混淆，它是 **MySQL** 的一个开源分支，速度更快，提供更多存储引擎，但功能有限。**MySQL** 和 **MariaDB** 使用的存储引擎都是 InnoDB。InnoDB 提供标准的 ACID 兼容特性。与 **MySQL** 不同，**MariaDB** 不支持数据屏蔽或动态列。
- **PostgreSQL** 与 **MySQL** 相比， [具体介绍](https://www.zhihu.com/question/20010554/answers/updated)

## 相关技术与文档

| 技术                                                                                                                  | 简介                                                                   | 
|:--------------------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------|
| [MyBatis-Plus](https://baomidou.com/)                                                                               | MyBatis (opens new window)的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生。 |
| [Sa-Token](https://sa-token.dev33.cn/)                                                                              | 一个轻量级 java 权限认证框架，让鉴权变得简单、优雅！                                        | 
| [JustAuth](https://justauth.wiki/)                                                                                  | 开箱即用的整合第三方登录的开源组件                                                    | 
| [fastjson2](https://alibaba.github.io/fastjson2/)                                                                   | FASTJSON项目的重要升级，目标是为下一个十年提供一个高性能的JSON库                               | 
| [hutool-core](https://www.hutool.cn/docs/index.html#/?id=%f0%9f%9b%a0%ef%b8%8f%e5%8c%85%e5%90%ab%e7%bb%84%e4%bb%b6) | 核心，包括Bean操作、日期、各种Util等                                               | 