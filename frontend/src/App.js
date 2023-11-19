import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import './App.css';
import Home from './Home';
import StudentList from './StudentList';
import StudentEdit from './StudentEdit';

const App = () => {
    return (
        <Router>
            <Routes>
                <Route exact path="/" element={<Home/>}/>
                <Route path='/students' exact={true} element={<StudentList/>}/>
                <Route path='/students/:id' element={<StudentEdit/>}/>
            </Routes>
        </Router>
    )
}

export default App;