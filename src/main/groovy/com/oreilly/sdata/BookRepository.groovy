package com.oreilly.sdata

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by oo185005 on 12/30/16.
 */
@Repository
interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByPageCountEquals(int pageCount)
    List<Book> findByPageCountGreaterThan(int pageCount)
    List<Book> findByPageCountLessThan(int pageCount)
    List<Book> findByPageCountGreaterThanEqual(int pageCount)
    List<Book> findByPageCountLessThanEqual(int pageCount)
    List<Book> findByPageCountBetween(int pageCountMin, int pageCountMax)
}