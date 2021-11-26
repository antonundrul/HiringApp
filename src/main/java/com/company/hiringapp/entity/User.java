package com.company.hiringapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode
public class User extends AbstractEntity {

    @Column(name = "username", nullable = false, unique = true, length = 48)
    private String username;
    @Column(name = "password", nullable = false, length = 256)
    private String password;
    @Column(name = "first_name", nullable = false, length = 48)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 48)
    private String lastName;
    @Column(name = "email", nullable = false, length = 48, unique = true)
    private String email;
    @Column(columnDefinition = "smallint")
    private Integer blocked;
    @Column(name = "avatar")
    private String avatar;

    /*@ManyToMany(mappedBy = "observers")
    private List<Parcel> parcels;*/

    /*@Lob
    @Column(name = "image")
    private byte[] image;*/

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    private Set<Role> roles = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        blocked = 0;
    }


}


