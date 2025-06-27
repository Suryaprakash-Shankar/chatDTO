package com.sssp.crudop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Codemegan")
public class Codemegan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;

    @Column(name = "NAME")
    public String Name ;

    @Column(name = "AGE")
    public int Age ;

    @Column(name = "MOBILE NUMBER")
    public String Mobile;

    @Column(name = "ADDRESS")
    public String Address;

}
