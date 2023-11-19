import React, {useEffect, useState} from 'react';
import {Button, Container, Form, FormGroup, Input, Label} from 'reactstrap';
import {useNavigate, useParams} from 'react-router-dom';
import AppNavbar from './AppNavbar';

const CourseEdit = () => {
    const initialFormState = {
        name: ''
    };
    const [course, setCourse] = useState(initialFormState);
    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
    }, [id, setCourse]);

    const handleChange = (event) => {
        const { name, value } = event.target

        setCourse({ ...course, [name]: value })
    }

    const handleSubmit = async (event) => {
        event.preventDefault();

        await fetch(`/srms-api/v1/courses/${course.id ? `${course.id}` : ''}`, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(course)
        });
        setCourse(initialFormState);
        navigate('/courses/');
    }

    const title = <h2>Add Course</h2>;

    return (<div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={handleSubmit}>
                    <FormGroup>
                        <Label for="name">Course name</Label>
                        <Input type="text" name="name" id="name" value={course.name || ''}
                               onChange={handleChange} autoComplete="name"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Submit</Button>{' '}
                    </FormGroup>
                </Form>
            </Container>
        </div>
    )
};

export default CourseEdit;