import React, { useState } from 'react';
import { Box, Button, TablePagination } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import EditData from './EditData';

const useStyles = makeStyles((theme) => ({
  customToolbar: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    padding: '0 16px',
    width: '100%',
  },
  buttonGroup: {
    display: 'flex',
    gap: '10px',
  },
}));

export default function CustomFooter({ page, rowCount, pageSize, onPageChange, onPageSizeChange, fetchdata, selectedRows = [], allRows }) {
  const classes = useStyles();
  const [isEditing, setIsEditing] = useState(false);
  const [Row, setRow] = useState(null);

  const isSingleRowSelected = selectedRows.length === 1;


  const handleRefresh = async () => {
    await fetchdata(); // Call the fetchData function passed as a prop
  };


  const handleEdit = () => {
    if (selectedRows.length === 1) {
      const selectedRow = allRows.find(row => row.id === selectedRows[0]);
      if (selectedRow) {
        setRow(selectedRow);
        setIsEditing(true);
      }
    }
  };


  const handleEditComplete = () => {
    setIsEditing(false);
    fetchdata(); // Refresh the data grid
  };


  const handleDelete = async () => {
    if (selectedRows.length === 1) {
      const selectedRow = allRows.find(row => row.id === selectedRows[0]);
      const slNo = selectedRow.slNo;
      try {
        const response = await fetch(`http://localhost:8080/Backend/DeleteData?slNo=${slNo}`, {
          method: 'DELETE',
        });
        if (response.ok) {
          const result = await response.text();
          alert(result);
          await fetchdata(); // Refresh the data after deletion
          selectedRows = [];
        } else {
          const result = await response.text();
          alert(result);
        }
      } catch (error) {
        console.error('Error deleting row:', error);
        alert('Error deleting row: ' + error.message);
      }
    }
  };

  
  const handlePredict = async () => {
    if(selectedRows.length===1)
    {
      const selectedRow = allRows.find(row => row.id===selectedRows[0]);
      
      const data = {
        slNo: selectedRow.slNo,
        customerOrderID: selectedRow.customerOrderID,
        salesOrg: selectedRow.salesOrg,
        distributionChannel: selectedRow.distributionChannel,
        division: selectedRow.division,
        releasedCreditValue: selectedRow.releasedCreditValue,
        purchaseOrderType: selectedRow.purchaseOrderType,
        companyCode: selectedRow.companyCode,
        orderCreationDate: selectedRow.orderCreationDate,
        orderCreationTime: selectedRow.orderCreationTime,
        creditControlArea: selectedRow.creditControlArea,
        soldToParty: selectedRow.soldToParty,
        orderAmount: selectedRow.orderAmount,
        requestedDeliveryDate: selectedRow.requestedDeliveryDate,
        orderCurrency: selectedRow.orderCurrency,
        creditStatus: selectedRow.creditStatus,
        customerNumber: selectedRow.customerNumber,
        amountInUsd: selectedRow.amountInUsd,
        uniqueCustNumber: selectedRow.uniqueCustNumber,
      };
      
      try {
        const response = await fetch(`http://127.0.0.1:5000/predict`, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json', // Adjust this as per your backend requirements
          },
          body:JSON.stringify(data)
        });
        if (response.ok) {
            const result = await response.json(); // Parse JSON response
            console.log(result.results[0]); // Print only the numerical value
            selectedRow.amountInUsd=result.results[0];
            try {
              const response = await fetch(`http://localhost:8080/Backend/EditData?slNo=${selectedRow.slNo}&customerOrderID=${selectedRow.customerOrderID}&salesOrg=${selectedRow.salesOrg}&distributionChannel=${selectedRow.distributionChannel}&division=${selectedRow.division}&releasedCreditValue=${selectedRow.releasedCreditValue}&purchaseOrderType=${selectedRow.purchaseOrderType}&companyCode=${selectedRow.companyCode}&orderCreationDate=${selectedRow.orderCreationDate}&orderCreationTime=${selectedRow.orderCreationTime}&creditControlArea=${selectedRow.creditControlArea}&soldToParty=${selectedRow.soldToParty}&orderAmount=${selectedRow.orderAmount}&requestedDeliveryDate=${selectedRow.requestedDeliveryDate}&orderCurrency=${selectedRow.orderCurrency}&creditStatus=${selectedRow.creditStatus}&customerNumber=${selectedRow.customerNumber}&amountInUsd=${selectedRow.amountInUsd}&uniqueCustNumber=${selectedRow.uniqueCustNumber}`, {
                method: 'PUT',
              });
              if (response.ok) {
                const result = await response.text();
                alert(result);
              } else {
                const result = await response.text();
                alert(result);
              }
            } catch (error) {
              console.error('Error deleting row:', error);
              alert('Error deleting row: ' + error.message);
            }
            

        } else {
            const error = await response.text();
            console.error('Error:', error);
        }
      } 
      catch (error) {
        console.error('Error Predicting row:', error);
        console.log(error.message);
        alert('Error deleting row: ' + error.message);
        
      }
    }
    await fetchdata(); // Call the fetchData function passed as a prop
  };


  return (
    <>
      <Box className={classes.customToolbar}>
        <Box className={classes.buttonGroup}>
          <Button variant="contained" style={{ backgroundColor: '#fc7500', color: 'white' }} onClick={handleRefresh}>Refresh</Button>
          <Button variant="contained" style={{ backgroundColor: '#fc7500', color: 'white', opacity: !isSingleRowSelected ? 0.6 : 1, filter: !isSingleRowSelected ? 'grayscale(10%)' : 'none' }} disabled={!isSingleRowSelected} onClick={handleEdit}>Edit</Button>
          <Button variant="contained" style={{ backgroundColor: '#fc7500', color: 'white', opacity: !isSingleRowSelected ? 0.6 : 1, filter: !isSingleRowSelected ? 'grayscale(10%)' : 'none' }} disabled={!isSingleRowSelected} onClick={handleDelete}>Delete</Button>
          <Button variant="contained" style={{ backgroundColor: '#fc7500', color: 'white', opacity: !isSingleRowSelected ? 0.6 : 1, filter: !isSingleRowSelected ? 'grayscale(10%)' : 'none' }} disabled={!isSingleRowSelected} onClick={handlePredict}>Predict</Button>
        </Box>
        <TablePagination
          component="div"
          count={rowCount}
          page={page}
          onPageChange={onPageChange}
          rowsPerPage={pageSize}
          onRowsPerPageChange={onPageSizeChange}
        />
      </Box>
      {isEditing && <EditData {...Row} onEditComplete={handleEditComplete} />}
    </>
  );
}
