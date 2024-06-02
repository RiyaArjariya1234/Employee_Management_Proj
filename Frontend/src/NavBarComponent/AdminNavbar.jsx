import React from "react";
//import AddEmployee from "./CRUDComponent/AddEmployee";

//import "./Navbar.css";
// AdminNavbar.js
/*import React from "react";*/
import { Link, useNavigate } from "react-router-dom";
/*const AdminNavbar = () => {
  return (
    <nav>
      <ul>
        <li>
          <Link to="/home">Home</Link>
        </li>
        <li>
          <Link to="/RequestResourceView">Request Resource View</Link>
        </li>
        <li>
          <Link to="/RequestApproved">Request Approved</Link>
        </li>
        <li>
          <Link to="/EmployeeDetail">Employee Detail</Link>
        </li>
      </ul>
    </nav>
  );
};
export default AdminNavbar;*/
const AdminNavbar = ({ onAddEmployee, onAddProject, onAssignProject }) => {
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
              <Link to="/admin/RequestResourceView">
                {" "}
                View Pending Requests
              </Link>
            </li>
            <li>
              <Link to="/admin/RequestApproved"> View Approved Requests</Link>
            </li>
            <li>
              <Link to="/admin/EmployeeDetail"> View Employees </Link>
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

export default AdminNavbar;
/*import React from "react";
import { Link } from "react-router-dom";

const AdminNavbar = ({ onAddEmployee, onAddProject, onAssignProject }) => {
  return (
    <nav>
      <div className="container">
        <div className="logo">Employee Management</div>
        <ul className="nav-links">
          <li>
            <Link to="/admin/home">Home</Link>
          </li>
          <li>
            <a
              href="/admin/home"
              onClick={(e) => {
                e.preventDefault();
                onAddEmployee();
              }}
            >
              Add Employee
            </a>
          </li>
          <li>
            <a
              href="/admin/home"
              onClick={(e) => {
                e.preventDefault();
                onAddProject();
              }}
            >
              Add Project
            </a>
          </li>
          <li>
            <a
              href="/admin/home"
              onClick={(e) => {
                e.preventDefault();
                onAssignProject();
              }}
            >
              Assign Project To Manager
            </a>
          </li>
          <li>
            <Link to="/admin/RequestResourceView">View Pending Requests</Link>
          </li>
          <li>
            <Link to="/admin/RequestApproved">View Approved Requests</Link>
          </li>
          <li>
            <Link to="/admin/EmployeeDetail">View Employees</Link>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default AdminNavbar;*/
