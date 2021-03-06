package cn.uglyservant.common.service.handler;

import cn.uglyservant.common.global.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R error(Exception e) {
        log.error(e.getLocalizedMessage(), e);
        return R.error(e.getLocalizedMessage());
    }
}
