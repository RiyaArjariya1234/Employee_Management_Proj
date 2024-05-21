import React from "react";
//import AddEmployee from "./CRUDComponent/AddEmployee";

import "./Navbar.css";

const AdminNavbar = ({
  onAddEmployee,
  onAddProject,
  onAssignProjectToManager,
}) => (
  <>
    <nav>
      <div className="container">
        <div className="logo">Employee Management</div>
        <ul className="nav-links">
          <li>
            <a href="#">Home</a>
          </li>
          <li>
            <a href="#" onClick={onAddEmployee}>
              Add Employee
            </a>
          </li>
          <li>
            <a href="#" onClick={onAddProject}>
              Add Project
            </a>
          </li>
          <li>
            <a href="#" onClick={onAssignProjectToManager}>
              AssignProjectToManager
            </a>
          </li>
        </ul>
      </div>
    </nav>
  </>
);

export default AdminNavbar;
