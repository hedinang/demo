package com.example.demo.controller;

import com.example.demo.config.ControllerPath;
import com.example.demo.dto.SequenceDto;
import com.example.demo.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ControllerPath.SEQUENCE)
public class SequenceController {
    @Autowired
    SequenceService sequenceService;

    @PostMapping("/split")
    public String split(@RequestBody SequenceDto sequenceDto) {
        return sequenceService.split(sequenceDto.getSequence(), sequenceDto.getAmountOfBite());
    }

    @PostMapping("/recur")
    public String recur(@RequestParam String sequence) {
        sequenceService.recur(sequence, 0);
        return "ok";
    }
}
