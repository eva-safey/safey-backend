package com.example.safey.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "streamings")
public class Streaming {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "stream_link")
    private String streamLink;
    @Column()
    private String server;

    @OneToMany(mappedBy = "camera")
    private Set<Camera> cameras = new HashSet<>();

}
