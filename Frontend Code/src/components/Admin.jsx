//import React from "react";
//import "../NavBarComponent/Navbar.css";
//import "./Navbar.css";
import React, { useState } from "react";
import AddEmployee from "../CRUDComponent/AddEmployee";
import AdminNavbar from "../NavBarComponent/AdminNavbar";

function Admin() {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleAddEmployee = () => {
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setIsModalOpen(false);
  };

  const handleSubmitForm = (formData) => {
    console.log("Form submitted with data:", formData);
    setIsModalOpen(false);
  };
  const empId = localStorage.getItem("userId");
  const email = localStorage.getItem("email");
  return (
    <>
      <AdminNavbar onAddEmployee={handleAddEmployee} />
      {isModalOpen && (
        <div>
          <span onClick={handleCloseModal}></span>
          <AddEmployee onSubmit={handleSubmitForm} onClose={handleCloseModal} />
        </div>
      )}
      <h1>Welcome</h1>
      <h1>Welcome to the Home Page</h1>
      {empId && <p>Employee ID: {empId}</p>}
      {email && <p>Email: {email}</p>}
    </>
  );
}

export default Admin;
