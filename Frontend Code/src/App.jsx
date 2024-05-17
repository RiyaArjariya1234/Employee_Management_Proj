import { BrowserRouter, Routes, Route } from "react-router-dom";
import React, { useState } from "react";
import Login from "./components/Login";
//import AdminNavbar from "./NavBarComponent/AdminNavbar";
import ManagerNavbar from "./NavBarComponent/ManagerNavbar";
//import EmployeeNavbar from "./NavBarComponent/EmployeeNavbar";
import Manager from "./components/Manager";
import Admin from "./components/Admin";
import Employee from "./components/Employee";
//import AddEmployee from "./CRUDComponent/AddEmployee";

function App() {
  /*const [isModalOpen, setIsModalOpen] = useState(false);

  const handleAddEmployee = () => {
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setIsModalOpen(false);
  };

  const handleSubmitForm = (formData) => {
    console.log("Form submitted with data:", formData);
    setIsModalOpen(false);
  };*/
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/employee" element={<Employee />} />
          <Route path="/manager" element={<ManagerNavbar />} />
          <Route path="/manager" element={<Manager />} />
          <Route path="/admin" element={<Admin />} />
        </Routes>
      </BrowserRouter>
    </div>
  );

  /*
   
  <Route
            path="/admin"
            element={<AdminNavbar onAddEmployee={handleAddEmployee} />}
          />

            {isModalOpen && (
        <div>
          <span onClick={handleCloseModal}></span>
          <AddEmployee onSubmit={handleSubmitForm} onClose={handleCloseModal} />
        </div>)}
          */

  /*return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/admin" element={<AdminNavbar />} />
          <Route path="/admin" element={<Admin />} />
          <Route path="/manager" element={<ManagerNavbar />} />
          <Route path="/manager" element={<Manager />} />
          <Route path="/employee" element={<EmployeeNavbar />} />
          <Route path="/employee" element={<Employee />} />
        </Routes>
      </BrowserRouter>
    </div>
  );*/
}

export default App;
