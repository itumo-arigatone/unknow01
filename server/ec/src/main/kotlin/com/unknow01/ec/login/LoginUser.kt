package com.unknow01.ec.login;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

class LoginUser: org.springframework.security.core.userdetails.User {

    private var user: com.unknow01.ec.user.User;

    constructor(user: com.unknow01.ec.user.User): super(user.name, user.password, determineRoles(user.admin_flag)) {
        this.user = user;
    }

    companion object {
        val USER_ROLES: List<GrantedAuthority> = AuthorityUtils.createAuthorityList("ROLE_USER");
        val ADMIN_ROLES: List<GrantedAuthority> = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");

        fun determineRoles(isAdmin: Boolean): List<GrantedAuthority> {
            return if (isAdmin)  ADMIN_ROLES else USER_ROLES;
        }
    }
}
