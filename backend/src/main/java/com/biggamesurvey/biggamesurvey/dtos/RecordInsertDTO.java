package com.biggamesurvey.biggamesurvey.dtos;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RecordInsertDTO implements Serializable {

    private String name;
    private Integer age;
    private Long gameId;
}
