package com.example.demo.repositories;

import com.example.demo.models.DoctorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorInfoRepository extends JpaRepository<DoctorInfo, Long> {
}
