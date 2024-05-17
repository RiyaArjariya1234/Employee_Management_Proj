import React from "react";
//import AddEmployee from "./CRUDComponent/AddEmployee";

//import "./Navbar.css";

const AdminNavbar = ({ onAddEmployee }) => (
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

export default AdminNavbar;

/*import React from "react";
import "./Navbar.css";

const AdminNavbar = () => (
  <>
    <nav>
      <div className="container">
        <div className="logo">Employee Management</div>
        <ul className="nav-links">
          <li>
            <a href="#">Home</a>
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

export default AdminNavbar;*/

/*import React from "react";
import "./Navbar.css";
const AdminNavbar = () => {
  <>
    <nav>
      <div className="container">
        <div className="logo">Your Brand</div>
        <ul className="nav-links">
          <li>
            <a href="#">Home</a>
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
  </>;
};

export default AdminNavbar;*/
