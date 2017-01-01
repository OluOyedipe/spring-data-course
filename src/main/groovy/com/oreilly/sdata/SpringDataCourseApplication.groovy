package com.oreilly.sdata

import groovy.util.logging.Slf4j
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.data.domain.Sort

//@SpringBootApplication
//@EnableAutoConfiguration
@Slf4j
class SpringDataCourseApplication {

	static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration)

        BookRepository bookRepository = context.getBean(BookRepository)

        bookRepository.findAll(new Sort('pageCount')).each {
            log.info "$it"
        }

        bookRepository.findAll(new Sort(Sort.Direction.DESC, 'pageCount')).each {
            log.info "$it"
        }

        bookRepository.findAll(new Sort(Sort.Direction.ASC, 'author.lastName', 'pageCount')).each {
            log.info "$it"
        }

        bookRepository.findAll(new Sort(Sort.Direction.ASC, 'author.lastName')
                .and(new Sort(Sort.Direction.DESC, 'pageCount'))).each {
            log.info "$it"
        }

        bookRepository.findByPageCountGreaterThan(220, new Sort('author.lastName')).each {
            log.info "$it"
        }








	}
}
