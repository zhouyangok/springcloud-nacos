package com.authentication.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @ClassName HttpServletRequestAuthWrapper
 * @Description: TODO
 * @Author zhouyang
 * @Date 2021/8/14 下午5:36.
 */

public class HttpServletRequestAuthWrapper extends HttpServletRequestWrapper {
    private String url;
    private String method;

    /**
     * @param url
     * @param method
     */
    public HttpServletRequestAuthWrapper(HttpServletRequest request, String url, String method) {
        super(request);
        this.url = url;
        this.method = method;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public String getServletPath() {
        return this.url;
    }
}
