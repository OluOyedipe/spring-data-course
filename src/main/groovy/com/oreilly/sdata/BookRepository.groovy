package com.oreilly.sdata

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

/**
 * Created by oo185005 on 12/30/16.
 */
@Repository
interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> queryOne()

    List<Book> queryTwo(int pageCount)

    List<Book> queryThree(@Param('title') String title)
}