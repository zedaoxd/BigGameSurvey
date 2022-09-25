package com.biggamesurvey.biggamesurvey.entities;

import com.biggamesurvey.biggamesurvey.entities.enums.Plataform;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_game")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Plataform platform;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "game")
    private List<Record> records = new ArrayList<>();
}
