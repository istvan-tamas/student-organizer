import React from "react";
import { BrowserRouter as Router, Route, Routes, Link } from "react-router-dom";
import AddStudent from "./pages/AddStudent";
import UpdateStudent from "./pages/UpdateStudent";
import { StuedentList } from "./StudentList";

function App() {
  return (
    <Router>
      <div>
        <nav>
          <Link to="/">Home</Link>
          <Link to="/student/create" style={{ marginLeft: "10px" }}>
            Add Student
          </Link>
        </nav>

        <Routes>
          <Route path="/" element={<StuedentList />} />
          <Route path="/student/create" element={<AddStudent />} />
          <Route path="/student/update/:id" element={<UpdateStudent />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
