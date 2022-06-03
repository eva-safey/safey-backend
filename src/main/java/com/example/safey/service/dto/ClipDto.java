package com.example.safey.service.dto;

import javax.persistence.Column;
import java.time.Instant;

public class ClipDto {

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
}
