package com.oreilly.sdata

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository


/**
 * Created by oo185005 on 12/30/16.
 */
@NoRepositoryBean
interface ReadOnlyRepository<T, ID extends Serializable> extends Repository<T, ID> {

    T findOne(ID id)
    Iterable<T> findAll()
}
