//import React from "react";
//import AddEmployee from "./CRUDComponent/AddEmployee";

import "./Navbar.css";
// AdminNavbar.js
import React from "react";
import { Link } from "react-router-dom";

const AdminNavbar = ({ onAddEmployee, onAddProject, onAssignProject }) => {
  return (
    <>
      <nav>
        <div className="container">
          <div className="logo">Employee Management</div>
          <ul className="nav-links">
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
              <a href="#" onClick={onAssignProject}>
                Assign Project To Manager
              </a>
            </li>
            <li>
              <Link to="/admin/RequestResourceView"> View Requests</Link>
            </li>
            <li>
              <Link to="/admin/RequestApproved"> View Approved Requests</Link>
            </li>
          </ul>
        </div>
      </nav>
    </>
  );
};

export default AdminNavbar;
