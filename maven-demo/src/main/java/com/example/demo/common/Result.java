package com.example.demo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {
    private int code;
    private String msg;
    private T data;
    private long timestamp = System.currentTimeMillis();

    private Result(int c, String m, T d) {
        this.code = c;
        this.msg = m;
        this.data = d;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(0, "success", data);
    }

    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(code, message, null);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public long getTimestamp() {
        return timestamp;
    }
}