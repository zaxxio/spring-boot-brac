package org.eventa.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eventa.app.model.Battery;
import org.eventa.app.model.Request;
import org.eventa.app.model.Statistic;
import org.eventa.app.repository.BatteryRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Component
public class BatteryService {
    @Autowired
    private BatteryRepository batteryRepository;
    private ObjectMapper mapper = new ObjectMapper();

    public String collect(Long start, Long end) throws JsonProcessingException {
        List<Battery> batteries = batteryRepository.findAll();
        long sum = batteries.stream().map(battery -> battery.getWattCapacity())
                .mapToLong(Long::parseLong)
                .sum();

        OptionalDouble average = batteries.stream().map(battery -> battery.getWattCapacity())
                .mapToLong(Long::parseLong)
                .average();

        Optional<List<Battery>> batteryList = batteryRepository.findAllByIdBetween(start, end);

        Request request = new Request();
        request.setBatteries(batteryList.get());
        if (average.isPresent()){
            request.setStatistic(Statistic.builder()
                    .totalWattCapacity(sum)
                    .averageWattCapacity(average.getAsDouble())
                    .build());
        }


        return mapper.writeValueAsString(request);
    }
}
