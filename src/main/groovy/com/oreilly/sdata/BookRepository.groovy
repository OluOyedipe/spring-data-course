package com.oreilly.sdata

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by oo185005 on 12/30/16.
 */
@Repository
interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingOrderByTitleAsc(String title)
    List<Book> findByTitleContainingOrderByTitleDesc(String title)
}