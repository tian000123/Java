package org.example.demo.springbootdemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ============================================
 * 知识点：文件上传配置类
 * ============================================
 *
 * 【核心概念】
 * 使用 @ConfigurationProperties 批量绑定配置文件中的文件上传相关属性。
 * 这种方式适合配置项较多的场景，比 @Value 更便于管理和维护。
 *
 * 【配置前缀】
 * file.upload 对应配置文件中的 file.upload.xxx 属性
 *
 * 【使用场景】
 * 1. 文件上传大小限制
 * 2. 允许上传的文件类型
 * 3. 文件存储路径配置
 * 4. 文件访问URL前缀
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "file.upload")
public class FileUploadConfig {

    /**
     * 文件存储路径
     * 默认存储在项目运行目录下的 uploads 文件夹
     */
    private String path = "./uploads";

    /**
     * 文件访问URL前缀
     * 用于拼接文件访问地址
     */
    private String urlPrefix = "/uploads";

    /**
     * 允许上传的文件类型（白名单）
     * 多个类型用逗号分隔，如：jpg,png,gif,pdf
     * 为空表示允许所有类型（不推荐生产环境使用）
     */
    private String allowedTypes = "jpg,jpeg,png,gif,pdf,doc,docx,xls,xlsx,txt";

    /**
     * 单个文件最大大小（MB）
     * 默认 10MB
     */
    private Integer maxFileSize = 10;

    /**
     * 是否按日期创建子目录存储文件
     * 开启后文件将存储在 uploads/2024/01/01/ 这样的目录结构中
     */
    private Boolean useDatePath = true;
}
