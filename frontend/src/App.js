import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import AddStudent from './pages/AddStudent';
import UpdateStudent from './pages/UpdateStudent';

function App() {
  return (
    <Router>
      <div>
        <nav>
          <Link to="/">Home</Link>
          <Link to="/add-student" style={{ marginLeft: '10px' }}>Add Student</Link>
          <Link to="/update-student/1" style={{ marginLeft: '10px' }}>Update Student</Link> {/* Example link */}
        </nav>

        <Routes>
          <Route path="/" element={<h1>Welcome to the Home Page</h1>} />
          <Route path="/add-student" element={<AddStudent />} />
          <Route path="/update-student/:id" element={<UpdateStudent />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
