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

//    private final StudentServiceImp studentService;
//
//    @Autowired
//    public Deployment(StudentServiceImp studentService) {
//        this.studentService = studentService;
//    }
//
    @Override
    public void afterPropertiesSet() throws FileNotFoundException {
        System.out.println("Deployment");

//        String fileName = System.getProperty("user.dir") + "/MOCK_DATA.csv";
////        System.out.println(fileName);
//
//        List<CSV> beans = new CsvToBeanBuilder(new FileReader(fileName)).withType(CSV.class).withSkipLines(1).build().parse();
//
//        for (CSV bean : beans) {
//            StudentDTO theStudent = new StudentDTO();
//            theStudent.setId(bean.getId());
//            theStudent.setEducationType(bean.getEducation_type());
//            theStudent.setFirstName(bean.getFirst_name());
//            theStudent.setLastName(bean.getLast_name());
//            theStudent.setMajor(bean.getMajor());
//            theStudent.setNeptune(bean.getNeptune());
//            studentService.createStudent(theStudent);
//        }
//        try(PythonInterpreter pyInterp = new PythonInterpreter()){
//            StringWriter output = new StringWriter();
//            pyInterp.setOut(output);
//            pyInterp.exec("print('Deployment started');')");
//            System.out.println(output.toString());
//            output.close();
//        }

    }

}
