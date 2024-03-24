package com.igroup.bandesal.core.entity.security;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
@Table(name = "connetion", schema = "security")
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "date", nullable = false)
    private Instant date;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @NotNull
    @Column(name = "token", nullable = false, length = Integer.MAX_VALUE)
    private String token;

    @Column(name = "t_duration")
    private Integer tDuration;

    @NotNull
    @Column(name = "uri", nullable = false, length = Integer.MAX_VALUE)
    private String uri;

}