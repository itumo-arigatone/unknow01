package com.unknow01.ec.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails;
import com.unknow01.ec.user.User;

interface UserRepository: JpaRepository<User, Long> {

    fun findByEmail(email: String): User?;
}