package com.oreilly.sdata

import org.springframework.data.jpa.repository.support.JpaEntityInformation
import org.springframework.data.jpa.repository.support.SimpleJpaRepository

import javax.persistence.EntityManager
import javax.persistence.Query

/**
 * Created by oo185005 on 12/31/16.
 */
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
    List<T> findByIds(ID[] ids) {
        Query query = entityManager.createQuery("select e from ${this.entityInformation.entityName} e " +
                "where e.${this.entityInformation.idAttribute.name} in :ids")

        query.setParameter('ids', ids as List)

        (List<T>)query.resultList
    }
}
