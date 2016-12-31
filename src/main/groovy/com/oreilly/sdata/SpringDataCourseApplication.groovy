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

        bookRepository.findTopByOrderByPageCountDesc().each {
            log.info "$it"
        }

        bookRepository.findTop5ByOrderByPriceDesc().each {
            log.info "$it"
        }

        bookRepository.findTop5ByTitleOrderByPriceAsc('Animal Farm').each {
            log.info "$it"
        }





	}
}
