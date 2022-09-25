package com.biggamesurvey.biggamesurvey.repositories;

import com.biggamesurvey.biggamesurvey.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}
