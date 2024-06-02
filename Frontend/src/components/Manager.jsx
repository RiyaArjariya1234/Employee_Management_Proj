import React from "react";
//import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import { Route, Routes, useLocation, Link } from "react-router-dom";
import Home from "./Home";
import RequestResources from "../CRUDComponent/RequestResources";

import ManagerNavbar from "../NavBarComponent/ManagerNavbar";

import ManagerApprovedRequestView from "../CRUDComponent/ManagerApprovedRequestView";
import ManagerViewTaggedProject from "../CRUDComponent/ManagerViewTaggedProject";
import "./Welcome.css";

function Manager() {
  const location = useLocation();
  const userName = localStorage.getItem("email");
  return (
    <div>
      <ManagerNavbar />
      <main>
        {location.pathname === "/manager" && (
          <div className="hero-section">
            <div className="hero-content">
              <h1>Welcome to the Manager Dashboard</h1>
              <p>
                Hi, Welcome {userName}! , We appreciate your efforts in managing
                the team and ensuring everything runs smoothly. Have a
                productive day!
              </p>
            </div>
          </div>
        )}
        {!location.pathname.endsWith("/manager") && (
          <div className="go-back">
            <Link to="/manager">Go Back to Home Page</Link>
          </div>
        )}

        <Routes>
          <Route path="/RequestResources" element={<RequestResources />} />
          <Route
            path="/ManagerApprovedRequestView"
            element={<ManagerApprovedRequestView />}
          />
          <Route
            path="/ManagerViewTaggedProject"
            element={<ManagerViewTaggedProject />}
          />
          <Route path="/Home" element={<Home />} />
        </Routes>
      </main>
    </div>
  );
}
export default Manager;
