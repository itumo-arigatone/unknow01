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
    @Column(name = "id")
    var id: Long = 0;
    @Column(name = "name")
    lateinit var name: String;
    @Column(name = "password")
    lateinit var password: String;
    @Column(name = "email")
    lateinit var email: String;

    constructor() {}

    constructor(name: String, password: String, email: String) {
        System.out.println("3");
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        this.id = 0
        this.name = name;
        this.password = password;
        this.email = email;
    }

    constructor(id: Long, name: String, password: String, email: String) {
        System.out.println("4");
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}