import React, { useState } from 'react';

import './AddStudent.css';

const AddStudent = () => {
  const [student, setStudent] = useState({
    neptune: '',
    firstName: '',
    lastName: '',
    major: 'Computer Science',
    educationType: 'Full Time',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setStudent((prevStudent) => ({
      ...prevStudent,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Student data submitted:', student);
    // Submit logic here (e.g., API call)
  };

  return (
    <div className="container" style={{ width: '800px' }}>
      <h1>- SMS - Student Management System</h1>
      <hr />
      <h2>Create a new student entry</h2>

      <form onSubmit={handleSubmit}>
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
          <option value="Business Comp Sci">Economics</option>
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

        <button type="submit" className="btn btn-info col-2">
          Save Student
        </button>
      </form>

      <hr />

      <a href="/">Back to Student List</a>
    </div>
  );
};

export default AddStudent;
