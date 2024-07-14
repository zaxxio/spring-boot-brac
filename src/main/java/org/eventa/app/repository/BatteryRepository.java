package org.eventa.app.repository;

import org.eventa.app.model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Long> {
    Optional<List<Battery>> findAllByIdBetween(Long start, Long end);
}
