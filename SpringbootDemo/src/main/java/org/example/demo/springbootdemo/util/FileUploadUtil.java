package org.example.demo.springbootdemo.util;

import org.springframework.stereotype.Component;

@Component
public class FileUploadUtil {
    // 文件上传工具类，用于处理文件上传相关操作
    public String uploadFile(byte[] fileData, String fileName) {
        // 这里实现文件上传逻辑
        return "uploaded/" + fileName;
    }
}