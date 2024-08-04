import React,{ useState } from 'react';
import { DataGrid } from '@mui/x-data-grid';
import './table.css';
import DeleteButton from '../updated';


function Table()
{
  const columns = [
    { field: 'id', headerName: 'Sl. No', width: 90 },
    { field: 'customerOrderId', headerName: 'CUSTOMER ORDER ID', width: 150 },
    { field: 'salesOrg', headerName: 'SALES ORG', width: 150 },
    { field: 'distributionChannel', headerName: 'DISTRIBUTION CHANNEL', width: 180 },
    { field: 'companyCode', headerName: 'COMPANY CODE', width: 150 },
    { field: 'orderCreationDate', headerName: 'ORDER CREATION DATE', width: 180 },
    { field: 'orderAmount', headerName: 'ORDER AMOUNT', width: 150 },
    { field: 'orderCurrency', headerName: 'ORDER CURRENCY', width: 150 },
    { field: 'customerNumber', headerName: 'CUSTOMER NUMBER', width: 150 },
  ];
  
  const [rows, setRows] = useState([
    {
      id: 1,
      slNo: '1',
      customerOrderId: '754349803',
      salesOrg: '3911',
      distributionChannel: 'United Arab Emirates',
      companyCode: '3290',
      orderCreationDate: '01-01-2022',
      orderAmount: '1405.54',
      orderCurrency: 'EUR',
      customerNumber: '1210499770'
    },
    {
      id: 2,
      slNo: '2',
      customerOrderId: '930253442',
      salesOrg: '2381',
      distributionChannel: 'Greece',
      companyCode: '3290',
      orderCreationDate: '01-01-2022',
      orderAmount: '1441.4835',
      orderCurrency: 'EUR',
      customerNumber: '1210351400'
    },
    {
      id: 3,
      slNo: '3',
      customerOrderId: '819741436',
      salesOrg: '3605',
      distributionChannel: 'Argentina',
      companyCode: '3290',
      orderCreationDate: '01-01-2022',
      orderAmount: '1065.33',
      orderCurrency: 'EUR',
      customerNumber: '1210124309'
    },
    {
      id: 4,
      slNo: '4',
      customerOrderId: '881355361',
      salesOrg: '3645',
      distributionChannel: 'Armenia',
      companyCode: '3470',
      orderCreationDate: '02-01-2022',
      orderAmount: '302.85',
      orderCurrency: 'EUR',
      customerNumber: '12311152'
    },
    {
      id: 5,
      slNo: '5',
      customerOrderId: '821659852',
      salesOrg: '2470',
      distributionChannel: 'United States of America',
      companyCode: '3220',
      orderCreationDate: '02-01-2022',
      orderAmount: '8380.69',
      orderCurrency: 'EUR',
      customerNumber: '1230021722'
    },
    {
      id: 6,
      slNo: '6',
      customerOrderId: '957194828',
      salesOrg: '3150',
      distributionChannel: 'United States Minor Outlying Island',
      companyCode: '3290',
      orderCreationDate: '02-01-2022',
      orderAmount: '545.85',
      orderCurrency: 'EUR',
      customerNumber: '1210183107'
    },
    {
      id: 7,
      slNo: '7',
      customerOrderId: '806322513',
      salesOrg: '3396',
      distributionChannel: 'Serbia',
      companyCode: '3290',
      orderCreationDate: '02-01-2022',
      orderAmount: '545.85',
      orderCurrency: 'EUR',
      customerNumber: '1210499770'
    },
    {
      id: 8,
      slNo: '8',
      customerOrderId: '922237131',
      salesOrg: '2353',
      distributionChannel: 'Turks and Caicos Island',
      companyCode: '3290',
      orderCreationDate: '02-01-2022',
      orderAmount: '562.73',
      orderCurrency: 'EUR',
      customerNumber: '1210111951'
    }
  ]);
  
  const handleDelete = (id) => {
    const updatedRows = rows.filter((row) => row.id !== id);
    setRows(updatedRows);
  };

  return (
    <div className = "table">
      <DeleteButton
        rows={rows}
        columns={columns}
        onDelete={handleDelete}
        checkboxSelection
        disableSelectionOnClick
        pageSize={5}
        disableColumnSelector
      />
    </div>
  );
}

export default Table;