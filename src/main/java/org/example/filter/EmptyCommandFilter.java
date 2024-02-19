package org.example.filter;

import org.example.result.RedirectResult;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.example.Resources.*;

public class EmptyCommandFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (servletRequest.getParameter("command") == null) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            httpServletRequest.getRequestDispatcher(COMMAND_SHOW_CHAT_PAGE).forward(servletRequest, servletResponse);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
