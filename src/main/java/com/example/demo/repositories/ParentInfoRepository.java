package com.example.demo.repositories;

import com.example.demo.models.ParentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentInfoRepository extends JpaRepository<ParentInfo, Long> {
}
