package com.example.safey.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "cameras")
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    private String brand;
    private String serial;
    @Column(name = "register_date")
    private Instant registerDate;
    @Column(name = "last_modify_Date")
    private Instant lastModifyDate;

    @ManyToOne
    @JsonIgnoreProperties(value = "cameras", allowSetters = true)
    @JoinColumn(name = "id")
    private Streaming streaming;

    @OneToMany(mappedBy = "clip")
    private Set<Clip> clips = new HashSet<>();

    @OneToMany(mappedBy = "clip")
    private Set<Notification> notifications = new HashSet<>();
}
