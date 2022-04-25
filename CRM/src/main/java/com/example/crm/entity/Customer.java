package com.example.crm.entity;

import com.example.crm.validation.Email;
import com.example.crm.validation.TcKimlikNo;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "customers")
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Customer {
    @Id
    @TcKimlikNo
    @Column(length = 11)
    private String identity;
    @Column(nullable = false)
    @Size(min = 5)
    private String fullname;
    @Column(unique = true)
    @Email
    private String email;
    @Column(unique = true)
    @NotBlank
    private String phone;
    @Max(2004)
    private int birthYear;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Address> addresses;
    @Enumerated(EnumType.STRING)
    private CustomerType type;

}
