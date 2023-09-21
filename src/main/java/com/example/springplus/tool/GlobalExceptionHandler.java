package com.example.springplus.tool;

import com.example.springplus.enums.StatusEnum;
import com.example.springplus.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Iterator;

@RestControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 业务异常类
     */
    private static final Logger logger = LoggerUtils.getLogger(GlobalExceptionHandler.class);
    private static final String EXCEPTION_STR = GlobalException.class.getName() + ":" + " ";
    private static final String BUSINESS_EXCEPTION_TEMPLATE = "业务提示：{}";
    private static final String SYSTEM_EXCEPTION_TEMPLATE = "系统异常:";

    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({GlobalException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public R<?> exceptionHandler(GlobalException e) {
        R<?> error = R.build(e.getCode(), StringUtils.replace(e.getMessage(), EXCEPTION_STR, ""));
        logger.error("业务提示：{}", error.getMessage());
        return error;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public R<?> exceptionHandler(MethodArgumentNotValidException e) {
        StringBuilder message = new StringBuilder();
        if (e.getBindingResult() != null) {
            Iterator var4 = e.getBindingResult().getAllErrors().iterator();

            while(var4.hasNext()) {
                ObjectError obj = (ObjectError)var4.next();
                message.append(obj.getDefaultMessage());
                message.append(";");
            }
        } else {
            message.append(e.getMessage());
        }

        R<?> error = R.error(message.toString());
        logger.error("业务提示：{}", error.getMessage());
        return error;
    }

    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public R<?> exceptionHandler(BindException e) {
        StringBuilder message = new StringBuilder();
        if (e.getBindingResult() != null) {
            Iterator var4 = e.getBindingResult().getAllErrors().iterator();

            while(var4.hasNext()) {
                ObjectError obj = (ObjectError)var4.next();
                message.append(obj.getDefaultMessage());
                message.append(";");
            }
        } else {
            message.append(e.getMessage());
        }

        R<?> error = R.error(message.toString());
        logger.error("业务提示：{}", error.getMessage());
        return error;
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public R<?> exceptionHandler(Exception e) {
        logger.error("系统异常:", e);
        return R.build(StatusEnum.SYSTEM_ERROR.getCode(), "系统异常");
    }

}
