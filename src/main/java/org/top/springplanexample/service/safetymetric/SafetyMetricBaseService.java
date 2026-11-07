package org.top.springplanexample.service.safetymetric;

import org.springframework.stereotype.Service;
import org.top.springplanexample.datamodel.entity.SafetyMetric;
import org.top.springplanexample.datamodel.repository.SafetyMetricRepository;
import org.top.springplanexample.service.useraction.UserActionService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

// SafetyMetricBaseService - базовые операции с метриками безопасности
@Service
public class SafetyMetricBaseService {
    private SafetyMetricRepository repo;
    private UserActionService uas;

    public SafetyMetricBaseService(SafetyMetricRepository repo, UserActionService uas) {
        this.repo = repo;
        this.uas = uas;
    }

    // putNewActualMetric - вставить новую метрику по текущим дате и времени
    public void putNewActualMetric(SafetyMetricValues values) {
        // 1. подготовить объект метрики
        SafetyMetric metric = new SafetyMetric();
        metric.setTravmatismPlan(values.getTravmatismPlan());
        metric.setTravmatismFact(values.getTravmatismFact());
        metric.setBrakiPlan(values.getBrakiPlan());
        metric.setBrakiFact(values.getBrakiFact());
        LocalDateTime now = LocalDateTime.now();
        metric.setMonth(now.getMonth().getValue());
        metric.setYear(now.getYear());
        metric.setWriteDate(new Date());

        // 2. сохранить в БД
        repo.save(metric);

        // 3. сохранить действие
        uas.LogUserAction("dev", "putNewActualMetric, id" + metric.getId());
    }

    // getMetrics - получить все метрики
    public List<SafetyMetric> metrics() {
        return repo.findAll();
    }

    // и т.д.
}
