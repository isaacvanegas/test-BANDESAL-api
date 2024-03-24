package com.igroup.bandesal.core.entity.security;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "menu", schema = "security")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @NotNull
    @Column(name = "url", nullable = false, length = Integer.MAX_VALUE)
    private String url;

    @Column(name = "menu_id")
    private Integer menuId;

}