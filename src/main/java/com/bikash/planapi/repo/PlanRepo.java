package com.bikash.planapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikash.planapi.entity.Plans;

@Repository
public interface PlanRepo extends JpaRepository<Plans, Integer> {

}
