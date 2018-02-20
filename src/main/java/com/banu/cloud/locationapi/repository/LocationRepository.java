package com.banu.cloud.locationapi.repository;
import com.banu.cloud.locationapi.model.Location;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location , String> {

	

	

}
