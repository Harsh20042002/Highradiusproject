import React, { useEffect, useState } from 'react';
import { DataGrid } from '@mui/x-data-grid';
import axios from 'axios';
import { DataGrid } from '@mui/x-data-grid';


function Table1()
{
    const [data, setData] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/data')
        .then(response => {
        setData(response.data);
        })
        .catch(error => {
            console.error(error);
        });
    }, []);
    <DataGrid rows={data} columns={columns} />


}

export default Table1;