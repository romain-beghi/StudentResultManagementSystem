import React, {useEffect, useState} from 'react';
import {Button, Container, Form, FormGroup, Input, Label} from 'reactstrap';
import {useNavigate, useParams} from 'react-router-dom';
import AppNavbar from './AppNavbar';

const StudentEdit = () => {
    const initialFormState = {
        firstName: '',
        familyName: '',
        dateOfBirth: '',
        email: ''
    };
    const [student, setStudent] = useState(initialFormState);
    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
    }, [id, setStudent]);

    const handleChange = (event) => {
        const { name, value } = event.target

        setStudent({ ...student, [name]: value })
    }

    const handleSubmit = async (event) => {
        event.preventDefault();

        await fetch(`/srms-api/v1/students/${student.id ? `${student.id}` : ''}`, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(student)
        });
        setStudent(initialFormState);
        navigate('/students/');
    }

    const title = <h2>Add Student</h2>;

    return (<div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={handleSubmit}>
                    <FormGroup>
                        <Label for="firstName">First name</Label>
                        <Input type="text" name="firstName" id="firstName" value={student.firstName || ''}
                               onChange={handleChange} autoComplete="firstName"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="familyName">Family name</Label>
                        <Input type="text" name="familyName" id="familyName" value={student.familyName || ''}
                               onChange={handleChange} autoComplete="familyName"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="dateOfBirth">Date of Birth</Label>
                        <Input type="text" name="dateOfBirth" id="dateOfBirth" value={student.dateOfBirth || ''}
                               onChange={handleChange} autoComplete="dateOfBirth"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="email">Email</Label>
                        <Input type="text" name="email" id="email" value={student.email || ''}
                               onChange={handleChange} autoComplete="email"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Submit</Button>{' '}
                    </FormGroup>
                </Form>
            </Container>
        </div>
    )
};

export default StudentEdit;