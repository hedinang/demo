package com.example.demo.controller;

import com.example.demo.config.ControllerPath;
import com.example.demo.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ControllerPath.THREAD)
public class ThreadController {
    @Autowired
    ThreadService threadService;

    @GetMapping()
    public String start() {
        return threadService.start();
    }
}
