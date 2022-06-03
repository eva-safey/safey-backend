package com.example.safey.domain;

import com.example.safey.config.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String description;
    @Column
    private Integer type;
    @Column(name = "register_date")
    private Instant registerDate;

    @ManyToOne
    @JsonIgnoreProperties(value = "notifications", allowSetters = true)
    @JoinColumn(name = "id")
    private Camera camera;

    @ManyToOne
    @JsonIgnoreProperties(value = "notifications", allowSetters = true)
    @JoinColumn(name = "id")
    private User user;
}
