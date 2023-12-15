package com.inssolutions.BIZMinderAPI.model;

import com.inssolutions.BIZMinderAPI.enumeration.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.Instant;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Entreprise extends AbstractEntity{
    @Column(unique = true, nullable = false)
    private String corporateName;
    private String phone;
    private String logo;
    private Instant joiningDate;
    private Instant cancelDate;
    private String email;
    @Column(unique = true, nullable = false)
    private String taxCode;
    @OneToMany(mappedBy = "addessEntreprise")
    private List<Address> address;
    @Enumerated(EnumType.STRING)
    private Status status;


}
