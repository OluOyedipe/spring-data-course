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

        log.info "${bookRepository.findByTitle('Design Patterns')}"

        bookRepository.findByTitleLike('%of%').each {
            log.info "$it"
        }

        bookRepository.findByTitleContaining('of').each {
            log.info "$it"
        }

        bookRepository.findByTitleStartingWith('O').each {
            log.info "$it"
        }

        bookRepository.findByTitleEndingWith('s').each {
            log.info "$it"
        }

        bookRepository.findByTitleIgnoreCase('DESIGN PATTERNS').each {
            log.info "$it"
        }

	}
}
