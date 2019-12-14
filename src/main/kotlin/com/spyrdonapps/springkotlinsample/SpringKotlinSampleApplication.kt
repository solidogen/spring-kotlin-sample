package com.spyrdonapps.springkotlinsample

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotlinSampleApplication

fun main(args: Array<String>) {
	runApplication<SpringKotlinSampleApplication>(*args) {
		setBannerMode(Banner.Mode.OFF)
	}
	println("XD")
}