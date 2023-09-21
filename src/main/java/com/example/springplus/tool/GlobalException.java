package com.example.springplus.tool;

import com.example.springplus.enums.StatusEnum;

public class GlobalException  extends RuntimeException{
    private static final long serialVersionUID = 3855927459930185464L;
    private String code;

    public GlobalException(String code, String message) {
        super();
        this.code = StatusEnum.ERROR.getCode();
        this.code = code;
    }

    public GlobalException(String message) {
        super();
        this.code = StatusEnum.ERROR.getCode();
    }

    public GlobalException(String message, Throwable cause) {
        super();
        this.code = StatusEnum.ERROR.getCode();
    }

    public GlobalException(Throwable cause) {
        super();
        this.code = StatusEnum.ERROR.getCode();
    }

    public GlobalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super();
        this.code = StatusEnum.ERROR.getCode();
    }

    public String getCode() {
        return this.code;
    }

    public GlobalException setCode(final String code) {
        this.code = code;
        return this;
    }

    public String toString() {
        return "GlobalException(code=" + this.getCode() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof GlobalException)) {
            return false;
        } else {
            GlobalException other = (GlobalException)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (!super.equals(o)) {
                return false;
            } else {
                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GlobalException;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = super.hashCode();
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        return result;
    }
}
