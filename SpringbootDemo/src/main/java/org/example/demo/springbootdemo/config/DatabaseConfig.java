package org.example.demo.springbootdemo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * ============================================
 * 知识点：@Value 注解配置属性注入
 * ============================================
 * 
 * 【核心概念】
 * @Value 注解用于将配置文件中的单个属性值注入到Bean的字段中。
 * 它支持SpEL表达式，功能更加灵活，但不适合批量绑定。
 * 
 * 【SpEL表达式简介】
 * SpEL是Spring的表达式语言，语法类似EL表达式。
 * 基本用法：
 *   - #{value}         直接值，如 #{123}、#{'hello'}
 *   - #{bean.property} 访问Bean属性
 *
 * 【语法说明】
 * 1. ${property:default} - 从配置文件读取属性，可指定默认值
 * 2. #{expression} - 使用SpEL表达式
 * 3. ${property} - 直接从配置文件读取，无默认值
 * 
 * 【使用场景】
 * 1. 只需要注入少量配置时
 * 2. 需要使用SpEL表达式时
 * 3. 需要设置默认值时
 * 4. 注入系统属性或环境变量时
 * 
 * 【示例说明】
 * 本类演示了使用@Value注解注入数据库相关配置
 * 实际项目中，这些配置通常来自application.yml或application.properties
 */
@Data
@Configuration
public class DatabaseConfig {

    /**
     * 注入数据库URL，设置默认值
     * 语法：${key:default_value}
     * 如果配置文件中未定义db.url，则使用默认值
     *
     * 【PostgreSQL URL格式】
     * jdbc:postgresql://host:port/database
     * 默认端口：5432
     */
    @Value("${db.url:jdbc:postgresql://localhost:5432/springboot_demo}")
    private String url;

    /**
     * 注入数据库用户名，设置默认值
     * PostgreSQL默认用户名：postgres
     */
    @Value("${db.username:postgres}")
    private String username;

    /**
     * 注入数据库密码，设置默认值
     */
    @Value("${db.password:postgres}")
    private String password;

    /**
     * 注入数据库驱动类名，设置默认值
     * PostgreSQL驱动类：org.postgresql.Driver
     */
    @Value("${db.driver-class-name:org.postgresql.Driver}")
    private String driverClassName;

    /**
     * 注入连接池最大连接数
     * 使用SpEL表达式进行计算：${max-connections:10}
     */
    @Value("${db.max-connections:10}")
    private Integer maxConnections;

    /**
     * 注入连接池最小空闲连接数
     */
    @Value("${db.min-idle:5}")
    private Integer minIdle;

    /**
     * 注入连接超时时间（毫秒）
     */
    @Value("${db.connection-timeout:30000}")
    private Long connectionTimeout;

}
