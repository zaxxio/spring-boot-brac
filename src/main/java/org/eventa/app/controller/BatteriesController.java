package org.eventa.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.eventa.app.model.Battery;
import org.eventa.app.model.Request;
import org.eventa.app.model.Statistic;
import org.eventa.app.repository.BatteryRepository;
import org.eventa.app.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BatteriesController {

    private final BatteryRepository batteryRepository;
    private ObjectMapper mapper = new ObjectMapper();
    private final BatteryService batteryService;

    @PostMapping("/batteries")
    public List<Battery> saveBatteries(@RequestBody List<Battery> batteries) {
        return batteryRepository.saveAll(batteries);
    }

    @GetMapping(value = "/batteries", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBatteries(@RequestParam(value = "start", defaultValue = "0") Long start, @RequestParam(value = "end", defaultValue = "0") Long end) throws JsonProcessingException {
        return batteryService.collect(start, end);

    }



}
