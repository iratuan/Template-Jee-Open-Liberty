package br.com.aygean.rest.v1.dtos;

import br.com.aygean.rest.core.entities.User;

import java.io.Serializable;
import java.time.LocalDate;

public class UserDTO implements Serializable {

    private Long id;

    private String email;

    private String fullName;

    private String preferName;

    private LocalDate createdAt;

    private Boolean active;

    public UserDTO(User author) {
        this.id = (Long) author.getId();
        this.email = author.getEmail();
        this.fullName = author.getFullName();
        this.preferName = author.getPreferName();
        this.createdAt = author.getCreatedAt();
        this.active = author.getActive();
    }
}
