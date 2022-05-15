package com.unknow01.ec.login;

import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.http.HttpSession;
import org.springframework.security.web.WebAttributes;

class SimpleAuthenticationSuccessHandler: AuthenticationSuccessHandler {

    override fun onAuthenticationSuccess(request: HttpServletRequest,
                                        response: HttpServletResponse,
                                        auth: Authentication) {
        if (response.isCommitted()) {
            // log.info("Response has already been committed.");
            return;
        }

        response.setStatus(HttpStatus.OK.value());
        clearAuthenticationAttributes(request);
    }

    /**
     * Removes temporary authentication-related data which may have been stored in the
     * session during the authentication process.
     */
    fun clearAuthenticationAttributes(request: HttpServletRequest) {
        val session = request.getSession(false);
        if (session is HttpSession) {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }
    }
}