package com.unknow01.ec.login;

import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.core.AuthenticationException;

class SimpleAuthenticationEntryPoint: AuthenticationEntryPoint {

    override fun commence(request: HttpServletRequest,
                        response: HttpServletResponse,
                        exception: AuthenticationException) {
        if (response.isCommitted()) {
            // log.info("Response has already been committed.");
            return;
        }
        response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
    }

}