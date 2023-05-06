package mysqlYF;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println("请选择你的操作：a.登录用户 b.修改密码 c.删除用户 d.注册用户");
        Scanner sc = new Scanner(System.in);//构造一个新的 Scanner ，它生成从指定输入流扫描的值。
        String function = sc.next().trim();
        //next从此扫描仪查找并返回下一个完整令牌。
        //trim返回一个字符串，其值为此字符串，删除了所有前导和尾随空格，其中space被定义为其代码点小于或等于 'U+0020' （空格字符）的任何字符。
        switch (function) {
            case "a":
                t.login();
                break;

            case "b":
                t.modify();
                break;

            case "c":
                t.delete();
                break;

            case "d":
                t.register();
                break;
            default:
                System.out.println("输入格式有误，请重新输入");
        }
    }

    // 修改密码
    public void modify() {
        DatabaseUtil dbUtil = new DatabaseUtil();
        Scanner s = new Scanner(System.in);//“标准”输入流。 此流已打开并准备好提供输入数据。
        System.out.println("请输入用户名：");//“标准”输出流。
        String uname = s.next().trim();
        System.out.println("请输入新密码：");
        String upwd = s.next().trim();
        dbUtil.modify(uname, upwd);
    }

    // 删除
    public void delete() {
        DatabaseUtil dbUtil = new DatabaseUtil();
        System.out.println("请输入要删除的用户名");
        Scanner s = new Scanner(System.in);
        String uname = s.next().trim();
        dbUtil.delete(uname);
    }

    public void login() {
        DatabaseUtil dbUtil = new DatabaseUtil();
        Scanner s = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String uname = s.next().trim();
        System.out.println("请输入密码：");
        String upwd = s.next().trim();
        User user = new User(uname, upwd);

        if (dbUtil.isLogin(user)) {
            System.out.println("登录成功...");
        } else {
            System.out.println("登陆失败...");
        }
    }

    // 注册用户
    public void register() {
        DatabaseUtil dbUtil = new DatabaseUtil();
        Scanner s = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String uname = s.next().trim();
        System.out.println("请输入密码：");
        String upwd = s.next().trim();
        dbUtil.register(uname, upwd);
    }

}

