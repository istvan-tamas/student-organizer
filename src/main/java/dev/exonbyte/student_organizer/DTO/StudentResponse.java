package dev.exonbyte.student_organizer.DTO;

import lombok.Data;

import java.util.List;

@Data
public class StudentResponse {
    private List<StudentDTO> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
