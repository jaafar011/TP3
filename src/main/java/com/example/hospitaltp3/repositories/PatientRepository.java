package com.example.hospitaltp3.repositories;

import com.example.hospitaltp3.entitites.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findByNomContains(String search, Pageable pageable);
}
