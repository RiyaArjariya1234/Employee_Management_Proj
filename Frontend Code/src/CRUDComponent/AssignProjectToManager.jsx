import React, { useEffect, useState } from "react";
import "./Form.css";
const AssignProjectToManager = ({ onSubmit, onClose }) => {
  const [projects, setProjects] = useState([]);
  const [managers, setManagers] = useState([]);
  const [selectedProject, setSelectedProject] = useState("");
  const [selectedManager, setSelectedManager] = useState("");
  const [message, setMessage] = useState("");

  useEffect(() => {
    // Fetch projects
    fetch("http://localhost:8182/api/project")
      .then((response) => response.json())
      .then((data) => setProjects(data))
      .catch((error) => console.error("Error fetching projects:", error));

    // Fetch managers
    fetch("http://localhost:8182/api/managers")
      .then((response) => response.json())
      .then((data) => setManagers(data))
      .catch((error) => console.error("Error fetching managers:", error));
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    fetch(
      `http://localhost:8182/api/assignments/addassignments?projectId=${selectedProject}&managerId=${selectedManager}`,
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          projectId: selectedProject,
          managerId: selectedManager,
        }),
      }
    )
      .then((response) => {
        if (!response.ok) {
          return response.text().then((text) => {
            throw new Error(text);
          });
        } else {
          return response.text(); // Return plain text
        }
      })
      /* .then((response) => {
        if (response.status === 400) {
          return response.json().then((data) => {
            throw new Error(data.message);
          });
        } else if (response.ok) {
          return response.json();
        }
      })*/
      .then((data) => {
        setMessage("Project assigned successfully!");
        onSubmit();
      })
      .catch((error) => {
        if (error.message.includes("Manager not found")) {
          setMessage("Manager not found.");
        } else if (error.message.includes("could not execute statement")) {
          setMessage("This project is already assigned.");
        } else {
          //setMessage(`Error: ${error.message}`);
          setMessage("This project is already assigned.");
        }
      });
  };

  return (
    <div className="modal-content">
      <div className="form-container">
        <h2>Assign Project to Manager</h2>
        <form onSubmit={handleSubmit}>
          <div>
            <label htmlFor="project"></label>
            <select
              id="project"
              value={selectedProject}
              onChange={(e) => setSelectedProject(e.target.value)}
              required
            >
              <option value="">Select a project</option>
              {projects.map((project) => (
                <option key={project.projectId} value={project.projectId}>
                  {project.name}
                </option>
              ))}
            </select>
          </div>
          <div>
            <label htmlFor="manager"></label>
            <select
              id="manager"
              value={selectedManager}
              onChange={(e) => setSelectedManager(e.target.value)}
              required
            >
              <option value="">Select a manager</option>
              {managers.map((manager) => (
                <option key={manager.managerId} value={manager.managerId}>
                  {manager.managerName}
                </option>
              ))}
            </select>
          </div>
          <button type="submit">Assign</button>
          <button type="button" onClick={onClose}>
            Cancel
          </button>
        </form>
        {message && <p>{message}</p>}
      </div>
    </div>
  );
};

export default AssignProjectToManager;
