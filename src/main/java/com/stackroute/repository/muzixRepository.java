package com.stackroute.repository;

import com.stackroute.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface muzixRepository extends JpaRepository<Muzix, Integer> {

            @Query("from Muzix where trackName=?1")
            public List<Muzix> findAllTracksByName(String trackName);

}
