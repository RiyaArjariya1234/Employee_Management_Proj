// AdminNavbar.js
import React from "react";
import "./Navbar.css";
const EmployeeNavbar = ({ onAddSkill }) => (
  <>
    <nav>
      <div className="container">
        <div className="logo">Employee Management</div>
        <ul className="nav-links">
          <li>
            <a href="#">Home</a>
          </li>
          <li>
            <a href="#" onClick={onAddSkill}>
              Add Skill
            </a>
          </li>
          <li>
            <a href="#">Services</a>
          </li>
          <li>
            <a href="#">Contact</a>
          </li>
        </ul>
      </div>
    </nav>
  </>
);

export default EmployeeNavbar;
