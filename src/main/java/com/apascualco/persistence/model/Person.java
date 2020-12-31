package com.apascualco.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name = "Person",
        uniqueConstraints = @UniqueConstraint(name = "uc_name", columnNames = {"email"})
)
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Person implements BaseEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String composeName;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private String email;

    @Override
    public String toString() {
        return "{ ID: " + this.id + " LASTNAME: " + this.lastName + " NAME: " + this.name + " COMPOSENAME: "
                + this.composeName + " ACTIVE: " + this.active + " EMAIL: " + this.email + " }";
    }

}
