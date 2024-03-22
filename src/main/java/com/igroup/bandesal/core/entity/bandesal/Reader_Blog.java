package com.igroup.bandesal.core.entity.bandesal;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;


@Data
@Entity
@Table(name = "reader_blog", schema = "bandesal")
public class Reader_Blog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reader_id", referencedColumnName = "id")
    private Reader readerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blog_id", referencedColumnName = "id")
    private Blog blogId;

}
