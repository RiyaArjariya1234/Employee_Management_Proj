import { BrowserRouter, Routes, Route } from "react-router-dom";
import React, { useState } from "react";
import Login from "./components/Login";
import ManagerNavbar from "./NavBarComponent/ManagerNavbar";
import Manager from "./components/Manager";
import Admin from "./components/Admin";
import Employee from "./components/Employee";

function App() {
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
}

export default App;
