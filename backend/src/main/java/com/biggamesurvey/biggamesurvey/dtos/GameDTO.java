package com.biggamesurvey.biggamesurvey.dtos;

import com.biggamesurvey.biggamesurvey.entities.Game;
import com.biggamesurvey.biggamesurvey.entities.enums.Plataform;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GameDTO implements Serializable {

    private Long id;
    private String title;
    private Plataform platform;

    public GameDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        platform = entity.getPlatform();
    }
}
