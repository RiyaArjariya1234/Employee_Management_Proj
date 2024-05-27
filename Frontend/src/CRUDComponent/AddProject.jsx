import React, { useState } from "react";
import "./Form.css";

const AddProject = ({ onSubmit, onClose }) => {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  // const [isSuccess, setIsSuccess] = useState(false);
  const [successMessage, setSuccessMessage] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const handleSubmit = async (event) => {
    event.preventDefault();

    if (!name || !description) {
      setErrorMessage("All fields are required.");
      return;
    }

    const formData = {
      name,
      description,
    };

    try {
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

      if (response.ok) {
        setName("");
        setDescription("");
        //setIsSuccess(true);
        setSuccessMessage("Project added successfully!");
        setErrorMessage("");
        //  alert(result);

        onSubmit();

        setTimeout(() => {
          onClose();
          // setIsSuccess(false);
          setSuccessMessage("");
        }, 1000);
      } else {
        setErrorMessage("Sone Error occurred");
      }
    } catch (error) {
      console.error("Error:", error);
      setErrorMessage("Error occurred during project addition");
    }
  };

  return (
    <div>
      <div className="form-container">
        <span onClick={onClose}>&times;</span>
        <h2>Add Project</h2>

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
        {successMessage && <p className="success-message">{successMessage}</p>}
        {errorMessage && <p className="error-message">{errorMessage}</p>}
      </div>
    </div>
  );
};

export default AddProject;
