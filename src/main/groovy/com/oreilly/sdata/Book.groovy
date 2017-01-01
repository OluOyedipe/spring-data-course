package com.oreilly.sdata

import groovy.transform.Canonical
import org.springframework.data.jpa.repository.Query

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table

/**
 * Created by oo185005 on 12/30/16.
 */
@Table(name = 'BOOK')
@Entity
@Canonical
@NamedQueries([@NamedQuery(name = 'Book.queryOne', query = 'select b from Book b'),
@NamedQuery(name = 'Book.queryTwo', query = 'select b from Book b where b.pageCount > ?1'),
@NamedQuery(name = 'Book.queryThree', query = 'select b from Book b where b.title = :title')])
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = 'BOOK_ID')
    Long bookId

    @Column(name = 'TITLE')
    String title

    @Column(name = 'PAGE_COUNT')
    int pageCount

    @Column(name = 'PUBLISH_DATE')
    Date publishDate

    @Column(name = 'PRICE')
    BigDecimal price

    @ManyToOne
    @JoinColumn(name = 'AUTHOR_ID')
    Author author
}
