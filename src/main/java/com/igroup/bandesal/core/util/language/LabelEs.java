package com.igroup.bandesal.core.util.language;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import lombok.Data;

@Data
@Named
@Dependent
public class LabelEs {


    private  String getReaderApi = "getReader";
    private  String getReaderBlogApi = "getReaderBlog";
    private  String getBlogApi = "getBlog";


}
