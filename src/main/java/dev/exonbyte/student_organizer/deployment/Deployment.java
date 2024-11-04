package dev.exonbyte.student_organizer.deployment;

import com.opencsv.bean.CsvToBeanBuilder;
import dev.exonbyte.student_organizer.DTO.StudentDTO;
import dev.exonbyte.student_organizer.services.StudentServiceImp;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


@Component
public class Deployment implements InitializingBean {

    private final StudentServiceImp studentService;

    @Autowired
    public Deployment(StudentServiceImp studentService) {
        this.studentService = studentService;
    }

    @Override
    public void afterPropertiesSet() throws FileNotFoundException {
        System.out.println("App started OK!");

    }

}
