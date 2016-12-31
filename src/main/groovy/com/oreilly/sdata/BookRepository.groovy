package com.oreilly.sdata

import org.springframework.stereotype.Repository

/**
 * Created by oo185005 on 12/30/16.
 */
@Repository
interface BookRepository extends ReadOnlyRepository <Book, Long> {

}