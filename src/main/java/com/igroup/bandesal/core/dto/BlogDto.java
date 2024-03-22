package com.igroup.bandesal.core.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Blogs.")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class BlogDto implements Serializable {

    @Schema(description = "Id blog.", example = "1")
    private Integer id;
    @Schema(description = "Titulo del blog.", example = "Aprendamos quarkus")
    private String title;
    @Schema(description = "Descripcion blog.", example = "Blog para prender quarkus")
    private String description;

    public BlogDto() {}

    public BlogDto(BlogDto other) {
        this.id = other.id;
        this.title = other.title;
        this.description = other.description;
    }

    public BlogDto withId(Integer id) {
        this.id = id;
        return this;
    }

    public BlogDto withTitle(String title) {
        this.title = title;
        return this;
    }

    public BlogDto withDescription(String Description) {
        this.description = description;
        return this;
    }
}
