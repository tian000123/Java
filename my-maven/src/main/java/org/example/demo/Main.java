package org.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws Exception{
        Product product = new Product(1L, "Java编程思想", new BigDecimal("108.50"));
        Result<Product> result = Result.fail(0,"异常错误");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);
        System.out.println(json);
    }
}
