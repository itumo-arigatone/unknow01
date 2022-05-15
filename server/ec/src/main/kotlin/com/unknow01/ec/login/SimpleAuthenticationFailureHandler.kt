package com.unknow01.ec.login;

import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.core.AuthenticationException;

class SimpleAuthenticationFailureHandler: AuthenticationFailureHandler {

    override fun onAuthenticationFailure(request: HttpServletRequest,
                                        response: HttpServletResponse,
                                        exception: AuthenticationException) {
        response.sendError(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
    }

}