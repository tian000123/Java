package week3;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String>studentMap = new HashMap<>();

        studentMap.put("S101","张三");
        studentMap.put("S102","李四");
        studentMap.put("S103","王五");
        System.out.println("新增三名学生：" + studentMap);



        System.out.println("---3. 修改操作（Update）---");
        System.out.println("修改前S101的学生是：" + studentMap.get("S101"));
        studentMap.put("S101","张三丰");
        System.out.println("修改后S101的学生是:" + studentMap.get("S101"));

        System.out.println("---4. 删除操作（Delete）---");
        System.out.println("删除前：" + studentMap);
        studentMap.remove("S103");
        System.out.println("删除S103后：" + studentMap);


    }
}
