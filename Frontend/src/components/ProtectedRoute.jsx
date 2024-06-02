import React from "react";
import { Navigate } from "react-router-dom";

const ProtectedRoute = ({ children, allowedRoles }) => {
  const userId = localStorage.getItem("userId");
  const roleType = localStorage.getItem("roleType");

  if (!userId || !allowedRoles.includes(roleType)) {
    return <Navigate to="/" />;
  }

  return children;
};

export default ProtectedRoute;
