package com.example.demo;

import com.example.demo.common.Result;
import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper(); // 初始化序列化工具
        ProductService service = new ProductService(); // 初始化业务服务
        
        System.out.println("===== 场景1: 查询存在的商品 (ID: 1) =====");
        Result<ProductResponse> successRes = service.getProductById(1L);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(successRes));
        
        System.out.println("\n===== 场景2: 查询不存在的商品 (ID: 999) =====");
        Result<ProductResponse> failRes = service.getProductById(999L);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(failRes));
        
        System.out.println("\n===== 场景3: 分页查询 =====");
        ProductRequest req = new ProductRequest();
        req.setPageNum(1);
        req.setPageSize(10);
        Result<?> pageRes = service.list(req);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pageRes));
    }
}