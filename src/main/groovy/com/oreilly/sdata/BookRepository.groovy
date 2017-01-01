package com.oreilly.sdata

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

/**
 * Created by oo185005 on 12/30/16.
 */
@Repository
interface BookRepository extends JpaRepository<Book, Long> {

    @Query('select b from Book b')
    List<Book> queryOne()

    @Query('select b from Book b where b.pageCount > ?1')
    List<Book> queryTwo(int pageCount)

    @Query('select b from Book b where b.title = :title')
    List<Book> queryThree(@Param('title') String title)
}