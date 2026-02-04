package com.student.dao.repository;

import com.student.dao.entity.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<FruitEntity, Long> {
}
