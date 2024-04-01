package com.example.hospitaltp3.entitites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class Patient{

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @DateTimeFormat
    private Date dateNaissance;
    private int score;
    private boolean malade;

}
