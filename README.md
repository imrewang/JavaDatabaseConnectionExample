# JavaDatabaseConnectionExample

# 一、简介

java数据库连接示例，可以进行简单的增删改查

# 二、部署

## （一）建表语句

```
CREATE DATABASE homework;
```

```
USE homework;
```

```
CREATE TABLE `users` (
  `user_name` varchar(20) DEFAULT NULL,
  `user_pwd` varchar(20) DEFAULT NULL
) 
```

```
INSERT INTO users VALUES('admin','123');
INSERT INTO users VALUES('aa','111');
INSERT INTO users VALUES('bb','222');
```

## （二）运行

运行test.java

# 三、运行截图



# 四、总结

## （一）JDBC

JDBC（Java Database Connectivity）是Java编程语言中用于连接和操作数据库的标准API。它提供了一个标准的接口，使Java应用程序能够与各种数据库进行交互，例如MySQL、Oracle、PostgreSQL等等。

JDBC API由Java标准库中的一组接口和类组成，它们定义了一组通用的数据库访问方法和属性，包括连接数据库、执行SQL语句、处理结果集等。这使得Java开发人员可以使用统一的方式来访问不同的数据库，并且可以轻松地将Java应用程序与不同的数据库进行集成。

JDBC API还提供了一组驱动程序，用于连接特定类型的数据库。每个驱动程序都实现了JDBC接口，以便Java应用程序可以通过它来连接和操作数据库。开发人员可以选择使用适合他们需要的驱动程序，以便将Java应用程序连接到特定的数据库。



