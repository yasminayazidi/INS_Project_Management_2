package com.inssolutions.BIZMinderAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Holidays extends AbstractEntity{
    private String name;
    private Instant date;
    private String location;
    private String shift;
    private String details;
}
