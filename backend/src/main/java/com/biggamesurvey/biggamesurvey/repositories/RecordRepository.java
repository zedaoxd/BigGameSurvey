package com.biggamesurvey.biggamesurvey.repositories;

import com.biggamesurvey.biggamesurvey.entities.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    Page<Record> findByMomentBetween(Instant start, Instant end, Pageable pageable);
}
