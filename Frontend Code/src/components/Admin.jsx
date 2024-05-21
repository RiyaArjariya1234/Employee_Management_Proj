import React, { useState, useEffect, useRef } from "react";
import { useLocation } from "react-router-dom";
import AddEmployee from "../CRUDComponent/AddEmployee";
import AdminNavbar from "../NavBarComponent/AdminNavbar";
import AddProject from "../CRUDComponent/AddProject";
import AssignProjectToManager from "../CRUDComponent/AssignProjectToManager";

function Admin() {
  const [isAddEmployeeModalOpen, setIsAddEmployeeModalOpen] = useState(false);
  const [isAddProjectModalOpen, setIsAddProjectModalOpen] = useState(false);
  const [
    isAssignProjectToManagerModalOpen,
    setIsAssignProjectToManagerModalOpen,
  ] = useState(false);

  const location = useLocation();
  const modalRef = useRef();

  const handleAddEmployee = () => {
    setIsAddEmployeeModalOpen(true);
  };

  const handleAddProject = () => {
    setIsAddProjectModalOpen(true);
  };
  const handleIsAssignProject = () => {
    setIsAssignProjectToManagerModalOpen(true);
  };

  const handleCloseModals = () => {
    setIsAddEmployeeModalOpen(false);
    setIsAddProjectModalOpen(false);
    setIsAssignProjectToManagerModalOpen(false);
  };

  const handleSubmitForm = (formData) => {
    console.log("Form submitted with data:", formData);
    handleCloseModals();
  };

  useEffect(() => {
    // Close modals when route changes
    handleCloseModals();
  }, [location]);

  useEffect(() => {
    // Close modal if clicked outside
    const handleClickOutside = (event) => {
      if (modalRef.current && !modalRef.current.contains(event.target)) {
        handleCloseModals();
      }
    };

    document.addEventListener("mousedown", handleClickOutside);
    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, []);

  const empId = localStorage.getItem("userId");
  const email = localStorage.getItem("email");

  return (
    <>
      <AdminNavbar
        onAddEmployee={handleAddEmployee}
        onAddProject={handleAddProject}
        onAssignProjectToManager={handleIsAssignProject}
      />
      {isAddEmployeeModalOpen && (
        <div ref={modalRef}>
          <span onClick={handleCloseModals}></span>
          <AddEmployee
            onSubmit={handleSubmitForm}
            onClose={handleCloseModals}
          />
        </div>
      )}
      {isAddProjectModalOpen && (
        <div ref={modalRef}>
          <span onClick={handleCloseModals}></span>
          <AddProject onSubmit={handleSubmitForm} onClose={handleCloseModals} />
        </div>
      )}
      {isAssignProjectToManagerModalOpen && (
        <div ref={modalRef}>
          <span onClick={handleCloseModals}></span>
          <AssignProjectToManager
            onSubmit={handleSubmitForm}
            onClose={handleCloseModals}
          />
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
