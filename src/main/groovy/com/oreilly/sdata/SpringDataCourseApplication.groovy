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

        Book book = new Book().with {
            title = 'Book title'
            pageCount = 100
            price = 100.0
            publishDate = new Date()

            it
        }

        bookRepository.save(book)

        List<Book> books = BookUtil.create(5)
        bookRepository.save(books)

	}
}
