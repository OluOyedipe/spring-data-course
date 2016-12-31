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

        bookRepository.delete(1L)

        bookRepository.delete(bookRepository.findOne(2L))

        List<Book> books = bookRepository.findAll([1L, 2L, 3L])
        bookRepository.deleteInBatch(books)


	}
}
