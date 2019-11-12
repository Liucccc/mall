package com.liucccc.mall.common.api;

import lombok.Data;

/**
 * Controller日志封装类
 *
 * @author liuchao
 * @date 2019-11-12 16:37
 */
@Data
public class WebLog {
    private String description;
    private String userName;
    private Long startTime;
    private Integer spendTime;
    private String basePath;
    private String uri;
    private String url;
    private String method;
    private String ip;
    private Object parameter;
    private Object result;
}
