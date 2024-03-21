package com.igroup.bandesal.core.entity.bandesal;

import com.igroup.bandesal.core.util.RegularExpressions;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@Entity
@Table(name = "reader", schema = "bandesal")
public class Reader implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Pattern(regexp = RegularExpressions.regExpNombre)
    @Column(name = "name",length = 8)
    private String name;
}
