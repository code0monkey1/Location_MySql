package com.chiranjeev.location.repos;

import com.chiranjeev.location.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LocationRepository extends JpaRepository<Location,Integer> {
}
