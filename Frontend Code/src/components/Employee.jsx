import React, { useState } from "react";
import AddSkills from "../CRUDComponent/AddSkills";
import EmployeeNavbar from "../NavBarComponent/EmployeeNavbar";

function Employee() {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleAddSkill = () => {
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
      <EmployeeNavbar onAddSkill={handleAddSkill} />
      {isModalOpen && (
        <div>
          <span onClick={handleCloseModal}></span>
          <AddSkills onSubmit={handleSubmitForm} onClose={handleCloseModal} />
        </div>
      )}
      <h1>Welcome</h1>
      <h1>Welcome to the Home Page</h1>
      {empId && <p>Employee ID: Employee {empId}</p>}
      {email && <p>Email: {email}</p>}
    </>
  );
}

export default Employee;
