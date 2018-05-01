package com.adidas.codingchallenge.microservicecity.repository;

import com.adidas.codingchallenge.microservicecity.entity.CityConnectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * City connection repository interface
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@Repository
public interface CityConnectionRepository extends JpaRepository<CityConnectionEntity, Integer> {

}
