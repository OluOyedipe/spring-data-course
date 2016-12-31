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

        Book book = bookRepository.findOne(1L)
        log.info "$book"

        List<Book> books = bookRepository.findAll()

        books.each {
            log.info "$it"
        }

        books = bookRepository.findAll([1L, 3L, 7L])

        log.info "Using a filtered list"

        books.each {
            log.info "$it"
        }

	}
}
