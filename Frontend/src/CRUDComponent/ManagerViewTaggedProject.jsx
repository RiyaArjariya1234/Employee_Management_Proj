import React, { useEffect, useState } from "react";
import axios from "axios";
import "./RequestResourceView.css";

function ManagerViewTaggedProject() {
  const [requests, setRequests] = useState([]);

  useEffect(() => {
    const storedEmployeeId = localStorage.getItem("userId");
    if (storedEmployeeId) {
      fetchApprovedRequests(storedEmployeeId);
    }
  }, []);

  const fetchApprovedRequests = (managerId) => {
    axios
      .get(`http://localhost:8182/api/request/approved/managerId/${managerId}`)
      .then((response) => {
        setRequests(response.data);
      })
      .catch((error) => {
        console.error("There was an error fetching the requests!", error);
      });
  };

  return (
    <div className="App">
      {requests.length > 0 ? (
        <>
          <h1>View Tagged Project As Well Team Members</h1>
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Employee Name</th>
                <th>Manager Name</th>
                <th>Project Name</th>
              </tr>
            </thead>
            <tbody>
              {requests.map((request, index) => (
                <tr key={index}>
                  <td>{index + 1}</td>
                  <td>{request.employeeName}</td>
                  <td>{request.managerName}</td>
                  <td>{request.projectName}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </>
      ) : (
        <h1 id="heading-color">Not Assigned to any Project.</h1>
      )}
    </div>
  );
}

export default ManagerViewTaggedProject;
