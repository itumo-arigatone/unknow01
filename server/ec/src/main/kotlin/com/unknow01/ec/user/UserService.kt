package com.unknow01.ec.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.unknow01.ec.user.User;
import com.unknow01.ec.user.UserRepository;

@Service
class UserService {
  
  @Autowired
  lateinit var usrRepository: UserRepository;

  fun userRegistration(user: User): String {
    // 暗号化して登録。
    val encoder: PasswordEncoder = BCryptPasswordEncoder();
    // var user: User = user;
    user.password = encoder.encode(user.password);
    usrRepository.save(user);
    // saveが成功したら
    return "Success";
  }
}