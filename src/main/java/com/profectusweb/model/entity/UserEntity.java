package com.profectusweb.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity(name = "users")
public class UserEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    public BigInteger id;

    @Column()
    @Length(max = 60)
    public String username;

    @Column()
    @Length(max = 128)
    public String password;

    @Column(name = "created_at", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;

    @Column(name = "deleted_at", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date deletedAt;
}
