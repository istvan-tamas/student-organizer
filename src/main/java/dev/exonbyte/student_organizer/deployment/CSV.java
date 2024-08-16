package dev.exonbyte.student_organizer.deployment;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class CSV {
    @CsvBindByPosition(position = 0)
    private int id;

    @CsvBindByPosition(position = 1)
    private String education_type;

    @CsvBindByPosition(position = 2)
    private String first_name;

    @CsvBindByPosition(position = 3)
    private String last_name;

    @CsvBindByPosition(position = 4)
    private String major;

    @CsvBindByPosition(position = 5)
    private String neptune;

}
