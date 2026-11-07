package org.top.springplanexample.datamodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.top.springplanexample.datamodel.entity.SafetyMetric;

@Repository
public interface SafetyMetricRepository extends JpaRepository<SafetyMetric, Long> {
}
