package de.ssd.models.persistence;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@IdClass(EventId.class)
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Id
    private String context;

    @NonNull
    @Column
    private String title;

    @NonNull
    @Column
    private String description;

    @Column
    private float duration;

    @OneToMany(cascade = CascadeType.ALL)
    private final Set<EventTagEntity> eventTagList = new HashSet<>();

    public void add(EventTagEntity eventTagEntity) {
        this.eventTagList.add(eventTagEntity);
    }

    public void addAll(Set<EventTagEntity> eventTagEntities) {
        this.eventTagList.addAll(eventTagEntities);
    }

}
