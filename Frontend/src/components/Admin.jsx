import React, { useState } from "react";
import AdminNavbar from "../NavBarComponent/AdminNavbar";
import AddEmployee from "../CRUDComponent/AddEmployee";
import AddProject from "../CRUDComponent/AddProject";
import AssignProjectToManager from "../CRUDComponent/AssignProjectToManager";
import { Route, Routes, useLocation, Link } from "react-router-dom";
import RequestResourceView from "../CRUDComponent/RequestResourceView";
import RequestApproved from "../CRUDComponent/RequestApproved";
import EmployeeDetail from "../CRUDComponent/EmployeeDetail";
import "./Welcome.css";

const Admin = () => {
  const location = useLocation();
  const userName = localStorage.getItem("email");
  const [showAddEmployeeForm, setShowAddEmployeeForm] = useState(false);
  const [showAddProjectForm, setShowAddProjectForm] = useState(false);
  const [showAssignProjectForm, setShowAssignProjectForm] = useState(false);

  const handleOpenAddEmployeeForm = () => setShowAddEmployeeForm(true);
  const handleCloseAddEmployeeForm = () => setShowAddEmployeeForm(false);

  const handleAddEmployeeFormSubmit = () => {};

  const handleOpenAddProjectForm = () => setShowAddProjectForm(true);
  const handleCloseAddProjectForm = () => setShowAddProjectForm(false);

  const handleAddProjectFormSubmit = () => {};

  const handleOpenAssignProjectForm = () => setShowAssignProjectForm(true);
  const handleCloseAssignProjectForm = () => setShowAssignProjectForm(false);

  const handleAssignProjectFormSubmit = () => {};

  return (
    <div>
      <AdminNavbar
        onAddEmployee={handleOpenAddEmployeeForm}
        onAddProject={handleOpenAddProjectForm}
        onAssignProject={handleOpenAssignProjectForm}
      />
      <main>
        {location.pathname === "/admin" && (
          <div className="hero-section">
            <div className="hero-content">
              <h1>Welcome to the Admin Dashboard</h1>
              <p>
                Hi, Welcome {userName}! This is Riya here. We appreciate your
                efforts in managing the team and ensuring everything runs
                smoothly. Have a productive day!
              </p>
            </div>
          </div>
        )}
        {!location.pathname.endsWith("/admin") && (
          <div className="go-back">
            <Link to="/admin">Go Back to Admin Page</Link>
          </div>
        )}

        {showAddEmployeeForm && (
          <div className="modal">
            <div>
              <AddEmployee
                onSubmit={handleAddEmployeeFormSubmit}
                onClose={handleCloseAddEmployeeForm}
              />
            </div>
          </div>
        )}
        {showAddProjectForm && (
          <div className="modal">
            <div>
              <AddProject
                onSubmit={handleAddProjectFormSubmit}
                onClose={handleCloseAddProjectForm}
              />
            </div>
          </div>
        )}
        {showAssignProjectForm && (
          <div className="modal">
            <div>
              <AssignProjectToManager
                onSubmit={handleAssignProjectFormSubmit}
                onClose={handleCloseAssignProjectForm}
              />
            </div>
          </div>
        )}
        <Routes>
          <Route
            path="/RequestResourceView"
            element={<RequestResourceView />}
          />
          <Route path="/RequestApproved" element={<RequestApproved />} />
          <Route path="/EmployeeDetail" element={<EmployeeDetail />} />
        </Routes>
      </main>
    </div>
  );
};

export default Admin;
