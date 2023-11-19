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
                <Button color="link"><Link to="/students">Student list</Link></Button>
            </Container>
        </div>
    );
}

export default Home;