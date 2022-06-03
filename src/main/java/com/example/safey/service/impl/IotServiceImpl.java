package com.example.safey.service.impl;

import com.example.safey.service.IotService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.lang.Math;

@Service
public class IotServiceImpl implements IotService {

    @Scheduled(cron = "*/5 * * * *")
    public void Notify() {
        double random = Math.random();

        if (random < 0.5) {
            // send notification
        }
    }

}
