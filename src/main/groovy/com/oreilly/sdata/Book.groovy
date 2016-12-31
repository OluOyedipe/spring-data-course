package com.oreilly.sdata

import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

/**
 * Created by oo185005 on 12/30/16.
 */
@Table(name = 'BOOK')
@Entity
@Canonical
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
