import React, {useEffect, useState} from 'react';
import {Button, Container, Table} from 'reactstrap';
import {Link} from "react-router-dom";
import AppNavbar from './AppNavbar';

const ResultList = () => {

    const [results, setResults] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);

        fetch('/srms-api/v1/results/')
            .then(response => response.json())
            .then(data => {
                setResults(data);
                setLoading(false);
            })
    }, []);

    if (loading) {
        return <p>Loading...</p>;
    }

    const resultList = results.map(result => {
        return <tr key={result.id}>
            <td style={{whiteSpace: 'nowrap'}}>{result.course}</td>
            <td>{result.student}</td>
            <td>{result.grade}</td>
        </tr>
    });

    return (
        <div>
            <AppNavbar/>
            <Container fluid>
                <h3>Result List</h3>
                <div className="float-end">
                    <Button color="success" tag={Link} to="/results/new">Add Result</Button>
                </div>
                <Table className="mt-4">
                    <thead>
                    <tr>
                        <th width="20%">Course</th>
                        <th>Student</th>
                        <th width="10%">Score</th>
                    </tr>
                    </thead>
                    <tbody>
                    {resultList}
                    </tbody>
                </Table>
            </Container>
        </div>
    );
};

export default ResultList;