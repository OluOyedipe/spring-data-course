package com.oreilly.sdata

import groovy.util.logging.Slf4j
import org.springframework.context.annotation.AnnotationConfigApplicationContext

import java.text.SimpleDateFormat

//@SpringBootApplication
//@EnableAutoConfiguration
@Slf4j
class SpringDataCourseApplication {

	static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration)

        BookRepository bookRepository = context.getBean(BookRepository)

        bookRepository.queryOne().each {
            log.info "$it"
        }

        bookRepository.queryTwo(200).each {
            log.info "$it"
        }

        bookRepository.queryThree('Animal Farm').each {
            log.info "$it"
        }






	}
}
