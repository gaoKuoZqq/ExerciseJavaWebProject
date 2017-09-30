package com.studentManagement_filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EnhancedRequest extends HttpServletRequestWrapper {    private HttpServletRequest request;
public EnhancedRequest(HttpServletRequest request) {
    super(request);
    this.request = request;
 }
 
 
 public String getParameter(String name) {
    String parameter = request.getParameter(name);//还是乱码
    if (parameter != null && !parameter.equals("")) {
        try {
            parameter = new String(parameter.getBytes("iso8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    return parameter;
 }
}
