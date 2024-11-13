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
          <Link to="/student/create" style={{ marginLeft: '10px' }}>Add Student</Link>
          <Link to="/student/update" style={{ marginLeft: '10px' }}>Update Student</Link> {/* Example link */}
        </nav>

        <Routes>
          <Route path="/" element={<h1>Welcome to the Home Page</h1>} />
          <Route path="/student/create" element={<AddStudent />} />
          <Route path="/student/update/:id" element={<UpdateStudent />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
