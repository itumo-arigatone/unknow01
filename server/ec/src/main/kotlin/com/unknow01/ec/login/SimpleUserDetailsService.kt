package com.unknow01.ec.login;

import com.unknow01.ec.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service("simpleUserDetailsService")
class SimpleUserDetailsService: UserDetailsService {
    var userRepository: UserRepository;

    constructor(userRepository: UserRepository) {
        this.userRepository = userRepository;
    }

    override fun loadUserByUsername(email: String): UserDetails {
        // emailでデータベースからユーザーエンティティを検索する
        val user: UserDetails = userRepository.findByEmail(email);
        if (user == null) {
            throw UsernameNotFoundException("user not found");
        }
        return user;
    }
}