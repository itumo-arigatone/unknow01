package com.unknow01.ec.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unknow01.ec.user.User;
import com.unknow01.ec.user.UserService;

@RestController
@RequestMapping("/user")
class UserContoller {

    @Autowired
    lateinit var usrService: UserService;

	@PostMapping("/create_user")
	fun userRegistration(@RequestBody user: User): String {
        return usrService.userRegistration(user);
	}
}