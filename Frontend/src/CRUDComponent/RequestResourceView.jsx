import React, { useEffect, useState } from "react";
import axios from "axios";
import "./RequestResourceView.css";

function RequestResourceView() {
  const [requests, setRequests] = useState([]);

  useEffect(() => {
    fetchPendingRequests();
  }, []);

  const fetchPendingRequests = () => {
    axios
      .get("http://localhost:8182/api/request/pending")
      .then((response) => {
        setRequests(response.data);
      })
      .catch((error) => {
        console.error("There was an error fetching the requests!", error);
      });
  };

  const handleApprove = (id) => {
    axios
      .put(`http://localhost:8182/api/request/${id}/approve`)
      .then(() => {
        fetchPendingRequests();
        alert("Approved Request Successfully");
      })
      .catch((error) => {
        console.error("There was an error approving the request!", error);
      });
  };

  const handleReject = (id) => {
    axios
      .delete(`http://localhost:8182/api/request/${id}/reject`)
      .then(() => {
        fetchPendingRequests();
        alert("Request Rejected");
      })
      .catch((error) => {
        console.error("There was an error rejecting the request!", error);
      });
  };

  return (
    <div className="App">
      {requests.length > 0 ? (
        <>
          <h1>Pending Requests</h1>
          <table>
            <thead>
              <tr>
                <th>Request ID</th>
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
                        className="approve-button"
                        onClick={() => handleApprove(request.requestId)}
                      >
                        Approve
                      </button>
                      <button
                        className="reject-button"
                        onClick={() => handleReject(request.requestId)}
                      >
                        Reject
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </>
      ) : (
        <h1 id="heading-color">There are no pending requests.</h1>
      )}
    </div>
  );
}

export default RequestResourceView;

/*import React, { useEffect, useState } from "react";
import axios from "axios";
import "./RequestResourceView.css";

function RequestResourceView() {
  const [requests, setRequests] = useState([]);

  useEffect(() => {
    fetchPendingRequests();
  }, []);

  const fetchPendingRequests = () => {
    axios
      .get("http://localhost:8182/api/request/pending")
      .then((response) => {
        setRequests(response.data);
      })
      .catch((error) => {
        console.error("There was an error fetching the requests!", error);
      });
  };

  const handleApprove = (id) => {
    axios
      .put(`http://localhost:8182/api/request/${id}/approve`)
      .then(() => {
        fetchPendingRequests();
      })
      .catch((error) => {
        console.error("There was an error approving the request!", error);
      });
  };

  const handleReject = (id) => {
    axios
      .delete(`http://localhost:8182/api/request/${id}/reject`)
      .then(() => {
        fetchPendingRequests();
      })
      .catch((error) => {
        console.error("There was an error rejecting the request!", error);
      });
  };

  return (
    <div className="App">
      {requests.length > 0 && (
        <>
          <h1>Pending Requests</h1>
          <table>
            <thead>
              <tr>
                <th>Request ID</th>
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
                        className="approve-button"
                        onClick={() => handleApprove(request.requestId)}
                      >
                        Approve
                      </button>
                      <button
                        className="reject-button"
                        onClick={() => handleReject(request.requestId)}
                      >
                        Reject
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

export default RequestResourceView;*/

/*import React, { useEffect, useState } from "react";
import axios from "axios";
import "./RequestResourceView.css";

function RequestResourceView() {
  const [requests, setRequests] = useState([]);

  useEffect(() => {
    fetchPendingRequests();
  }, []);

  const fetchPendingRequests = () => {
    axios
      .get("http://localhost:8182/api/request/pending")
      .then((response) => {
        setRequests(response.data);
      })
      .catch((error) => {
        console.error("There was an error fetching the requests!", error);
      });
  };

  const handleApprove = (id) => {
    axios
      .put(`http://localhost:8182/api/request/${id}/approve`)
      .then(() => {
        alert("Request approved successfully!");
        fetchPendingRequests(); // Refresh the list after approval
      })
      .catch((error) => {
        console.error("There was an error approving the request!", error);
      });
  };

  const handleReject = (id) => {
    axios
      .delete(`http://localhost:8182/api/request/${id}/reject`)
      .then(() => {
        alert("Request rejected successfully!");
        fetchPendingRequests(); // Refresh the list after rejection
      })
      .catch((error) => {
        console.error("There was an error rejecting the request!", error);
      });
  };

  return (
    <div className="App">
      {requests.length > 0 && (
        <>
          <h1>Pending Requests</h1>
          <table>
            <thead>
              <tr>
                <th>Request ID</th>
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
                    <button
                      onClick={() => handleApprove(request.requestId)}
                      className="approve-button"
                    >
                      Approve
                    </button>
                    <button
                      onClick={() => handleReject(request.requestId)}
                      className="reject-button"
                    >
                      Reject
                    </button>
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

export default RequestResourceView;*/

/*import React, { useEffect, useState } from "react";
import axios from "axios";
import "./RequestResourceView.css";

function RequestResourceView() {
  const [requests, setRequests] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8182/api/request/pending")
      .then((response) => {
        setRequests(response.data);
      })
      .catch((error) => {
        console.error("There was an error fetching the requests!", error);
      });
  }, []);

  return (
    <div className="App">
      {requests.length > 0 && (
        <>
          <h1>Pending Requests</h1>
          <table>
            <thead>
              <tr>
                <th>Request ID</th>
                <th>New ID</th>
                <th>Employee Name</th>
                <th>Manager Name</th>
                <th>Project Name</th>
                <th>Project ID</th>
              </tr>
            </thead>
            <tbody>
              {requests.map((request, index) => (
                <tr key={index}>
                  <td>{index + 1}</td>
                  <td>{request.requestId}</td>
                  <td>{request.employeeName || "N/A"}</td>
                  <td>{request.managerName || "N/A"}</td>
                  <td>{request.projectName || "N/A"}</td>
                  <td>{request.projectId}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </>
      )}
    </div>
  );
}

export default RequestResourceView;*/

/*import React, { useEffect, useState } from "react";
import axios from "axios";
import "./RequestResourceView.css";

function RequestResourceView() {
  const [requests, setRequests] = useState([]);
  useEffect(() => {
    axios
      .get("http://localhost:8182/api/request/pending")
      .then((response) => {
        setRequests(response.data);
      })
      .catch((error) => {
        console.error("There was an error fetching the requests!", error);
      });
  }, []);

  return (
    <div className="App">
      <h1>Pending Requests</h1>
      <table>
        <thead>
          <tr>
            <th>Request ID</th>
            <th>Employee Name</th>
            <th>Manager Name</th>
            <th>Project Name</th>
            <th>Project ID</th>
          </tr>
        </thead>
        <tbody>
          {requests.map((request, index) => (
            <tr key={index}>
              <td>{index + 1}</td>
              <td>{request.employeeName || "N/A"}</td>
              <td>{request.managerName || "N/A"}</td>
              <td>{request.projectName || "N/A"}</td>
              <td>{request.projectId}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default RequestResourceView;*/
