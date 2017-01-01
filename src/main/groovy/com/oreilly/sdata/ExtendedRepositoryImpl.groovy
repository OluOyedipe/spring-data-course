package com.oreilly.sdata

import groovy.util.logging.Slf4j
import org.springframework.data.jpa.repository.support.JpaEntityInformation
import org.springframework.data.jpa.repository.support.SimpleJpaRepository
import org.springframework.stereotype.Service

import javax.persistence.EntityManager
import javax.persistence.Query

/**
 * Created by oo185005 on 12/31/16.
 */
@Slf4j
class ExtendedRepositoryImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    JpaEntityInformation<T, ? extends Serializable> entityInformation
    EntityManager entityManager

    ExtendedRepositoryImpl(JpaEntityInformation<T, ? extends Serializable> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager)
        this.entityInformation = entityInformation
        this.entityManager = entityManager
    }

    @Override
    List<T> findByIds(ID... ids) {
        Query query = entityManager.createQuery("select e from ${this.entityInformation.entityName} e " +
                "where e.${this.entityInformation.idAttribute.name} in :ids")

        query.setParameter('ids', ids as List)

        def wait = new Random().nextInt(10000-1) + 1
        log.info "Wait time: $wait"
        sleep(wait)

        log.info "Executing query for ID: ${ids as List}"
        (List<T>)query.resultList
    }
}
