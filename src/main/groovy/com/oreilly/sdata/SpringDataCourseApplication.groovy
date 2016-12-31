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

        bookRepository.findByTitleContainingOrTitleContaining('of', 'and').each {
            log.info "$it"
        }

        bookRepository.findByTitleContainingAndPageCountGreaterThan('of', 125).each {
            log.info "$it"
        }

        bookRepository.findByTitleNot('Animal Farm').each {
            log.info "$it"
        }

	}
}
