// AdminNavbar.js
import React from "react";
import "./Navbar.css";
import { Link, useNavigate } from "react-router-dom";
const EmployeeNavbar = ({ onAddSkill }) => {
  const navigate = useNavigate();
  const handleLogout = () => {
    localStorage.removeItem("userId");
    localStorage.removeItem("email");
    localStorage.removeItem("roleType");
    navigate("/");
  };
  return (
    <>
      <nav>
        <div className="container">
          <div className="logo">Employee Management</div>
          <ul className="nav-links">
            <li>
              <a href="#" onClick={onAddSkill}>
                Add Skill
              </a>
            </li>
            <li>
              <Link to="/employee/EmployeeViewTaggedProject">
                View Tagged Project
              </Link>
            </li>
            <li>
              <Link to="/employee/ViewEmployees_Managers">
                View All Employees & Managers
              </Link>
            </li>
            <li>
              <button onClick={handleLogout} className="logOut-button">
                Logout
              </button>
            </li>
          </ul>
        </div>
      </nav>
    </>
  );
};

export default EmployeeNavbar;
