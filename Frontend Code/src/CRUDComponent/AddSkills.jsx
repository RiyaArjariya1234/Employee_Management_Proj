// src/SkillForm.js
import React, { useState } from "react";
import axios from "axios";
import "./Form.css";
const AddSkills = ({ onSubmit, onClose }) => {
  const [skillName, setSkillName] = useState("");
  const userId = localStorage.getItem("userId"); // Fetch the userId from localStorage

  const handleSubmit = async (e) => {
    e.preventDefault();

    const skillDTO = { skillName, userId };

    try {
      const response = await axios.post(
        "http://localhost:8181/api/skill/addSkill",
        skillDTO
      );
      console.log("Skill added successfully:", response.data);
      onSubmit();
      setTimeout(() => {
        onClose();
        setIsSuccess(false);
      }, 1000);
      // Handle success (e.g., show a message or redirect)
    } catch (error) {
      console.error("Error adding skill:", error);
      // Handle error (e.g., show an error message)
    }
  };

  return (
    <div className="modal-content">
      <div className="form-container">
        <span onClick={onClose}>&times;</span>
        <h2>Add Skill</h2>
        <form onSubmit={handleSubmit}>
          <label>Skill Name:</label>
          <input
            type="text"
            value={skillName}
            onChange={(e) => setSkillName(e.target.value)}
            required
          />

          <input type="hidden" value={userId} />

          <button type="submit">Submit</button>
          <button type="button" onClick={onClose}>
            Cancel
          </button>
        </form>
      </div>
    </div>
  );
};

export default AddSkills;
