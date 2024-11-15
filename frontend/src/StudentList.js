import React from "react";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
const mockStudents = [
  {
    id: 1,
    education_type: "Full Time",
    first_name: "Cathy",

    last_name: "Ferre",
    major: "Computer Engineering",
    neptune: "0V4M1W",
  },
  {
    id: 2,
    education_type: "Correspondence",
    first_name: "Jenna",
    last_name: "Skipperbottom",
    major: "Computer Science",
    neptune: "9N7O6I",
  },
  {
    id: 3,
    education_type: "Correspondence",
    first_name: "Addy",
    last_name: "Stayte",
    major: "Computer Engineering",
    neptune: "0Y9V3E",
  },
  {
    id: 4,
    education_type: "Correspondence",
    first_name: "Eleanor",
    last_name: "Addison",
    major: "Business Comp Sci",
    neptune: "7P2J7R",
  },
  {
    id: 5,
    education_type: "Correspondence",
    first_name: "Ron",
    last_name: "Scotsbrook",
    major: "Computer Science",
    neptune: "2V0F7A",
  },
  {
    id: 6,
    education_type: "Part Time",
    first_name: "Angie",
    last_name: "Artz",
    major: "Business Comp Sci",
    neptune: "0F3U4Q",
  },
];

export const StuedentList = () => {
  const [students, setStudents] = useState([]);

  async function deleteStudent(studentId) {
    await fetch(
      fetch(`http://localhost:5001/api/students/${studentId}/delete`, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
      })
    );
  }

  async function fetchStudents() {
    const res = await fetch(
      "http://localhost:5001/api/students?pageNumber=0&pageSize=1000",
      {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      }
    );
    const data = await res.json();
    console.log("Response from server:", data);
    setStudents(data.content);
  }
  useEffect(() => {
    (async () => {
      await fetchStudents();
    })();
  }, []);
  const [currentPage, setCurrentPage] = useState(1);
  const studentsPerPage = 20;

  const indexOfLastStudent = currentPage * studentsPerPage;
  const indexOfFirstStudent = indexOfLastStudent - studentsPerPage;
  const currentStudents = students.slice(indexOfFirstStudent, indexOfLastStudent);

  const totalPages = Math.ceil(students.length / studentsPerPage);

  const handlePagination = (pageNumber) => {
    setCurrentPage(pageNumber);
  };

  return (
    <div style={{ padding: "20px" }}>
      <table style={{ width: "100%", borderCollapse: "collapse" }}>
        <thead>
          <tr>
            <th style={{ border: "1px solid black", padding: "8px" }}>ID</th>
            <th style={{ border: "1px solid black", padding: "8px" }}>First Name</th>
            <th style={{ border: "1px solid black", padding: "8px" }}>Last Name</th>
            <th style={{ border: "1px solid black", padding: "8px" }}>Major</th>
            <th style={{ border: "1px solid black", padding: "8px" }}>Education Type</th>
            <th style={{ border: "1px solid black", padding: "8px" }}>Neptune</th>
          </tr>
        </thead>
        <tbody>
          {currentStudents.map((student) => (
            <tr key={student.id}>
              <td style={{ border: "1px solid black", padding: "8px" }}>{student.id}</td>
              <td style={{ border: "1px solid black", padding: "8px" }}>
                {student.firstName}
              </td>
              <td style={{ border: "1px solid black", padding: "8px" }}>
                {student.lastName}
              </td>
              <td style={{ border: "1px solid black", padding: "8px" }}>
                {student.major}
              </td>
              <td style={{ border: "1px solid black", padding: "8px" }}>
                {student.educationType}
              </td>
              <td style={{ border: "1px solid black", padding: "8px" }}>
                {student.neptune}
              </td>
              <td style={{ border: "1px solid black", padding: "8px" }}>
                <button
                  onClick={() => {
                    setStudents(students.filter((s) => s.id !== student.id));
                    deleteStudent(student.id);
                  }}
                  style={{
                    padding: "5px 10px",
                    backgroundColor: "#ff4d4d",
                    color: "#fff",
                    border: "none",
                    cursor: "pointer",
                  }}
                >
                  Delete
                </button>
              </td>
              <td style={{ border: "1px solid black", padding: "8px" }}>
                <Link to={`/student/update/${student.id}`} style={{ marginLeft: "10px" }}>
                  Update Student
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      <div style={{ marginTop: "20px", textAlign: "center" }}>
        <button
          onClick={() => handlePagination(1)}
          style={{
            margin: "0 5px",
            padding: "10px 20px",
            backgroundColor: currentPage === 1 ? "#007bff" : "#fff",
            color: currentPage === 1 ? "#fff" : "#000",
            border: "1px solid #007bff",
            cursor: "pointer",
          }}
        >
          First
        </button>
        {Array.from({ length: totalPages }, (_, index) => (
          <button
            key={index + 1}
            onClick={() => handlePagination(index + 1)}
            style={{
              margin: "0 5px",
              padding: "10px 20px",
              backgroundColor: currentPage === index + 1 ? "#007bff" : "#fff",
              color: currentPage === index + 1 ? "#fff" : "#000",
              border: "1px solid #007bff",
              cursor: "pointer",
            }}
          >
            {index + 1}
          </button>
        ))}

        <button
          onClick={() => handlePagination(totalPages)}
          style={{
            margin: "0 5px",
            padding: "10px 20px",
            backgroundColor: currentPage === totalPages ? "#007bff" : "#fff",
            color: currentPage === totalPages ? "#fff" : "#000",
            border: "1px solid #007bff",
            cursor: "pointer",
          }}
        >
          Last
        </button>
      </div>
    </div>
  );
};
