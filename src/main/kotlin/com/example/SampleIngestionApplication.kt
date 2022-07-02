package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SampleIngestionApplication

fun main(args: Array<String>) {
	runApplication<SampleIngestionApplication>(*args)
}
