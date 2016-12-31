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

        bookRepository.findByPageCountEquals(300).each {
            log.info "$it"
        }

        bookRepository.findByPageCountLessThan(150).each {
            log.info "$it"
        }

        bookRepository.findByPageCountBetween(160, 220).each {
            log.info "$it"
        }

	}
}
