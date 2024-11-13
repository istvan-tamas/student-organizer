import React, { useState } from 'react';

import './AddStudent.css';

const getRandomId = () => Math.floor(Math.random() * 100000);

const AddStudent = () => {
  const [student, setStudent] = useState({
    id: getRandomId(),
    neptune: '',
    firstName: '',
    lastName: '',
    major: 'Computer Science',
    educationType: 'Full Time',
  });
  const [message, setMessage] = useState(''); // State for success or failure message

  const handleChange = (e) => {
    const { name, value } = e.target;
    setStudent((prevStudent) => ({
      ...prevStudent,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log('Student data submitted:', student);

    try {
      const response = await fetch('http://localhost:5001/api/students/create', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(student),
      });

      if (!response.ok) {
        throw new Error('Failed to create student');
      }

      const data = await response.json();
      console.log('Response from server:', data);

      // Set success message on successful response
      setMessage('Student created successfully!');
    } catch (error) {
      console.error('Error creating student:', error);
      // Set failure message on error
      setMessage('Failed to create student. Please try again.');
    }
  };

  return (
    <div className="container" style={{ width: '800px' }}>
      <h1>- SMS - Student Management System</h1>
      <hr />
      <h2>Create a new student entry</h2>

      <form onSubmit={handleSubmit}>
      <input
          type="text"
          name="id"
          placeholder="ID"
          className="form-control mb-4 col-4"
          value={student.id}
          onChange={handleChange}
        />
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

      {/* Display the success or failure message */}
      {message && (
        <div className={`alert ${message.includes('successfully') ? 'alert-success' : 'alert-danger'} mt-4`}>
          {message}
        </div>
      )}

      <hr />

      <a href="/">Back to Student List</a>
    </div>
  );
};

export default AddStudent;
