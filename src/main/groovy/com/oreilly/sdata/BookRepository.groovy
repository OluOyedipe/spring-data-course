package com.oreilly.sdata

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by oo185005 on 12/30/16.
 */
@Repository
interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findByPageCountGreaterThan(int pageCount, Pageable pageable)
    Slice<Book> findByPageCountLessThan(int pageCount, Pageable pageable)
}