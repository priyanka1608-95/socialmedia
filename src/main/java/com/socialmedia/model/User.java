package com.socialmedia.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;

    private String name;

    private String address;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user",cascade =CascadeType.ALL)
    @JsonManagedReference
    private List<Post> posts;
}
