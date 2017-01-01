package com.oreilly.sdata

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

/**
 * Created by oo185005 on 12/31/16.
 */
@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    List<T> findByIds(ID... ids)
}
