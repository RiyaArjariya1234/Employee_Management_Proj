import React, { useState } from "react";
import "./Form.css";

const AddProject = ({ onSubmit, onClose }) => {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [isSuccess, setIsSuccess] = useState(false);

  const handleSubmit = async (event) => {
    event.preventDefault();

    const formData = {
      name,
      description,
    };

    try {
      // Perform POST request with form data
      const response = await fetch(
        "http://localhost:8182/api/project/addProject",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(formData),
        }
      );

      if (!response.ok) {
        throw new Error("Network response was not ok.");
      }

      setName("");
      setDescription("");
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
        <h2>Add Project</h2>
        {isSuccess && (
          <p className="success-message">Data inserted successfully!</p>
        )}
        <form onSubmit={handleSubmit}>
          <label>
            ProjectName:
            <input
              type="text"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
          </label>
          <label>
            Description:
            <input
              type="text"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
            />
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

export default AddProject;
