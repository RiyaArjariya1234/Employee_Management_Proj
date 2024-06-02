import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./styles.css";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [selectedRoleType, setSelectedRoleType] = useState("");
  const [successMessage, setSuccessMessage] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();

  async function login(event) {
    event.preventDefault();
    setSuccessMessage("");
    setErrorMessage("");

    try {
      const response = await axios.post(
        "http://localhost:8182/api/users/login",
        {
          email: email,
          password: password,
          roleType: selectedRoleType,
        }
      );

      if (response.status === 200) {
        const userData = response.data;
        localStorage.setItem("userId", userData.userId);
        localStorage.setItem("email", userData.email);
        localStorage.setItem("roleType", selectedRoleType);

        setSuccessMessage("Login successful!");

        setTimeout(() => {
          if (selectedRoleType === "ADMIN") {
            navigate("/admin");
          } else if (selectedRoleType === "MANAGER") {
            navigate("/manager");
          } else if (selectedRoleType === "EMPLOYEE") {
            navigate("/employee");
          } else {
            setErrorMessage("Unknown userType");
          }
        }, 1000);
      } else {
        setErrorMessage("Incorrect Email or Password");
      }
    } catch (err) {
      console.error(err);
      if (err.response && err.response.data && err.response.data.message) {
        setErrorMessage(err.response.data.message);
      } else {
        setErrorMessage("Error occurred during login");
      }
    }
  }

  return (
    <div className="back-color">
      <div>
        <div className="container1">
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
                    className="custom-input"
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
                    className="custom-input"
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
                    className="custom-input"
                    value={selectedRoleType}
                    onChange={(event) =>
                      setSelectedRoleType(event.target.value)
                    }
                    required
                  >
                    <option value="">Select Role Type</option>
                    <option value="ADMIN">Admin</option>
                    <option value="MANAGER">Manager</option>
                    <option value="EMPLOYEE">Employee</option>
                  </select>
                </div>

                <button type="submit" className="btn">
                  Login
                </button>
              </form>

              {successMessage && (
                <div className="alert alert-success" role="alert">
                  {successMessage}
                </div>
              )}
              {errorMessage && (
                <div className="danger" role="alert">
                  {errorMessage}
                </div>
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
