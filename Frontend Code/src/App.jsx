import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/Login";
import Manager from "./components/Manager";
import Admin from "./components/Admin";
import Employee from "./components/Employee";

//import Home from "./components/Home";

function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/manager" element={<Manager />} />
          <Route path="/admin" element={<Admin />} />
          <Route path="/employee" element={<Employee />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
