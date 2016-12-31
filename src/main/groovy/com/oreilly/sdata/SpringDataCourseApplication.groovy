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

        Date date = new SimpleDateFormat('MM/dd/yyyy').parse('10/22/1995')
        Date date2 = new SimpleDateFormat('MM/dd/yyyy').parse('10/22/1997')

        bookRepository.findByPublishDateAfter(date).each {
            log.info "$it"
        }

        bookRepository.findByPublishDateBefore(date).each {
            log.info "$it"
        }

        bookRepository.findByPublishDateBetween(date, date2).each {
            log.info "$it"
        }



	}
}
