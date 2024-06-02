import React, { useEffect, useState } from "react";
import axios from "axios";
import EmployeeForm from "./EmployeeForm";
import { FaEdit, FaTrash } from "react-icons/fa";
import "./EmployeeDetail.css";

const EmployeeDetail = () => {
  const [users, setUsers] = useState([]);
  const [editingUser, setEditingUser] = useState(null);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = () => {
    axios
      .get("http://localhost:8182/api/users/roles")
      .then((response) => {
        setUsers(response.data);
      })
      .catch((error) => {
        console.error("There was an error fetching the user data!", error);
      });
  };

  const handleDelete = (userId) => {
    axios
      .delete(`http://localhost:8182/api/users/${userId}`)
      .then((response) => {
        setUsers(users.filter((user) => user.userId !== userId));
      })
      .catch((error) => {
        console.error("There was an error deleting the user!", error);
      });
  };

  const handleEdit = (user) => {
    setEditingUser(user);
  };

  const handleUpdate = () => {
    setEditingUser(null);
    fetchUsers();
  };

  return (
    <div className="table-container3">
      <h1>User Management</h1>
      {editingUser ? (
        <EmployeeForm user={editingUser} onUpdate={handleUpdate} />
      ) : (
        <table>
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Email</th>
              <th>Mobile No</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user, index) => (
              <tr key={user.userId}>
                <td>{index + 1}</td>
                <td>{user.username}</td>
                <td>{user.email}</td>
                <td>{user.phoneNo}</td>
                <td>
                  <button className="update" onClick={() => handleEdit(user)}>
                    <FaEdit /> Update
                  </button>
                  <button
                    className="delete"
                    onClick={() => handleDelete(user.userId)}
                  >
                    <FaTrash /> Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default EmployeeDetail;
