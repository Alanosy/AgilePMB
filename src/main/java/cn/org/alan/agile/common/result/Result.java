package cn.org.alan.agile.common.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一响应结构体
 *
 * @author Alan
 * @since 2022/1/30
 **/
@Data
public class Result<T> implements Serializable {

    private Integer code;

    private T data;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(String msg,T data) {
        Result<T> result = new Result<>();
        result.setCode(1);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(String msg) {
        Result<T> result = new Result<>();
        result.setCode(1);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static <T> Result<T> failed(String msg) {
        return result(0,msg , null);
    }

    private static <T> Result<T> result(Integer code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }
}
