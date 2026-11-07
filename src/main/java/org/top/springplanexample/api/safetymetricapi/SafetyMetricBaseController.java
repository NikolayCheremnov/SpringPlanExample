package org.top.springplanexample.api.safetymetricapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.top.springplanexample.datamodel.entity.SafetyMetric;
import org.top.springplanexample.service.safetymetric.SafetyMetricBaseService;
import org.top.springplanexample.service.safetymetric.SafetyMetricValues;

import java.util.List;

@RestController
@RequestMapping("api/safety/base")
public class SafetyMetricBaseController {
    private SafetyMetricBaseService service;

    public SafetyMetricBaseController(SafetyMetricBaseService service) {
        this.service = service;
    }

    // добавление метрики
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void putNew(@RequestBody SafetyMetricValues values) {
        service.putNewActualMetric(values);
    }

    @GetMapping
    public List<SafetyMetric> listAll() {
        return service.metrics();
    }
}
