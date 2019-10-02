package com.chiranjeev.location.repos;

import com.chiranjeev.location.entities.Location;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface LocationRepository extends JpaRepository<Location,Integer> {

	@Query("select type,count(type) from Location group by type")
	List<Object[]> findTypeAndTypeCount();
}
