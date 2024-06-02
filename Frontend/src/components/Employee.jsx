import React, { useState } from "react";
import { Route, Routes, useLocation, Link } from "react-router-dom";
import AddSkills from "../CRUDComponent/AddSkills";
import EmployeeNavbar from "../NavBarComponent/EmployeeNavbar";
import EmployeeViewTaggedProject from "../CRUDComponent/EmployeeViewTaggedProject";
import ViewEmployees_Managers from "../CRUDComponent/ViewEmployees_Managers";
import "./Welcome.css";

const Employee = () => {
  const location = useLocation();
  const userName = localStorage.getItem("email");
  const [showAddSkillForm, setShowAddSkillForm] = useState(false);
  const handleOpenAddSkillForm = () => setShowAddSkillForm(true);
  const handleCloseAddSkillForm = () => setShowAddSkillForm(false);

  const handleAddSkillFormSubmit = () => {};
  return (
    <div>
      <EmployeeNavbar onAddSkill={handleOpenAddSkillForm} />
      <main>
        {location.pathname === "/employee" && (
          <div className="hero-section">
            <div className="hero-content">
              <h1>Welcome to the Employee Dashboard</h1>
              <p>
                Hi, Welcome {userName}! , We appreciate your efforts in managing
                the team and ensuring everything runs smoothly. Have a
                productive day!
              </p>
            </div>
          </div>
        )}
        {!location.pathname.endsWith("/employee") && (
          <div className="go-back">
            <Link to="/employee">Go Back to Home Page</Link>
          </div>
        )}

        {showAddSkillForm && (
          <div className="modal">
            <div>
              <AddSkills
                onSubmit={handleAddSkillFormSubmit}
                onClose={handleCloseAddSkillForm}
              />
            </div>
          </div>
        )}
        <Routes>
          <Route
            path="/EmployeeViewTaggedProject"
            element={<EmployeeViewTaggedProject />}
          />
        </Routes>
        <Routes>
          <Route
            path="/ViewEmployees_Managers"
            element={<ViewEmployees_Managers />}
          />
        </Routes>
      </main>
    </div>
  );
};
export default Employee;
