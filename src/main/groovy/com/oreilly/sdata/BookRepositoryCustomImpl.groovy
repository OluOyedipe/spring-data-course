package com.oreilly.sdata

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import javax.persistence.EntityManager

/**
 * Created by oo185005 on 12/31/16.
 */
@Slf4j
@Repository
class BookRepositoryCustomImpl implements BookRepositoryCustom {

    @Autowired
    EntityManager entityManager

    @Override
    @Transactional
    void saveAndLog(Book book) {
        log.info "Saving the book entity $book"
        entityManager.persist(book)
    }
}
