package com.adidas.codingchallenge.microservicecity.repository;

import com.adidas.codingchallenge.microservicecity.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * City repository interface
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {

}
