package de.ssd.models.persistence;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class EventEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

    @NonNull
    @Column
    private String title;

    @NonNull
    @Column
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private final Set<EventTagEntity> eventTagList = new HashSet<>();

    public void add(EventTagEntity eventTagEntity) {
        this.eventTagList.add(eventTagEntity);
    }

    public void addAll(Set<EventTagEntity> eventTagEntities) {
        this.eventTagList.addAll(eventTagEntities);
    }
}
