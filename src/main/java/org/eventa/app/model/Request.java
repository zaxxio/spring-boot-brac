package org.eventa.app.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class Request {
    private List<Battery> batteries;
    private Statistic statistic;
}

