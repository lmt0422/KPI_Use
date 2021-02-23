package com.alpinetech.common.exception;

import com.alpinetech.common.util.ResultCode;
import com.alpinetech.common.util.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * @author xmr
 * @date 2021/02/23 8:07
 * @description
 */


@RestControllerAdvice

public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = AlpinetechException.class)
    @ResponseBody
    public ResultVO bizExceptionHandler(HttpServletRequest req, AlpinetechException e) {
        logger.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return new ResultVO(Integer.valueOf(e.getErrorCode()), e.getErrorMsg(), e.getMessage());
    }

    /**
     * 处理空指针的异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultVO exceptionHandler(HttpServletRequest req, NullPointerException e) {
        logger.error("发生空指针异常！原因是:", e.getStackTrace());
        return new ResultVO(ResultCode.BODY_NOT_MATCH, e.getMessage());
    }

    /**
     * 处理其他异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVO exceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("未知异常！原因是:", e.getStackTrace());
        return new ResultVO(ResultCode.ERROR, e);
    }
}
