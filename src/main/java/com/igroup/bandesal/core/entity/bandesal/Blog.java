package com.igroup.bandesal.core.entity.bandesal;

import com.igroup.bandesal.core.util.RegularExpressions;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@Entity
@Table(name = "blog", schema = "bandesal")
public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Pattern(regexp = RegularExpressions.regExpNombre)
    @Column(name = "title",length = 50)
    private String title;
    @Basic
    @Pattern(regexp = RegularExpressions.regExpDescripcion)
    @Column(name = "description",length = 4000)
    private String description;
}
