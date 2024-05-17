import React, { useState } from "react";
import "./Form.css";

const AddEmployee = ({ onSubmit, onClose }) => {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNo, setPhoneNo] = useState("");
  const [password, setPassword] = useState("");
  const [roleType, setRoleType] = useState(""); // No default role type selected
  const [isSuccess, setIsSuccess] = useState(false);

  const handleSubmit = async (event) => {
    event.preventDefault();

    // Ensure a role type is selected
    if (!roleType) {
      alert("Please select a role type");
      return;
    }

    // Construct form data
    const formData = {
      username,
      email,
      phoneNo,
      password,
      roleType,
    };

    try {
      // Perform POST request with form data
      const response = await fetch("http://localhost:8080/api/users/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });

      if (!response.ok) {
        throw new Error("Network response was not ok.");
      }

      setUsername("");
      setEmail("");
      setPhoneNo("");
      setPassword("");
      setRoleType("");
      setIsSuccess(true);

      onSubmit();

      setTimeout(() => {
        onClose();
        setIsSuccess(false);
      }, 1000);
    } catch (error) {
      console.error("Error:", error);
    }
  };

  return (
    <div className="modal-content">
      <div className="form-container">
        <span onClick={onClose}>&times;</span>
        <h2>Add Employee</h2>
        {isSuccess && (
          <p className="success-message">Data inserted successfully!</p>
        )}
        <form onSubmit={handleSubmit}>
          <label>
            Username:
            <input
              type="text"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
          </label>
          <label>
            Email:
            <input
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </label>
          <label>
            Phone Number:
            <input
              type="text"
              value={phoneNo}
              onChange={(e) => setPhoneNo(e.target.value)}
            />
          </label>
          <label>
            Password:
            <input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </label>
          <label>
            Role Type:
            <div>
              <label>
                <input
                  type="radio"
                  value="EMPLOYEE"
                  checked={roleType === "EMPLOYEE"}
                  onChange={() => setRoleType("EMPLOYEE")}
                />
                Employee
              </label>
              <label>
                <input
                  type="radio"
                  value="ADMIN"
                  checked={roleType === "ADMIN"}
                  onChange={() => setRoleType("ADMIN")}
                />
                Admin
              </label>
              <label>
                <input
                  type="radio"
                  value="MANAGER"
                  checked={roleType === "MANAGER"}
                  onChange={() => setRoleType("MANAGER")}
                />
                Manager
              </label>
            </div>
          </label>
          <button type="submit">Submit</button>
          <button type="button" onClick={onClose}>
            Cancel
          </button>
        </form>
      </div>
    </div>
  );
};

export default AddEmployee;
