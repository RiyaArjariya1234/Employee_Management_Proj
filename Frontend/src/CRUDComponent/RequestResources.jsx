import React, { useState, useEffect } from "react";
import axios from "axios";
import "./RequestResources.css";

const RequestResources = () => {
  const [skill, setSkill] = useState("");
  const [users, setUsers] = useState([]);
  const [projects, setProjects] = useState([]);
  const [error, setError] = useState("");
  //const managerId = 1;
  const managerId = localStorage.getItem("userId");

  useEffect(() => {
    const fetchProjects = async () => {
      try {
        console.log(managerId);
        const response = await axios.get(
          `http://localhost:8182/api/project/user/${managerId}`
        );
        setProjects(response.data);
      } catch (error) {
        console.error("Error fetching projects:", error);
      }
    };

    fetchProjects();
  }, [managerId]);

  useEffect(() => {
    const fetchUsers = async () => {
      if (skill.trim() === "") {
        setUsers([]);
        setError("");
        return;
      }

      try {
        const response = await axios.get(
          `http://localhost:8182/api/skill/filter?skillName=${skill}`
        );
        if (response.data.length > 0) {
          setUsers(response.data);
          setError("");
        } else {
          setUsers([]);
          setError("No users found with that skill");
        }
      } catch (error) {
        console.error("Error fetching users:", error);
        setUsers([]);
        setError("Error fetching users");
      }
    };

    const debounceTimeout = setTimeout(fetchUsers, 300);

    return () => clearTimeout(debounceTimeout);
  }, [skill]);

  const handleSkillChange = (event) => {
    setSkill(event.target.value);
  };

  const handleRequestSubmit = async (userId, projectId) => {
    if (!projectId) {
      alert("Please select a project.");
      return;
    }

    const requestData = {
      managerId,
      employeeId: userId,
      projectId,
    };

    try {
      const response = await axios.post(
        `http://localhost:8182/api/request/addRequest`,
        requestData
      );
      alert("Request sent successfully!");
      console.log("Success:", response.data);
    } catch (error) {
      if (error.response) {
        if (error.response.status === 409) {
          alert(error.response.data);
        } else {
          alert("Failed to send request");
        }
      } else {
        console.error("Error sending request:", error);
        alert("Failed to send request");
      }
    }
  };

  return (
    <div className="Rcontainer">
      <h1>Filter Employees by Skill</h1>
      <form onSubmit={(e) => e.preventDefault()} className="Rsearch-form">
        <div className="Rsearch-input-container">
          <input
            type="text"
            id="skill"
            value={skill}
            onChange={handleSkillChange}
            placeholder="Search by Skill"
            className="Rsearch-input"
          />
          <button type="submit" className="Rsearch-button">
            🔍
          </button>
        </div>
      </form>

      <h2>Users</h2>
      {error && <p className="Rerror-message">{error}</p>}
      <table className="Remployee-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>Select Project</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user, ind) => (
            <tr key={user.userId}>
              <td>{ind + 1}</td>
              <td>{user.name}</td>
              <td>{user.email}</td>
              <td>
                <div className="Rselect-container">
                  {user.name &&
                    user.email &&
                    (projects.length > 0 ? (
                      <select
                        value={user.selectedProject || ""}
                        onChange={(e) => {
                          const newUsers = users.map((u) =>
                            u.userId === user.userId
                              ? { ...u, selectedProject: e.target.value }
                              : u
                          );
                          setUsers(newUsers);
                        }}
                      >
                        <option value="">Select Project</option>
                        {projects.map((project) => (
                          <option
                            key={project.projectId}
                            value={project.projectId}
                          >
                            {project.name}
                          </option>
                        ))}
                      </select>
                    ) : (
                      <p className="Rno-project-message">
                        Not allocated to any project
                      </p>
                    ))}
                </div>
              </td>
              <td>
                <button
                  onClick={() =>
                    handleRequestSubmit(user.userId, user.selectedProject)
                  }
                  className="Rsubmit-button"
                >
                  Request
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default RequestResources;
