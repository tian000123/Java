package com.example.demo.service;

import com.example.demo.common.Result;
import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.exception.BusinessException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
    private static final Map<Long, ProductResponse> productDB = new HashMap<>();
    
    static {
        // 初始化数据
        ProductResponse p1 = new ProductResponse();
        p1.setId(1L);
        p1.setName("Java编程思想");
        p1.setPrice(108.50);
        p1.setCreateTime(new Date());
        
        ProductResponse p2 = new ProductResponse();
        p2.setId(2L);
        p2.setName("Spring实战");
        p2.setPrice(89.00);
        p2.setCreateTime(new Date());
        
        productDB.put(p1.getId(), p1);
        productDB.put(p2.getId(), p2);
    }
    
    public Result<ProductResponse> getProductById(Long id) {
        try {
            ProductResponse p = productDB.get(id);
            if (p == null) {
                throw new BusinessException(1001, "商品不存在");
            }
            if (new BigDecimal(String.valueOf(p.getPrice())).compareTo(BigDecimal.ZERO) <= 0) {
                throw new BusinessException(1002, "价格异常");
            }
            return Result.success(p);
        } catch (BusinessException e) {
            return Result.fail(e.getCode(), e.getMessage());
        }
    }
    
    public Result<Map<String, Object>> list(ProductRequest req) {
        try {
            // 1. 入参校验
            if (req.getPageNum() <= 0 || req.getPageSize() <= 0) {
                throw new BusinessException(400, "分页参数错误");
            }
            
            // 2. 模拟复杂的分页查询逻辑
            List<ProductResponse> list = productDB.values().stream().collect(Collectors.toList());
            Map<String, Object> result = new HashMap<>();
            result.put("list", list);
            result.put("total", list.size());
            
            return Result.success(result);
        } catch (BusinessException e) {
            return Result.fail(e.getCode(), e.getMessage());
        }
    }
}