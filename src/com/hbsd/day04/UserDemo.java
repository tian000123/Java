package com.hbsd.day04;

public class UserDemo {
    public static void main(String[] args) {
        VipUser user1 = new VipUser();
        user1.setName("张三");


        Address adr1 = new Address("河北省", "定州市");
        user1.setHomeAddress(adr1);

        System.out.println(user1);

    }
}
