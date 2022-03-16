import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route, } from 'react-router-dom';
import  { Login } from './Login/Login.js';
import {StudentsTable} from './StudentsTable/StudentsTable.js'


function App() {
  return (
    <div className="wrapper">
      <BrowserRouter>
        <Routes>
          <Route path="/Login" element={<Login/>}/>
          <Route path="/StudentsTable" element={<StudentsTable/>}/>   
        </Routes>
      </BrowserRouter>
    </div>  
  );
}

export default App;
