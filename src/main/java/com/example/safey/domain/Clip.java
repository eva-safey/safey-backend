package com.example.safey.domain;

import com.example.safey.config.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "clips")
public class Clip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    @Column(name = "init_time")
    private Instant initTime;
    @Column(name = "finish_time")
    private Instant finishTime;
    @Column(name = "register_date")
    private Instant registerDate;
    @Column(name = "video_data")
    private byte[] videoData;

    @ManyToOne
    @JsonIgnoreProperties(value = "clips", allowSetters = true)
    @JoinColumn(name = "id")
    private Camera camera;

    @ManyToOne
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    @JoinColumn(name = "id")
    private User user;

}
