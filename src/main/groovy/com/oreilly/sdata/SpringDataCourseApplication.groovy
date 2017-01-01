package com.oreilly.sdata

import groovy.util.logging.Slf4j
import org.springframework.context.annotation.AnnotationConfigApplicationContext

//@SpringBootApplication
//@EnableAutoConfiguration
@Slf4j
class SpringDataCourseApplication {

	static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration)

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
