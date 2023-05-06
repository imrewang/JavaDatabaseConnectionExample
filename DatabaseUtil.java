package mysqlYF;

import java.sql.*;

public class DatabaseUtil {
    // 数据库连接对象
    private Connection conn = null;//与特定数据库的连接（会话）。
    // 操作句柄[执行SQL语句]
    private Statement stat = null;//用于执行静态SQL语句并返回其生成的结果的对象。
    // 结果集对象[获取查询的结果]
    private ResultSet rs = null;//表示数据库结果集的数据表，通常通过执行查询数据库的语句生成。

    // 连接相关的字符串对象
    String url = "jdbc:mysql://localhost:3306/homework?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
    //url - 格式为 jdbc:subprotocol:subname的数据库URL
    String username = "root";
    String password = "123zxcvbnm";

    // 通过反射机制讲jdbc的驱动jar包 动态的加载到JVM
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //forName() 返回与带有给定字符串名的类或接口相关联的 Class 对象
        } catch (ClassNotFoundException e) {//找不到具有指定名称的类的定义。
            e.printStackTrace();
        }
    }

    // 修改密码功能
    public void modify(String name, String pwd) {
        String sql = "update users set user_pwd='" + pwd + "' where user_name='" + name + "'";
        try {
            // 建立连接通道
            // DriverManager 管理一组 JDBC 驱动程序的基本服务。java.sql
            // getConnection() 返回： 到 URL 的连接
            conn = DriverManager.getConnection(url, username, password);
            // System.out.println("连接成功...");

            // 获取一个执行sql语句的对象
            // Statement 用于执行静态 SQL 语句并返回它所生成结果的对象。
            // createStatement()创建一个 Statement 对象来将 SQL 语句发送到数据库。
            stat = conn.createStatement();

            // 执行sql语句
            // 执行给定 SQL语句，语句可能为 INSERT、UPDATE 或 DELETE 语句，或不返回内容
            stat.execute(sql);
            System.out.println("修改成功");
        } catch (SQLException e) {
            System.out.println("修改失败");
            e.printStackTrace();
        } finally {
            if (null != stat) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // 删除用户功能
    public void delete(String name) {
        String sql = "delete from users where user_name='" + name + "'";
        try {
            // 建立连接通道
            // DriverManager 管理一组 JDBC 驱动程序的基本服务。java.sql
            // getConnection() 返回： 到 URL 的连接
            conn = DriverManager.getConnection(url, username, password);
            // System.out.println("连接成功...");

            // 获取一个执行sql语句的对象
            // Statement 用于执行静态 SQL 语句并返回它所生成结果的对象。
            // createStatement()创建一个 Statement 对象来将 SQL 语句发送到数据库。
            stat = conn.createStatement();

            // 执行sql语句
            // 执行给定 SQL语句，语句可能为 INSERT、UPDATE 或 DELETE 语句，或不返回内容
            stat.execute(sql);
            System.out.println("删除成功");
        } catch (SQLException e) {
            System.out.println("删除失败");
            e.printStackTrace();
        } finally {
            if (null != stat) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 注册用户功能
    public void register(String name, String pwd) {
        String sql = "insert into users values('" + name + "','" + pwd + "')";
        try {
            // 建立连接通道
            // DriverManager 管理一组 JDBC 驱动程序的基本服务。java.sql
            // getConnection() 返回： 到 URL 的连接
            conn = DriverManager.getConnection(url, username, password);
            // System.out.println("连接成功...");

            // 获取一个执行sql语句的对象
            // Statement 用于执行静态 SQL 语句并返回它所生成结果的对象。
            // createStatement()创建一个 Statement 对象来将 SQL 语句发送到数据库。
            stat = conn.createStatement();

            // 执行sql语句
            // 执行给定 SQL语句，语句可能为 INSERT、UPDATE 或 DELETE 语句，或不返回内容
            stat.execute(sql);
            System.out.println("注册成功");
        } catch (SQLException e) {
            System.out.println("注册失败");
            e.printStackTrace();
        } finally {
            if (null != stat) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // 登录
    public boolean isLogin(User user) {
        boolean login_win = false;
        String sql = "select * from users where user_name='" + user.getUserName() + "' and user_pwd='"
                + user.getUserPwd() + "'";
        try {
            // 建立连接通道
            // DriverManager 管理一组 JDBC 驱动程序的基本服务。java.sql
            // getConnection() 返回： 到 URL 的连接
            conn = DriverManager.getConnection(url, username, password);//DriverManager管理一组JDBC驱动程序的基本服务。
            //getConnection尝试建立与给定数据库URL的连接。
            // System.out.println("连接成功...");

            // 获取一个执行sql语句的对象
            // Statement 用于执行静态 SQL 语句并返回它所生成结果的对象。
            // createStatement()创建一个 Statement 对象来将 SQL 语句发送到数据库。
            stat = conn.createStatement();//创建一个Statement对象，用于将SQL语句发送到数据库。

            // 执行sql语句
            // 执行给定 SQL语句，语句可能为 INSERT、UPDATE 或 DELETE 语句，或不返回内容
            rs = stat.executeQuery(sql);//执行给定的SQL语句，该语句返回单个 ResultSet对象。

            if (rs.next()) {//将光标从当前位置向前移动一行。
                login_win = true;
            }

        } catch (SQLException e) {//提供有关数据库访问错误或其他错误的信息的异常。
            System.out.println("连接失败....");
            e.printStackTrace();
        } finally {
            if (null != rs) {
                try {
                    rs.close();//立即释放此 ResultSet对象的数据库和JDBC资源，而不是等待它自动关闭时发生。
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != stat) {
                try {
                    stat.close();//立即释放此 Statement对象的数据库和JDBC资源，而不是等待它自动关闭时发生。
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != conn) {
                try {
                    // 关闭连接
                    // 立即释放此 Connection 对象的数据库和 JDBC 资源，而不是等待它们被自动释放
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return login_win;
    }
}