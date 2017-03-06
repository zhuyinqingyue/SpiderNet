package com.spidernet.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spidernet.dashboard.entity.Employee;

/**
 * Page Interceptor.
 *
 * @author Fred Mao
 *
 */
public class PageInterceptor extends HandlerInterceptorAdapter
{
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception
    {
        String requestUri = request.getRequestURI();
        if (noFilter(requestUri))
        {
            return true;
        }
        final Employee emp = (Employee) request.getSession()
                .getAttribute("employee");

        if (emp == null && requestUri.indexOf("/service/") >= 0)
        {
            request.getRequestDispatcher("/service/manage/logout")
                    .forward(request, response);
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean noFilter(String requestUri)
    {
        if (requestUri.indexOf("service/manage/loginPage") > 0
                || requestUri.indexOf("service/manage/logout") > 0
                || requestUri.indexOf("service/manage/login") > 0
                || requestUri.indexOf("WEB-INF/page") > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}