package com.unknow01.ec.login;

import org.springframework.security.web.server.csrf.DefaultCsrfToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/prelogin")
class LoginController {

    @GetMapping
    fun preLogin(request: HttpServletRequest): String {
        val token = request.getAttribute("_csrf");
        if (token is DefaultCsrfToken) {
            return token.getToken();
        } else {
            throw RuntimeException("could not get a token");
        }
    }

}