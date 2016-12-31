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

        book.title = 'War And Peace'
        bookRepository.save(book)

        log.info "$book"

        book.bookId = 1000L
        bookRepository.save(book)

        log.info "$book"

	}
}
