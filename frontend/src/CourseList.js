import React, {useEffect, useState} from 'react';
import {Button, ButtonGroup, Container, Table} from 'reactstrap';
import AppNavbar from './AppNavbar';

const CourseList = () => {

    const [courses, setCourses] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);

        fetch('/srms-api/v1/courses/')
            .then(response => response.json())
            .then(data => {
                setCourses(data);
                setLoading(false);
            })
    }, []);

    const remove = async (id) => {
        await fetch(`/srms-api/v1/courses/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedCourses = [...courses].filter(i => i.id !== id);
            setCourses(updatedCourses);
        });
    }

    if (loading) {
        return <p>Loading...</p>;
    }

    const courseList = courses.map(course => {
        return <tr key={course.id}>
            <td style={{whiteSpace: 'nowrap'}}>{course.name}</td>
            <td>
                <ButtonGroup>
                    <Button size="sm" color="danger" onClick={() => remove(course.id)}>Delete</Button>
                </ButtonGroup>
            </td>
        </tr>
    });

    return (
        <div>
            <AppNavbar/>
            <Container fluid>
                <h3>Course List</h3>
                <Table className="mt-4">
                    <thead>
                    <tr>
                        <th width="20%">Course name</th>
                        <th width="10%">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {courseList}
                    </tbody>
                </Table>
            </Container>
        </div>
    );
};

export default CourseList;