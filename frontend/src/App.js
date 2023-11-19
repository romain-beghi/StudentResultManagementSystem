import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import './App.css';
import Home from './Home';
import StudentList from './StudentList';
import StudentEdit from './StudentEdit';
import CourseList from './CourseList';
import CourseEdit from './CourseEdit';
import ResultList from "./ResultList";
import ResultEdit from "./ResultEdit";

const App = () => {
    return (
        <Router>
            <Routes>
                <Route exact path="/" element={<Home/>}/>
                <Route path='/students' exact={true} element={<StudentList/>}/>
                <Route path='/students/:id' element={<StudentEdit/>}/>
                <Route path='/courses' exact={true} element={<CourseList/>}/>
                <Route path='/courses/:id' element={<CourseEdit/>}/>
                <Route path='/results' exact={true} element={<ResultList/>}/>
                <Route path='/results/:id' element={<ResultEdit/>}/>
            </Routes>
        </Router>
    )
}

export default App;