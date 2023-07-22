package io.github.nfers.msdigitalbankperson.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fullName;
    private String nickName;
    private String document;
    private Long phoneNumber;
    private UUID accountId;
    private String profession;
    private String email;

    @ManyToOne
    private Address address;

}
