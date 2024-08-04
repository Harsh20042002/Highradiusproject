import React, { useEffect, useState } from 'react';
import { DataGrid } from '@material-ui/data-grid';
import CustomFooter from './Pagination';

export default function Datagrid() {
  const [data, setData] = useState([]);
  const [pageSize, setPageSize] = useState(5);
  const [page, setPage] = useState(0);
  const [selectedRows, setSelectedRows] = useState([]);

  useEffect(() => {
    handlefetchData();
  }, []);

  const handlefetchData = async () => {
    try {
      const response = await fetch('http://localhost:8080/Backend/DataLoading');
      const jsonData = await response.json();
      const formattedData = jsonData.map((item, index) => ({
        ...item,
        id: item.slNo || index,
      }));
      setData(formattedData);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  const columns = [
    { field: 'slNo', headerName: 'Sl. No', width: 90 },
    { field: 'customerOrderID', headerName: 'CUSTOMER ORDER ID', width: 185 },
    { field: 'salesOrg', headerName: 'SALES ORG', width: 120 },
    { field: 'distributionChannel', headerName: 'DISTRIBUTION CHANNEL', width: 210 },
    { field: 'division', headerName: 'DIVISION', width: 120 },
    { field: 'releasedCreditValue', headerName: 'RELEASED CREDIT VALUE', width: 210 },
    { field: 'purchaseOrderType', headerName: 'PURCHASE ORDER TYPE', width: 210 },
    { field: 'companyCode', headerName: 'COMPANY CODE', width: 160 },
    { field: 'orderCreationDate', headerName: 'ORDER CREATION DATE', width: 200 },
    { field: 'orderCreationTime', headerName: 'ORDER CREATION TIME', width: 200 },
    { field: 'creditControlArea', headerName: 'CREDIT CONTROL AREA', width: 200 },
    { field: 'soldToParty', headerName: 'SOLD TO PARTY', width: 150 },
    { field: 'orderAmount', headerName: 'ORDER AMOUNT', width: 155 },
    { field: 'requestedDeliveryDate', headerName: 'REQUESTED DELIVERY DATE', width: 235 },
    { field: 'orderCurrency', headerName: 'ORDER CURRENCY', width: 155 },
    { field: 'creditStatus', headerName: 'CREDIT STATUS', width: 150 },
    { field: 'customerNumber', headerName: 'CUSTOMER NUMBER', width: 185 },
    { field: 'amountInUsd', headerName: 'AMOUNT IN USD', width: 155 },
    { field: 'uniqueCustNumber', headerName: 'UNIQUE CUSTOMER NUMBER',width: 240}
  ];

  const handlePageChange = (event, newPage) => {
    setPage(newPage);
  };

  const handlePageSizeChange = (event) => {
    setPageSize(parseInt(event.target.value, 10));
    setPage(0);
  };

  const paginatedData = data.slice(page * pageSize, page * pageSize + pageSize);

  const handleSelectionChange = (newSelection) => {
    setSelectedRows(newSelection);
  };

  return (
    <div style={{ height: 500, width: '100%', alignItems: 'center' }}>
      <style>
        {`
          .MuiDataGrid-root .MuiDataGrid-columnHeaderTitle {
            overflow: visible;
            color: white;
          }
          .MuiDataGrid-root .MuiDataGrid-window {
            color: white;
            align-item: center;
          }
          .MuiTypography-colorInherit {
            color: white;
          }
          .MuiIconButton-colorInherit {
            color: white;
          }
          .MuiCheckbox-root {
            color: white;
            overflow: visible;
          }
        `}
      </style>
      <DataGrid
        rows={paginatedData}
        columns={columns}
        checkboxSelection
        disableSelectionOnClick
        disableColumnSelector
        pageSize={pageSize}
        rowsPerPageOptions={[10,15,25,50,100]}
        onSelectionModelChange={handleSelectionChange}
        components={{
          Footer: (props) => (
            <CustomFooter
              {...props}
              page={page}
              rowCount={data.length}
              pageSize={pageSize}
              onPageChange={handlePageChange}
              onPageSizeChange={handlePageSizeChange}
              fetchdata={handlefetchData}
              selectedRows={selectedRows}
              allRows={data}
            />
          ),
        }}
      />
    </div>
  );
}
