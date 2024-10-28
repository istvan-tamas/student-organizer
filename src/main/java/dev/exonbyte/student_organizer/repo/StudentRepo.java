package dev.exonbyte.student_organizer.repo;

import dev.exonbyte.student_organizer.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {

}
