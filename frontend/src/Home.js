import React from 'react';
import {Link} from 'react-router-dom';
import {Button, Container} from 'reactstrap';
import './App.css';
import AppNavbar from './AppNavbar';

const Home = () => {
    return (
        <div>
            <AppNavbar/>
            <Container fluid>
                <Button color="link"><Link to="/students/new">Add New Students</Link></Button>
            </Container>
            <Container fluid>
                <Button color="link"><Link to="/students">Student list</Link></Button>
            </Container>

            {/*Add New Courses*/}
            {/*Courses List*/}
            {/*Add New Results*/}
            {/*Results List*/}

        </div>
    );
}

export default Home;