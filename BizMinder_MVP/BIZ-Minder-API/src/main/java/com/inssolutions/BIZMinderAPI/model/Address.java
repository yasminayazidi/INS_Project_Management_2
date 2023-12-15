package com.inssolutions.BIZMinderAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="address")
@Entity
public class Address extends AbstractEntity{

    private Integer streetNumber;
    private String streetName;
    private String city;
    @Column( nullable = false)
    private String zipCode;
    @ManyToOne
    @JoinColumn(name ="entreprise_Id")
    private Entreprise addessEntreprise;

}
