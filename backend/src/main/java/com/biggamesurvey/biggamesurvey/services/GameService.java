package com.biggamesurvey.biggamesurvey.services;

import com.biggamesurvey.biggamesurvey.dtos.GameDTO;
import com.biggamesurvey.biggamesurvey.entities.Game;
import com.biggamesurvey.biggamesurvey.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<GameDTO> findAll() {
        List<Game> games = repository.findAll();
        return games.stream().map(GameDTO::new).toList();
    }
}
