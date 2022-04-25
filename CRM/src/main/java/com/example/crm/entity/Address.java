package com.example.crm.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    private String country;
    private String zipCode;
    @Enumerated(EnumType.STRING)
    private AddressType type;
}
