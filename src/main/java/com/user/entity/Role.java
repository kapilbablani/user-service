package com.user.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import javax.persistence.*;

@Entity
@Table(name="role")
@Getter
@Setter
@ToString
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name="role_description")
    private String roleDescription;
}
