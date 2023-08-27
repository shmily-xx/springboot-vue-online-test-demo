package com.exam.util;



import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.sql.SQLException;

/**
 * 异常处理器
 * <p>
 * 使用Spring MVC的@ControllerAdvice注解做Json的异常处理
 * http://blog.csdn.net/z69183787/article/details/52290057
 *
 * @see RRException
 */
@RestControllerAdvice
public class RRExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return R.error(e);
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(RRException.class)
    public R handleRRException(RRException e) {
        R r = new R();
        r.put("code", e.getCode());
        r.put("message", e.getMessage());
        logger.error(e.getMessage(), e);
        e.printStackTrace();
        return r;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return R.error("数据库中已存在该记录");
    }

    @ExceptionHandler(AuthorizationException.class)
    public R handleAuthorizationException(AuthorizationException e) {
        logger.error(e.getMessage(), e);
        return R.error("没有权限，请联系管理员授权："+ e.getMessage());
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public R handleJSONConvertException(HttpMessageConversionException jsonEx) {    //JSON格式转换异常
        /**
         * 要打印堆栈信息，否则根据看不出来错误原因，一般业务逻辑不要直接抛出异常
         */
        String jsonError;
        if (jsonEx instanceof HttpMessageNotReadableException) {
            jsonError = "restful接口传递了后台不存在的实体对象，导致后台反序列化失败，请前端人员删除app或者js里面无用的属性.";
        } else {
            jsonError = "JSON格式转换异常," +
                    "1:json的属性java属性里面缺失;\\n " +
                    "2:如果使用ajax没有使用JSON.stringify把对象序列化为json字符串;\\n " +
                    "3:前端传入的属性和后台属性不一致\"" +
                    "4:如果本地是好的,服务器报错，就是编码格式有问题，两种方案：windows 安装版本 JAVA Options:增加【-Dfile.encoding=UTF-8、server.xml增加【URIEncoding='UTF-8'】\"" +
                    "5:详情查看错误日志)";
        }

        jsonEx.printStackTrace();
        return R.error(jsonError);
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public R handleRequestException(ServletRequestBindingException ex) {        //请求参数异常
        logger.error("请求参数异常(5)：" + ex.getMessage(), ex);
        String errorMsg = ex.getLocalizedMessage();
        if (ex instanceof MissingServletRequestParameterException) {
            errorMsg = "paramter参数缺失异常,请检查参数名称大小写，有无空格等：" + errorMsg;
        } else if (ex instanceof MissingPathVariableException) {
            errorMsg = "path参数缺失异常：" + errorMsg;
        }
        return R.error(errorMsg);
    }

    @ExceptionHandler(ConversionFailedException.class)
    public R handleTypeMismatchException(ConversionFailedException ex) {
        logger.error("spring类型转换异常 ConversionFailedException,(6)，请自定义类型转换器或者用@DateTimeFormat注解处理" + ex.getMessage(), ex);
        return R.error("spring类型转换异常 ConversionFailedException,(6)，请自定义类型转换器或者用@DateTimeFormat注解处理" + ex.getLocalizedMessage());
    }

    @ExceptionHandler(TypeMismatchException.class)
    public R handleTypeMismatchException(TypeMismatchException ex) {            //方法参数异常
        logger.error("方法参数异常(7)，请检查类型,后台 defaultValue 取值有问题" + ex.getMessage(), ex);
        return R.error("方法参数异常(7)，请检查类型,后台 defaultValue 取值有问题" + ex.getMessage());
    }

    @ExceptionHandler(HttpMediaTypeException.class)
    public R handleHttpMediaTypeException(HttpMediaTypeException ex) {            //方法参数异常
        logger.error("HttpMediaType异常(8)，请检查" + ex.getMessage(), ex);
        return R.error("HttpMediaType异常(8)，请检查" + ex.getMessage());
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public R handleInvalidDataAccessApiUsageException(InvalidDataAccessApiUsageException ex) {            //
        logger.error("InvalidDataAccessApiUsageException异常(9)，请检查" + ex.getMessage(), ex);
        return R.error("InvalidDataAccessApiUsageException错误，1:请检测自己的jsonFilter，是否包含空格等其符号 2:检查jpa @Modifying是否书写正确 3：其他,如查询jpa参数异常;详细信息:" + ex.getMessage());
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    public R handleRequestException(MissingServletRequestPartException ex) {        //请求参数异常
        logger.error("请求参数缺失(10)：" + ex.getMessage(), ex);
        String errorMsg = "请求参数缺失" + ex.getMessage();
        return R.error(errorMsg);
    }


    /**
     * @see
     * @see DataSourceProperties
     * <p>
     * unable to fetch a connection in 100 seconds, none available[size:100；busy:100；idle:0； lastwait：10000
     */
    @ExceptionHandler(SQLException.class)
    public R handleSQLException(SQLException ex) {
        logger.error("SQLException(10)，请检查" + ex.getMessage(), ex);
        return R.error("SQLException,sql异常，1：可能是数据库语法错误 2：sql数据库连接池获取异常:\" + ex.getMsg()");
    }

    /**
     * 请查看sql字段是否写错，是否缺少， 等等语法错误
     *
     * @param e
     * @return
     */
    @ExceptionHandler(UncategorizedSQLException.class)
    public R handleSqlException(UncategorizedSQLException e) {
        logger.error(e.getMessage(), e);
        return R.error("SQL语法错误，请检查SQL！");
        //return R.error("请不要随便写入emoji    表情！");
    }

    @ExceptionHandler(MultipartException.class)
    public R handleMultipartException(MultipartException e) {
        logger.error(e.getMessage(), e);
        return R.error("MultipartException:上传文件大小限制！");
    }
}
