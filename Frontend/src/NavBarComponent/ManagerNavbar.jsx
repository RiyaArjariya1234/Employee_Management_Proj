import React from "react";
import { Link } from "react-router-dom";
//import "./Navbar.css";

const ManagerNavbar = () => (
  <nav>
    <div className="container">
      <div className="logo">Employee Management</div>
      <ul className="nav-links">
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/manager/RequestResources">RequestResources</Link>
        </li>
        <li>
          <Link to="/manager/Home">Home</Link>
        </li>
        <li>
          <Link to="/contact">Contact</Link>
        </li>
      </ul>
    </div>
  </nav>
);

export default ManagerNavbar;
