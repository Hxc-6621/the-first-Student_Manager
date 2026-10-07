# 基于 JDBC 的数据库版学生管理系统

## 📖 项目介绍
这是一个基于 Java 控制台实现的学生信息管理应用。项目采用分层设计思想，将业务交互与数据访问分离，数据持久化存储在 MySQL 数据库中。本项目是从“内存版（ArrayList）学生管理系统”升级而来，解决了程序关闭后数据丢失的问题，旨在实战演练 JDBC 核心 API 与 DAO 设计模式。

## 🛠️ 技术栈
- **语言**：Java SE (JDK 21)
- **数据库**：MySQL 8.0
- **数据访问**：原生 JDBC (PreparedStatement)
- **构建工具**：Maven
- **版本控制**：Git

## ✨ 功能列表
- [x] 添加学生信息（学号、姓名、年龄、成绩）
- [x] 删除学生信息（根据学号）
- [x] 修改学生信息（根据学号）
- [x] 查看所有学生信息
- [x] 根据学号精确查询学生
- [x] 控制台菜单交互循环

## 📂 项目结构
```text
src/main/java/org/example/
├── Student.java          # 实体类，封装学生信息
├── DBUtil.java           # 数据库工具类，负责连接获取与资源释放
├── StudentDao.java       # 数据访问层，封装所有 JDBC 操作（CRUD）
└── StudentManager.java   # 交互层，提供控制台菜单与用户交



🐛 开发过程中遇到的问题与解决（踩坑记录）
java.sql.SQLException: Column count doesn't match value count

原因：INSERT 语句未指定列名，且传参数量与表中列数量不匹配。

解决：在 SQL 中明确指定列名 INSERT INTO student (id, name, age, score) VALUES (?, ?, ?, ?)，并确保参数个数对应。

java.sql.SQLException: Parameter index out of range (4 > number of parameters, which is 3)

原因：SQL 中只有 3 个 ? 占位符，但代码中调用了 ps.setInt(4, ...)。

解决：检查 SQL 与 setXxx 的索引，确保一一对应（JDBC 索引从 1 开始）。

ClassNotFoundException: com.mysql.cj.jdbc.Driver 或驱动加载警告

原因：Maven 依赖未成功下载，或误用了旧版驱动名。

解决：配置阿里云 Maven 镜像下载 mysql-connector-j，并将驱动类名统一改为 com.mysql.cj.jdbc.Driver。

时区与中文乱码问题

原因：MySQL 8.0 的默认时区识别和字符编码配置问题。

解决：在 URL 中追加参数 ?useSSL=false&serverTimezone=UTC&characterEncoding=utf8。

🚧 未来优化方向
□ 引入连接池（如 Druid/HikariCP）替代原生 DriverManager，提升性能。
□ 增加输入校验和统一异常处理。
□ 引入 Spring Boot + MyBatis 框架，进一步简化开发。
## 