import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

import './UpdateStudent.css';

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
  const [message, setMessage] = useState(''); // State for success or failure message

useEffect(() => {
  // Fetch existing student data by ID and populate the form fields
  const fetchStudentData = async () => {
    try {
      const response = await fetch(`http://193.224.23.42:5001/api/students/${id}`, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      });

      if (!response.ok) {
        console.error('Response status:', response.status);
        throw new Error('Failed to fetch student data');
      }

      const fetchedData = await response.json();
      setStudent(fetchedData);
    } catch (error) {
      console.error('Error fetching student data:', error);
    }
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

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log('Updated student data:', student);

    try {
      const response = await fetch(`http://193.224.23.42:5001/api/students/${id}/update`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(student),
      });

      if (!response.ok) {
        throw new Error('Failed to update student');
      }

      const data = await response.json();
      console.log('Response from server:', data);

      // Set success message on successful response
      setMessage('Student updated successfully!');
    } catch (error) {
      console.error('Error updating student:', error);
      // Set failure message on error
      setMessage('Failed to update student. Please try again.');
    }
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

export default UpdateStudent;
