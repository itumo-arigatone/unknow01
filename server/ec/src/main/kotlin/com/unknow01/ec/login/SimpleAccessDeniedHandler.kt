package com.unknow01.ec.login;

import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.access.AccessDeniedException;

class SimpleAccessDeniedHandler: AccessDeniedHandler {
    override fun handle(request: HttpServletRequest,
                        response: HttpServletResponse,
                        exception: AccessDeniedException) {
        response.sendError(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
    }
}