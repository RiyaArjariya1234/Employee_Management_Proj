import React, { useEffect, useState } from "react";
import axios from "axios";
import "./RequestResourceView.css";

function RequestApproved() {
  const [requests, setRequests] = useState([]);

  useEffect(() => {
    fetchApprovedRequests();
  }, []);

  const fetchApprovedRequests = () => {
    axios
      .get("http://localhost:8182/api/request/approved")
      .then((response) => {
        setRequests(response.data);
      })
      .catch((error) => {
        console.error("There was an error fetching the requests!", error);
      });
  };

  const handleReject = (id) => {
    axios
      .delete(`http://localhost:8182/api/request/${id}/reject`)
      .then(() => {
        fetchApprovedRequests();
        alert("Request successfully removed");
      })
      .catch((error) => {
        console.error("There was an error removing the request!", error);
      });
  };

  return (
    <div className="App">
      {requests.length > 0 ? (
        <>
          <h1>Approved Requests</h1>
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Employee Name</th>
                <th>Manager Name</th>
                <th>Project Name</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {requests.map((request, index) => (
                <tr key={index}>
                  <td>{index + 1}</td>
                  <td>{request.employeeName || "N/A"}</td>
                  <td>{request.managerName || "N/A"}</td>
                  <td>{request.projectName || "N/A"}</td>
                  <td>
                    <div className="button-container">
                      <button
                        //className="reject-button1"
                        onClick={() => handleReject(request.requestId)}
                      >
                        Remove
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </>
      ) : (
        <h1 id="heading-color">No requests approved.</h1>
      )}
    </div>
  );
}

export default RequestApproved;

/*import React, { useEffect, useState } from "react";
import axios from "axios";
import "./RequestResourceView.css";

function RequestApproved() {
  const [requests, setRequests] = useState([]);

  useEffect(() => {
    fetchApprovedRequests();
  }, []);

  const fetchApprovedRequests = () => {
    axios
      .get("http://localhost:8182/api/request/approved")
      .then((response) => {
        setRequests(response.data);
      })
      .catch((error) => {
        console.error("There was an error fetching the requests!", error);
      });
  };

  const handleReject = (id) => {
    axios
      .delete(`http://localhost:8182/api/request/${id}/reject`)
      .then(() => {
        fetchApprovedRequests();
      })
      .catch((error) => {
        console.error("There was an error removing the request!", error);
      });
  };

  return (
    <div className="App">
      {requests.length > 0 && (
        <>
          <h1>Approved Requests</h1>
          <table>
            <thead>
              <tr>
                <th> ID</th>
                <th>Employee Name</th>
                <th>Manager Name</th>
                <th>Project Name</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {requests.map((request, index) => (
                <tr key={index}>
                  <td>{index + 1}</td>
                  <td>{request.employeeName || "N/A"}</td>
                  <td>{request.managerName || "N/A"}</td>
                  <td>{request.projectName || "N/A"}</td>
                  <td>
                    <div className="button-container">
                      <button
                        className="reject-button1"
                        onClick={() => handleReject(request.requestId)}
                      >
                        Remove
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </>
      )}
    </div>
  );
}
export default RequestApproved;*/
