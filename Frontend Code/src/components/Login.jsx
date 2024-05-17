//import React, { useState } from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./styles.css";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [selectedRoleType, setSelectedRoleType] = useState("");
  const navigate = useNavigate();

  async function login(event) {
    event.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8080/api/users/login",
        {
          email: email,
          password: password,
          roleType: selectedRoleType,
        }
      );
      console.log(response);
      const { message } = response.data;
      //const check = response.data;

      // const { rr } = response.data.roleType;

      if (message === "Email not exists") {
        alert("Email not exists");
      } else if (message === "Login successful") {
        // alert(roleType);
        if (selectedRoleType === "ADMIN") {
          navigate("/admin");
        } else if (selectedRoleType === "MANAGER") {
          navigate("/manager");
        } else if (selectedRoleType === "EMPLOYEE") {
          navigate("/employee");
        } else {
          alert("Unknown userType");
        }
      } else {
        alert("Incorrect Email or Password");
      }
    } catch (err) {
      console.error(err);
      alert("Error occurred during login");
    }
  }

  return (
    <div>
      <div className="container">
        <div className="row">
          <h2>Login</h2>
          <hr />
          <br />
        </div>

        <div className="row">
          <div className="col-sm-6">
            <form onSubmit={login}>
              <div className="form-group">
                <input
                  type="email"
                  className="form-control"
                  placeholder="Enter Email"
                  value={email}
                  onChange={(event) => {
                    setEmail(event.target.value);
                  }}
                  required
                />
              </div>

              <div className="form-group">
                <input
                  type="password"
                  className="form-control"
                  placeholder="Enter Password"
                  value={password}
                  onChange={(event) => {
                    setPassword(event.target.value);
                  }}
                  required
                />
              </div>

              <div className="form-group">
                <select
                  className="form-control"
                  value={selectedRoleType}
                  onChange={(event) => setSelectedRoleType(event.target.value)}
                  required
                >
                  <option value="">Select Role Type</option>
                  <option value="ADMIN">Admin</option>
                  <option value="MANAGER">Manager</option>
                  <option value="EMPLOYEE">Employee</option>
                </select>
              </div>

              <button type="submit" className="btn btn-primary">
                Login
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
