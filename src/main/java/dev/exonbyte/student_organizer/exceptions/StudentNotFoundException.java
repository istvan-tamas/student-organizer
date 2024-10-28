package dev.exonbyte.student_organizer.exceptions;

import java.io.Serial;

public class StudentNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1;

    public StudentNotFoundException(String message) {
        super(message);
    }
}
