package com.aorez.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //看输出了解Filter执行流程
        System.out.println("FilterDemo doFilter ... before");

        //放行前，可以对request中的数据进行处理，比如编码转换等等
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
        //放行后，response中有了数据，可以在这里对其中的数据进行处理

        System.out.println("FilterDemo doFilter ... after");
    }

    @Override
    public void destroy() {

    }
}
