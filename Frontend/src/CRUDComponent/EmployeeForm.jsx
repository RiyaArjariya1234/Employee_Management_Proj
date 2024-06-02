import React, { useState, useEffect } from "react";
import axios from "axios";
//import "./Form.css";
import "./EmployeeForm.css";

const EmployeeForm = ({ user, onUpdate }) => {
  const [userData, setUserData] = useState(user);

  useEffect(() => {
    setUserData(user);
  }, [user]);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setUserData({ ...userData, [name]: value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    axios
      .put(`http://localhost:8182/api/users/${userData.userId}`, userData)
      .then((response) => {
        alert("User updated successfully!");
        onUpdate();
      })
      .catch((error) => {
        console.error("There was an error updating the user!", error);
      });
  };

  return (
    <form className="employee_container-form" onSubmit={handleSubmit}>
      <h1>Updation</h1>
      <div className="form_container-group">
        <label className="form_container-label">Name:</label>
        <input
          className="form_container-input"
          type="text"
          name="name"
          value={userData.name}
          onChange={handleInputChange}
          required
        />
      </div>
      <div className="form_container-group">
        <label className="form_container-label">Email:</label>
        <input
          className="form_container-input"
          type="email"
          name="email"
          value={userData.email}
          onChange={handleInputChange}
          required
        />
      </div>
      <div className="form_container-group">
        <label className="form_container-label">Mobile No:</label>
        <input
          className="form_container-input"
          type="text"
          name="mobileNo"
          value={userData.mobileNo}
          onChange={handleInputChange}
          required
        />
      </div>
      <div className="form_container-group">
        <label className="form_container-label">Password:</label>
        <input
          className="form_container-input"
          type="password"
          name="password"
          value={userData.password}
          onChange={handleInputChange}
          required
        />
      </div>
      <div className="form_container1">
        <button type="submit" className="form_container-button">
          Update User
        </button>
      </div>
    </form>
  );
};

export default EmployeeForm;
