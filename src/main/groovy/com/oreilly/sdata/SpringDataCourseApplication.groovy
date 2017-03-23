package com.oreilly.sdata

import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext

//@SpringBootApplication
//@EnableAutoConfiguration
@SpringBootApplication
@Slf4j
class SpringDataCourseApplication {

	static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataCourseApplication)

        BookRepository bookRepository = context.getBean(BookRepository)

        log.info "${bookRepository.setPageCount('Animal Farm', 1000)}"

        bookRepository.findAll().each {
            log.info "$it"
        }

        log.info "${bookRepository.setPageCount('%and%', 1000)}"

        bookRepository.findAll().each {
            log.info "$it"
        }







	}
}
