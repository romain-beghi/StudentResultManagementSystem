import React, {useEffect, useState} from 'react';
import {Button, ButtonGroup, Container, Table} from 'reactstrap';
import {Link} from "react-router-dom";
import AppNavbar from './AppNavbar';

const StudentList = () => {

    const [students, setStudents] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);

        fetch('/srms-api/v1/students/')
            .then(response => response.json())
            .then(data => {
                setStudents(data);
                setLoading(false);
            })
    }, []);

    const remove = async (id) => {
        await fetch(`/srms-api/v1/students/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedStudents = [...students].filter(i => i.id !== id);
            setStudents(updatedStudents);
        });
    }

    if (loading) {
        return <p>Loading...</p>;
    }

    const studentList = students.map(student => {
        const name = `${student.firstName || ''} ${student.familyName || ''}`;
        return <tr key={student.id}>
            <td style={{whiteSpace: 'nowrap'}}>{name}</td>
            <td>{student.dateOfBirth}</td>
            <td>{student.email}</td>
            <td>
                <ButtonGroup>
                    <Button size="sm" color="danger" onClick={() => remove(student.id)}>Delete</Button>
                </ButtonGroup>
            </td>
        </tr>
    });

    return (
        <div>
            <AppNavbar/>
            <Container fluid>
                <h3>Student List</h3>
                <div className="float-end">
                    <Button color="success" tag={Link} to="/students/new">Add Student</Button>
                </div>
                <Table className="mt-4">
                    <thead>
                    <tr>
                        <th width="20%">Name & Family name</th>
                        <th width="20%">Date of Birth</th>
                        <th>Email</th>
                        <th width="10%">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {studentList}
                    </tbody>
                </Table>
            </Container>
        </div>
    );
};

export default StudentList;