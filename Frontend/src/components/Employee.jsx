import React, { useState } from "react";
import AddSkills from "../CRUDComponent/AddSkills";
import EmployeeNavbar from "../NavBarComponent/EmployeeNavbar";

const Employee = () => {
  const [showAddSkillForm, setShowAddSkillForm] = useState(false);
  const handleOpenAddSkillForm = () => setShowAddSkillForm(true);
  const handleCloseAddSkillForm = () => setShowAddSkillForm(false);

  const handleAddSkillFormSubmit = () => {};
  return (
    <div>
      <EmployeeNavbar onAddSkill={handleOpenAddSkillForm} />
      <main>
        <h1>Employee Page</h1>
        <p>Welcome to the admin page! Here you can manage your resources.</p>

        {showAddSkillForm && (
          <div className="modal">
            <div>
              <AddSkills
                onSubmit={handleAddSkillFormSubmit}
                onClose={handleCloseAddSkillForm}
              />
            </div>
          </div>
        )}
      </main>
    </div>
  );
};
export default Employee;
