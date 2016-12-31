package com.oreilly.sdata

import org.springframework.context.annotation.AnnotationConfigApplicationContext

//@SpringBootApplication
//@EnableAutoConfiguration
class SpringDataCourseApplication {

	static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration)
		BookService bookService = context.getBean(BookService)

		Book book = new Book(title: 'A good book', pageCount: 300, publishDate: new Date(), price: 152.22)

		bookService.save(book)

	}
}
