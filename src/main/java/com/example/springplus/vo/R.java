package com.example.springplus.vo;

import com.example.springplus.enums.StatusEnum;

import java.io.Serializable;

public class R<T> implements Serializable {
    private static final long serialVersionUID = 4165195776582571528L;
    protected String code;
    protected String message;
    private T data;

    private R() {
        this((T)null, StatusEnum.OK.getCode(), "");
    }

    private R(T data, String code, String message) {
        this.code = StatusEnum.OK.getCode();
        this.message = "";
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public static <T> R<T> ok() {
        return build(StatusEnum.OK.getCode(), StatusEnum.OK.getMessage());
    }

    public static <T> R<T> ok(T data) {
        return build(data, StatusEnum.OK.getCode(), StatusEnum.OK.getMessage());
    }

    public static <T> R<T> error() {
        return build(StatusEnum.ERROR.getCode(), StatusEnum.ERROR.getMessage());
    }

    public static <T> R<T> error(T data) {
        return build(data, StatusEnum.ERROR.getCode(), StatusEnum.ERROR.getMessage());
    }

    public static <T> R<T> error(String message) {
        return build(StatusEnum.ERROR.getCode(), message);
    }

    public static <T> R<T> build(T data, String code, String message) {
        return new R(data, code, message);
    }

    public static <T> R<T> build(String code, String message) {
        return build((T)null, code, message);
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public R<T> setCode(final String code) {
        this.code = code;
        return this;
    }

    public R<T> setMessage(final String message) {
        this.message = message;
        return this;
    }

    public R<T> setData(final T data) {
        this.data = data;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof R)) {
            return false;
        } else {
            R<?> other = (R)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label47;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label47;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof R;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "R(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }
}
