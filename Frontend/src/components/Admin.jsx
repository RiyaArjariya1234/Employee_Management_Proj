// AdminPage.js
import React, { useState } from "react";
import AdminNavbar from "../NavBarComponent/AdminNavbar";
import AddEmployee from "../CRUDComponent/AddEmployee";
import AddProject from "../CRUDComponent/AddProject";
import AssignProjectToManager from "../CRUDComponent/AssignProjectToManager";
import { Route, Routes } from "react-router-dom";
import RequestResourceView from "../CRUDComponent/RequestResourceView";
import RequestApproved from "../CRUDComponent/RequestApproved";

const Admin = () => {
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
        <h1>Admin Page</h1>
        <p>Welcome to the admin page! Here you can manage your resources.</p>
        {/* Add more admin page content here */}
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
        </Routes>
      </main>
    </div>
  );
};

export default Admin;
