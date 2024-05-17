import React from "react";
import "./Navbar.css";
const ManagerNavbar = () => (
  <>
    <nav>
      <div className="container">
        <div className="logo">Employee Management</div>
        <ul className="nav-links">
          <li>
            <a href="#">Home1</a>
          </li>
          <li>
            <a href="#">About</a>
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

export default ManagerNavbar;
