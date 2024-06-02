import React from "react";
import { Link, useNavigate } from "react-router-dom";
import "./Navbar.css";

const ManagerNavbar = () => {
  const navigate = useNavigate();
  const handleLogout = () => {
    localStorage.removeItem("userId");
    localStorage.removeItem("email");
    localStorage.removeItem("roleType");
    navigate("/");
  };
  return (
    <nav>
      <div className="container">
        <div className="logo">Employee Management</div>
        <ul className="nav-links">
          <li>
            <Link to="/manager/RequestResources">RequestResources</Link>
          </li>
          <li>
            <Link to="/manager/ManagerApprovedRequestView"> View All</Link>
          </li>
          <li>
            <Link to="/manager/ManagerViewTaggedProject">
              {" "}
              View Tagged Project
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
  );
};

export default ManagerNavbar;
