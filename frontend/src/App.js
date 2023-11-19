import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import './App.css';
import Home from './Home';
import StudentList from './StudentList';
import StudentEdit from './StudentEdit';
import CourseList from './CourseList';
import CourseEdit from './CourseEdit';

const App = () => {
    return (
        <Router>
            <Routes>
                <Route exact path="/" element={<Home/>}/>
                <Route path='/students' exact={true} element={<StudentList/>}/>
                <Route path='/students/:id' element={<StudentEdit/>}/>
                <Route path='/courses' exact={true} element={<CourseList/>}/>
                <Route path='/courses/:id' element={<CourseEdit/>}/>
            </Routes>
        </Router>
    )
}

export default App;