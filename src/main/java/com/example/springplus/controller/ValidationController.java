package com.example.springplus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springplus.dto.UserDTO;
import com.example.springplus.entity.Usert;
import com.example.springplus.service.ValidationService;
import com.example.springplus.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
@Validated
@Api(value = "用户管理", tags = "用户管理")
public class ValidationController {
    @Autowired
    private ValidationService validationService;

    @PostMapping("/addUser")
    @ApiOperation(value = "新增用户")
    //这种方法异常不会在后台控制台输出
    public R<?> addUser(@RequestBody @Validated UserDTO user, BindingResult bindingResult) {
        validationService.addUser(user);
        return R.ok();
    }

    @PostMapping("/getUser")
    @ApiOperation(value = "获取用户")
    public R<Page<Usert>> getUser(@RequestBody @Validated UserDTO user) throws Exception {

        return R.ok(validationService.getUser(user));

    }
    // 使用form data方式调用接口，校验异常抛出 BindException
    // 使用 json 请求体调用接口，校验异常抛出 MethodArgumentNotValidException
    // 单个参数校验异常抛出ConstraintViolationException
    // 处理 json 请求体调用接口校验失败抛出的异常
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResultVo<String> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//        List<String> collect = fieldErrors.stream()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                .collect(Collectors.toList());
//        return new ResultVo(ResultCode.VALIDATE_FAILED, collect);
//    }

    // 使用form data方式调用接口，校验异常抛出 BindException
//    @ExceptionHandler(BindException.class)
//    public ResultVo<String> BindException(BindException e) {
//        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//        List<String> collect = fieldErrors.stream()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                .collect(Collectors.toList());
//        return new ResultVo(ResultCode.VALIDATE_FAILED, collect);
//    }
}
