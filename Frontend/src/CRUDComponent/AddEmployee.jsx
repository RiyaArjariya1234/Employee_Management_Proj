import React, { useState } from "react";
import "./Form.css";

const AddEmployee = ({ onSubmit, onClose }) => {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNo, setPhoneNo] = useState("");
  const [password, setPassword] = useState("");
  const [roleType, setRoleType] = useState("");
  const [successMessage, setSuccessMessage] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const handleSubmit = async (event) => {
    event.preventDefault();
    if (!username || !email || !phoneNo || !password || !roleType) {
      setErrorMessage("All fields are required.");
      return;
    }
    if (!roleType) {
      alert("Please select a role type");
      return;
    }

    const formData = {
      username,
      email,
      phoneNo,
      password,
      roleType,
    };

    try {
      const response = await fetch("http://localhost:8182/api/users/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });

      const result = await response.text();

      if (response.ok) {
        setUsername("");
        setEmail("");
        setPhoneNo("");
        setPassword("");
        setRoleType("");
        setSuccessMessage("Added successfully!");
        setErrorMessage("");
        console.log("Success:", result);

        onSubmit();

        setTimeout(() => {
          onClose();
          setSuccessMessage("");
        }, 2000);
      } else {
        console.log("Error result:", result);
        setErrorMessage(result);
      }
    } catch (error) {
      console.error("Error:", error);
      setErrorMessage("Error occurred during registration");
    }
  };

  return (
    <div>
      <div className="form-container">
        <span onClick={onClose} className="close">
          &times;
        </span>
        <h2>Add Employee</h2>
        <form onSubmit={handleSubmit}>
          <label>
            Username:
            <input
              type="text"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
            />
          </label>
          <label>
            Email:
            <input
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </label>
          <label>
            Phone Number:
            <input
              type="text"
              value={phoneNo}
              onChange={(e) => setPhoneNo(e.target.value)}
              required
            />
          </label>
          <label>
            Password:
            <input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
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
        {successMessage && <p className="success-message">{successMessage}</p>}
        {errorMessage && <p className="error-message">{errorMessage}</p>}
      </div>
    </div>
  );
};

export default AddEmployee;
