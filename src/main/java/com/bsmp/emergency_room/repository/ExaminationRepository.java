package com.bsmp.emergency_room.repository;

import com.bsmp.emergency_room.domain.entity.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, UUID> {
}
