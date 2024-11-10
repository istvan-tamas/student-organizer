import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

const UpdateStudent = () => {
  const { id } = useParams(); // Assume the student ID is passed as a URL parameter
  const [student, setStudent] = useState({
    id: '',
    neptune: '',
    firstName: '',
    lastName: '',
    major: 'Computer Science',
    educationType: 'Full Time',
  });

  useEffect(() => {
    // Fetch existing student data by ID and populate the form fields
    // This is a placeholder; replace it with an API call if needed.
    const fetchStudentData = async () => {
      // Simulated fetch. Replace with actual API call.
      const fetchedData = {
        id,
        neptune: 'existingNeptuneCode',
        firstName: 'John',
        lastName: 'Doe',
        major: 'Computer Science',
        educationType: 'Full Time',
      };
      setStudent(fetchedData);
    };

    fetchStudentData();
  }, [id]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setStudent((prevStudent) => ({
      ...prevStudent,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Updated student data:', student);
    // Add update logic here, e.g., API call to update student by ID
  };

  return (
    <div className="container" style={{ width: '800px' }}>
      <h1>- SMS - Student Management System</h1>
      <hr />
      <h2>Update a student entry</h2>
      <hr />

      <form onSubmit={handleSubmit}>
        {/* Hidden ID Field */}
        <input type="hidden" name="id" value={student.id} />

        <input
          type="text"
          name="neptune"
          placeholder="Neptune code"
          className="form-control mb-4 col-4"
          value={student.neptune}
          onChange={handleChange}
        />
        <input
          type="text"
          name="firstName"
          placeholder="First Name"
          className="form-control mb-4 col-4"
          value={student.firstName}
          onChange={handleChange}
        />
        <input
          type="text"
          name="lastName"
          placeholder="Last Name"
          className="form-control mb-4 col-4"
          value={student.lastName}
          onChange={handleChange}
        />

        <select
          name="major"
          className="form-control mb-4 col-4"
          value={student.major}
          onChange={handleChange}
        >
          <option value="Computer Science">Computer Science</option>
          <option value="Computer Engineering">Computer Engineering</option>
          <option value="Business Comp Sci">Business Computer Science</option>
        </select>

        <select
          name="educationType"
          className="form-control mb-4 col-4"
          value={student.educationType}
          onChange={handleChange}
        >
          <option value="Full Time">Full Time</option>
          <option value="Part Time">Part Time</option>
          <option value="Correspondence">Correspondence</option>
        </select>

        <button type="submit" className="btn btn-info col-3">
          Update Student
        </button>
      </form>

      <hr />

      <a href="/students">Back to Student List</a>
    </div>
  );
};

export default UpdateStudent;
