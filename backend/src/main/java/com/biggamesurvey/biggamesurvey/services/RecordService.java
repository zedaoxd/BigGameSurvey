package com.biggamesurvey.biggamesurvey.services;

import com.biggamesurvey.biggamesurvey.dtos.RecordDTO;
import com.biggamesurvey.biggamesurvey.dtos.RecordInsertDTO;
import com.biggamesurvey.biggamesurvey.entities.Game;
import com.biggamesurvey.biggamesurvey.entities.Record;
import com.biggamesurvey.biggamesurvey.repositories.GameRepository;
import com.biggamesurvey.biggamesurvey.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class RecordService {

    private final RecordRepository repository;
    private final GameRepository gameRepository;

    public RecordService(RecordRepository repository, GameRepository gameRepository) {
        this.repository = repository;
        this.gameRepository = gameRepository;
    }

    @Transactional
    public RecordDTO insert(RecordInsertDTO insertDTO) {
        Record entity = new Record();
        entity.setName(insertDTO.getName());
        entity.setAge(insertDTO.getAge());
        entity.setMoment(Instant.now());
        entity.setGame(gameRepository.getReferenceById(insertDTO.getGameId()));
        entity = repository.save(entity);
        return new RecordDTO(entity);
    }
}
