package org.eventa.app.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Statistic {
    private Long totalWattCapacity;
    private Double averageWattCapacity;
}
