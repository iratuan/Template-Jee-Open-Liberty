package br.com.aygean.rest.core.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users", schema = "restdb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String fullName;

    private String preferName;

    private LocalDate createdAt;

    private Boolean active;
}
