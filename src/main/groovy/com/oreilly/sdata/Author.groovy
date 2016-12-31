package com.oreilly.sdata

import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by oo185005 on 12/31/16.
 */
@Canonical
@Entity
@Table(name = 'AUTHOR')
class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = 'AUTHOR_ID')
    Long authorId

    @Column(name = 'FIRST_NAME')
    String firstName

    @Column(name = 'LAST_NAME')
    String lastName

    @Column(name = 'COUNTRY')
    String country
}
