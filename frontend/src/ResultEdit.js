import React, {useEffect, useState} from 'react';
import {Button, Container, Form, FormGroup, Input, Label} from 'reactstrap';
import {useNavigate, useParams} from 'react-router-dom';
import AppNavbar from './AppNavbar';
import {Select} from "./components/Select";

const ResultEdit = () => {
    const initialFormState = {
        course: '',
        student: '',
        grade: ''
    };
    const [result, setResult] = useState(initialFormState);
    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
    }, [id, setResult]);

    const handleChange = (event) => {
        const { name, value } = event.target

        setResult({ ...result, [name]: value })
    }

    const handleSubmit = async (event) => {
        event.preventDefault();

        await fetch(`/srms-api/v1/results/`, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(result)
        });
        setResult(initialFormState);
        navigate('/results/new');
    }

    const title = <h2>Add Result</h2>;

    return (<div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={handleSubmit}>
                    <FormGroup>
                        <Label for="course">Course</Label>
                        <br/>
                        <Select
                            name="course"
                            options={[
                                { label: 'Database Management', value: '39c59b8c-439e-4d90-8f5a-ddc65b61a7cf' },
                                { label: 'Web Application Scripting', value: '964b48c9-e33b-4529-95e5-0aa95b00e20a' }
                            ]}
                            onChange={handleChange}
                        />
                    </FormGroup>
                    <FormGroup>
                        <Label for="student">Student</Label>
                        <br/>
                        <Select
                            name="student"
                            options={[
                                { label: 'John Doe', value: '3d321c52-300b-4b51-90ec-2456f077a672' },
                                { label: 'Isabella Reinger', value: '3cc043a3-ea54-466d-b937-15d779274606' }
                            ]}
                            onChange={handleChange}
                        />
                    </FormGroup>
                    <FormGroup>
                        <Label for="grade">Grade</Label>
                        <br/>
                        <Select
                            name="grade"
                            options={[
                                { label: 'A', value: 'A' },
                                { label: 'B', value: 'B' },
                                { label: 'C', value: 'C' },
                                { label: 'D', value: 'D' },
                                { label: 'E', value: 'E' },
                                { label: 'F', value: 'F' }
                            ]}
                            onChange={handleChange}
                        />
                    </FormGroup>
                    <FormGroup>
                        <Label for="grade">Grade</Label>
                        <Input type="text" name="grade" id="grade" value={result.grade || ''}
                               onChange={handleChange} autoComplete="grade"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Submit</Button>{' '}
                    </FormGroup>
                </Form>
            </Container>
        </div>
    )
};

export default ResultEdit;