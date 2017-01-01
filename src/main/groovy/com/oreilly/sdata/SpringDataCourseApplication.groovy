package com.oreilly.sdata

import groovy.util.logging.Slf4j
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.data.domain.PageRequest

//@SpringBootApplication
//@EnableAutoConfiguration
@Slf4j
class SpringDataCourseApplication {

	static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration)

        BookRepository bookRepository = context.getBean(BookRepository)

        bookRepository.findAll(new PageRequest(1, 4)).each {
            log.info "$it"
        }

        bookRepository.findByPageCountGreaterThan(150, new PageRequest(1, 3)).each {
            log.info "$it"
        }







	}
}
