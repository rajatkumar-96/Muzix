package com.stackroute.repository;

import com.stackroute.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface muzixRepository extends JpaRepository<Muzix, Integer> {

}
