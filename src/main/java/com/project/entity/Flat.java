package com.project.entity;

import com.project.entity.enums.City;
import com.project.entity.enums.FlatNo;
import com.project.entity.enums.OccupancyStatus;
import com.project.entity.enums.Society;
import com.project.entity.enums.YouAre;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    @Enumerated(EnumType.STRING)
    private City city;
    @Enumerated(EnumType.STRING)
    private Society society;
    @Enumerated(EnumType.STRING)
    private FlatNo flatNo;
    @Enumerated(EnumType.STRING)
    private YouAre youAre;
    @Enumerated(EnumType.STRING)
    private OccupancyStatus  status;
    
    private String createDate;
    
}