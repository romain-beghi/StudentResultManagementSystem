import React, {useEffect, useState} from 'react';
import {Button, Container, Form, FormGroup, Input, Label} from 'reactstrap';
import {useNavigate, useParams} from 'react-router-dom';
import AppNavbar from './AppNavbar';
import {Select, SelectCourse, SelectStudent} from "./components/Select";

const ResultEdit = () => {
    const initialFormState = {
        course: '',
        student: '',
        grade: ''
    };

    const [courses, setCourses] = useState([]);
    const [students, setStudents] = useState([]);
    const [loadingCourse, setLoadingCourse] = useState(false);
    const [loadingStudent, setLoadingStudent] = useState(false);

    const [result, setResult] = useState(initialFormState);
    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
        setLoadingCourse(true);
        setLoadingStudent(true);

        fetch('/srms-api/v1/courses/')
            .then(response => response.json())
            .then(data => {
                setCourses(data);
                setLoadingCourse(false);
            })

        fetch('/srms-api/v1/students/')
            .then(response => response.json())
            .then(data => {
                setStudents(data);
                setLoadingStudent(false);
            })
    }, [id, setResult]);

    if (loadingCourse || loadingStudent) {
        return <p>Loading...</p>;
    }

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
                        <SelectCourse
                            name="course"
                            options={courses}
                            onChange={handleChange}
                        />
                    </FormGroup>
                    <FormGroup>
                        <Label for="student">Student</Label>
                        <br/>
                        <SelectStudent
                            name="student"
                            options={students}
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