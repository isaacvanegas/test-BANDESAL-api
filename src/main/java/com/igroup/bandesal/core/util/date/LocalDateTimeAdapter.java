package com.igroup.bandesal.core.util.date;


import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String inputDate) {
        return inputDate != null ? DateTimeFormatter.ofPattern("yyyy-MM-ddTHH.mm.ss.SSS").parse(inputDate, LocalDateTime::from) : null;
    }

    @Override
    public String marshal(LocalDateTime inputDate) {
        return inputDate != null ? DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(inputDate) : null;
    }
}
