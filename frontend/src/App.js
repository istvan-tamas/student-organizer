import React from "react";
import { BrowserRouter as Router, Route, Routes, Link } from "react-router-dom";
import AddStudent from "./pages/AddStudent";
import UpdateStudent from "./pages/UpdateStudent";
import { StuedentList } from "./StudentList";

function App() {
  return (
    <div style={{ padding: "20px" }}>
      <Router>
        <div>
          <nav>
            <div style={{ padding: "10px" }}>
              {/* <Link to="/">Home</Link> */}
              <Link
                to="/"
                style={{
                  marginRight: "10px",
                  textDecoration: "none",
                  color: "white",
                  backgroundColor: "blue",
                  padding: "10px",
                  borderRadius: "5px",
                }}
              >
                Home
              </Link>
              <Link
                to="/student/create"
                style={{
                  marginLeft: "10px",
                  textDecoration: "none",
                  color: "white",
                  backgroundColor: "green",
                  padding: "10px",
                  borderRadius: "5px",
                }}
              >
                Add Student
              </Link>
            </div>
          </nav>

          <Routes>
            <Route path="/" element={<StuedentList />} />
            <Route path="/student/create" element={<AddStudent />} />
            <Route path="/student/update/:id" element={<UpdateStudent />} />
          </Routes>
        </div>
      </Router>
    </div>
  );
}

export default App;
