package com.unknow01.ec

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
class EcApplication
fun main(args: Array<String>) {
    runApplication<EcApplication>(*args)
}

