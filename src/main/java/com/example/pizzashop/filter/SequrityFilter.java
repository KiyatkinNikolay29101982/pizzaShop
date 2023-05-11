package com.example.pizzashop.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//@WebFilter("/*")
public class SequrityFilter implements Filter {
    private static final List<String> PROTECTED_URIS = Arrays.asList("/shopper");
    private static final String DEFAULT_AUTRHENTIFICATED_ATRIBUTE_NAME = "isLogin";

    private static final List<String> NOT_ACCESED_AFTER_AUTHENTIFICATION = Arrays.asList("","");

    private static final String REDIRECT_URIS = "/shopper";

    private static final String DEFAULT_LOGING_URI = "/login";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if(isProtected(req)){
            if(isAuthenticated(req)){
                chain.doFilter(req, resp);
            }else {
                resp.sendRedirect(DEFAULT_LOGING_URI);
            }
            return;
        }

        if(isAuthenticated(req) && NOT_ACCESED_AFTER_AUTHENTIFICATION.contains(req.getRequestURI())){
            resp.sendRedirect(REDIRECT_URIS);
            return;
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private boolean isAuthenticated(HttpServletRequest request){
        HttpSession session = request.getSession(false);

        if(session == null){
            return false;
        }
        Boolean sessionResult = (Boolean) session.getAttribute(DEFAULT_AUTRHENTIFICATED_ATRIBUTE_NAME);
        return sessionResult != null && sessionResult;
    }

    private boolean isProtected(HttpServletRequest request){

        return  PROTECTED_URIS.contains(request.getRequestURI());
    }
}
