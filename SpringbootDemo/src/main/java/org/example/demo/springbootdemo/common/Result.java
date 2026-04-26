package org.example.demo.springbootdemo.common;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * ============================================
 * 知识点：统一响应结果封装
 * ============================================
 * 
 * 【核心概念】
 * 在RESTful API开发中，为了统一接口返回格式，通常会封装一个通用的响应结果类。
 * 这样做的好处：
 * 1. 前端可以统一处理响应结构
 * 2. 便于接口文档生成
 * 3. 方便添加统一的响应信息（如时间戳、请求ID等）
 * 
 * 【响应结构说明】
 * {
 *   "code": 200,          // 业务状态码
 *   "message": "success", // 提示信息
 *   "data": { ... },      // 业务数据
 *   "timestamp": ...      // 时间戳
 * }
 * 
 * @param <T> 响应数据的类型
 */
@Data
public class Result<T> {

    /**
     * 业务状态码
     * 200 - 成功
     * 400 - 请求参数错误
     * 401 - 未授权
     * 403 - 禁止访问
     * 404 - 资源不存在
     * 500 - 服务器内部错误
     */
    private Integer code;

    /**
     * 提示信息
     * 成功时为"success"或操作成功的描述
     * 失败时为错误原因
     */
    private String message;

    /**
     * 响应数据
     * 成功时返回业务数据
     * 失败时可能为null
     */
    private T data;

    /**
     * 时间戳
     * 记录响应生成的时间
     */
    private LocalDateTime timestamp;

    /**
     * 私有构造方法，强制使用静态工厂方法创建实例
     */
    private Result() {
        this.timestamp = LocalDateTime.now();
    }

    /**
     * ============================================
     * 成功响应 - 不带数据
     * ============================================
     * 使用场景：删除、更新等操作成功，无需返回数据
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        return result;
    }

    /**
     * ============================================
     * 成功响应 - 带数据
     * ============================================
     * 使用场景：查询操作成功，需要返回数据
     * 
     * @param data 业务数据
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }

    /**
     * ============================================
     * 成功响应 - 自定义消息
     * ============================================
     * @param message 自定义成功消息
     * @param data 业务数据
     */
    public static <T> Result<T> success(String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * ============================================
     * 失败响应
     * ============================================
     * 使用场景：业务处理失败
     * 
     * @param code 错误码
     * @param message 错误信息
     */
    public static <T> Result<T> error(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * ============================================
     * 失败响应 - 简化版
     * ============================================
     * 使用默认错误码500
     * 
     * @param message 错误信息
     */
    public static <T> Result<T> error(String message) {
        return error(500, message);
    }

    /**
     * 参数错误响应
     */
    public static <T> Result<T> badRequest(String message) {
        return error(400, message);
    }

    /**
     * 资源不存在响应
     */
    public static <T> Result<T> notFound(String message) {
        return error(404, message);
    }

    /**
     * 判断响应是否成功
     */
    public boolean isSuccess() {
        return code != null && code == 200;
    }
}
