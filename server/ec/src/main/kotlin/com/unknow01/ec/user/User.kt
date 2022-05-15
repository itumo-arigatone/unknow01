package com.unknow01.ec.user

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "user_information")
class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0;
    lateinit var name: String;
    lateinit var password: String;
    lateinit var email: String;
    var admin_flag: Boolean = false;

    constructor() {}

    constructor(name: String, password: String, email: String) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    constructor(name: String, password: String, email: String, admin_flag: Boolean) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.admin_flag = admin_flag;
    }

    constructor(id: Long, name: String, password: String, email: String, admin_flag: Boolean) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.admin_flag = admin_flag;
    }
}