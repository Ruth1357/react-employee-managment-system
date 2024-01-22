
import './App.css';
import Footer from './components/Footer';
import Header from './components/Header';
import  ListEmployeeComponent from './components/ListEmployeeComponent';
import  AddEmployeeComponent from './components/AddEmployeeComponent';

import {BrowserRouter as Router, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App"> 
    <Router>
        <Header/>
        <div>
        <Routes>
          <Route exact path='/' Component={ListEmployeeComponent}></Route>      
          <Route exact path='/employees' Component={ListEmployeeComponent}></Route>     
          <Route  path='/add-employee' Component={AddEmployeeComponent}></Route>
          <Route path = "/edit-employee/:id" Component = {AddEmployeeComponent}></Route>
        </Routes>
        </div>
        <Footer/>
    </Router>
    </div>
  );
}

export default App;
