/*
package com.example.application.controller;

import com.example.application.entities.Alerte;
import com.example.application.service.AlerteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerte")
@CrossOrigin(origins = "*")
public class AlerteController {
     @Autowired
    private AlerteService alerteService;

    @GetMapping("/{receiverId}")
    public List<Alerte> getAlertesByReceiverId(@PathVariable Long receiverId) {
        return AlerteService.getAlertesByReceiverId(receiverId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{alerteId}")
    public void handleAlerteResponse(@PathVariable Long alerteId, @RequestParam boolean response) {
        alerteService.handleAlerteResponse(alerteId, response);
    }
} */
