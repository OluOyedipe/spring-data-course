package com.oreilly.sdata

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by oo185005 on 12/30/16.
 */
@Repository
interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingOrTitleContaining(String title, String title2)
    List<Book> findByTitleContainingAndPageCountGreaterThan(String title, int pageCount)
    List<Book> findByTitleNot(String title)
}