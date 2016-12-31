package com.oreilly.sdata

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by oo185005 on 12/30/16.
 */
@Service
class BookService {

    @Autowired
    BookRepository bookRepository

    void save(Book book) {
        bookRepository.save(book)
    }
}
