package com.biggamesurvey.biggamesurvey.dtos;

import com.biggamesurvey.biggamesurvey.entities.Record;
import com.biggamesurvey.biggamesurvey.entities.enums.Plataform;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RecordDTO implements Serializable {

    private Long id;
    private Instant moment;
    private String name;
    private Integer age;
    private String gameTitle;
    private Plataform plataform;
    private String genreName;

    public RecordDTO(Record entity) {
        this(
            entity.getId(),
            entity.getMoment(),
            entity.getName(),
            entity.getAge(),
            entity.getGame().getTitle(),
            entity.getGame().getPlatform(),
            entity.getGame().getGenre().getName()
        );
    }
}
