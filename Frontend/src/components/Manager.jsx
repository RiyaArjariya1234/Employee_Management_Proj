import React from "react";
//import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import { Route, Routes } from "react-router-dom";
import Home from "./Home";
import RequestResources from "../CRUDComponent/RequestResources";

import ManagerNavbar from "../NavBarComponent/ManagerNavbar";
function Manager() {
  return (
    <div>
      <ManagerNavbar />
      <Routes>
        <Route path="/RequestResources" element={<RequestResources />} />
        <Route path="/Home" element={<Home />} />
      </Routes>
    </div>
  );
}
export default Manager;
