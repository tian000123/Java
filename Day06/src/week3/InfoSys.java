package week3;

import java.util.HashMap;
import java.util.Map;

public class InfoSys {
    public static void main(String[] args) {
        Map<String,User> userCache = new HashMap<>();
        userCache.put("13800001111",new User("张三", 25, "技术部"));
        userCache.put("13800002222",new User("李四", 30, "技术部"));
        userCache.put("13800003333",new User("王五", 28, "财务部"));

        System.out.println("--- 1.查询信息功能---");
        System.out.println("手机号13800001111对应的用户名字为：" + userCache.get("13800001111"));
        System.out.println("手机号13800001111对应的用户名字为：" + userCache.get("13800001111"));
        System.out.println("手机号13800001111对应的用户名字为：" + userCache.get("13800001111"));

        System.out.println("完整信息：" + userCache);

    }
}
