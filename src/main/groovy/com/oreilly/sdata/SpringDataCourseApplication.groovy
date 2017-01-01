package com.oreilly.sdata

import groovy.util.logging.Slf4j
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Slice
import org.springframework.data.domain.Sort

//@SpringBootApplication
//@EnableAutoConfiguration
@Slf4j
class SpringDataCourseApplication {

	static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration)

        BookRepository bookRepository = context.getBean(BookRepository)

        Page page = bookRepository.findByPageCountGreaterThan(120, new PageRequest(4, 3))

        log.info "Total objects: ${page.totalElements}"
        log.info "Total pages: ${page.totalPages}"

        page.each {
            log.info "$it"
        }

        Slice slice = bookRepository.findByPageCountLessThan(220, new PageRequest(0, 3))

        log.info "Total elements in slice: ${slice.numberOfElements}"
        log.info "Slice number: ${slice.number}"

        slice.each {
            log.info "$it"
        }








	}
}
