import React, { useState, useEffect } from 'react';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';


export default function EditData(props) {

  const { onEditComplete } = props;

  const initialInvoice = {
    slNo: '',
    customerOrderID: '',
    salesOrg: '',
    distributionChannel: '',
    division: '',
    releasedCreditValue: '',
    purchaseOrderType: '',
    companyCode: '',
    orderCreationDate: '',
    orderCreationTime: '',
    creditControlArea: '',
    soldToParty: '',
    orderAmount: '',
    requestedDeliveryDate: '',
    orderCurrency: '',
    creditStatus: '',
    customerNumber: '',
    amountInUsd: '',
    uniqueCustNumber: ''
  };

  const [invoice, setInvoice] = useState(initialInvoice);

  useEffect(() => {
    setInvoice(props);
  }, [props]);

  const handleChange = (e) => {
    setInvoice({
      ...invoice,
      [e.target.name]: e.target.value
    });
  };

  const handleClear = () => {
    setInvoice(initialInvoice);
  };

  const handleSubmit = async () => {

    try {
      const response = await fetch(`http://localhost:8080/Backend/EditData?slNo=${invoice.slNo}&customerOrderID=${invoice.customerOrderID}&salesOrg=${invoice.salesOrg}&distributionChannel=${invoice.distributionChannel}&division=${invoice.division}&releasedCreditValue=${invoice.releasedCreditValue}&purchaseOrderType=${invoice.purchaseOrderType}&companyCode=${invoice.companyCode}&orderCreationDate=${invoice.orderCreationDate}&orderCreationTime=${invoice.orderCreationTime}&creditControlArea=${invoice.creditControlArea}&soldToParty=${invoice.soldToParty}&orderAmount=${invoice.orderAmount}&requestedDeliveryDate=${invoice.requestedDeliveryDate}&orderCurrency=${invoice.orderCurrency}&creditStatus=${invoice.creditStatus}&customerNumber=${invoice.customerNumber}&amountInUsd=${invoice.amountInUsd}&uniqueCustNumber=${invoice.uniqueCustNumber}`, {
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
    onEditComplete();
  }

  const useStyles = makeStyles((theme) => ({
    root: {
      '& .MuiTextField-root': {
        margin: theme.spacing(1),
        width: '25ch',
      },
    },
  }));

  const classes = useStyles();

  return (
    <form className={classes.root} noValidate autoComplete="off">
      <div>
        <style>
          {`
          .Add {
              background-color: #fc7500;
              width: 48%;
          }
          .Clear {
              background-color: #db4437;
              width: 48%;
              margin-left: 35px;
              height: 35px;
          }
          .MuiFilledInput-input {
              border-radius: 5px;
              background-color: white;
          }
          `}
        </style>
        <TextField
          id="filled-required"
          name="slNo"
          label="SI. No"
          variant="filled"
          value={invoice.slNo}
          onChange={handleChange}
          style={{ width: "23%" }}
          InputProps={{
            readOnly: true,
          }}
        />
        <TextField
          id="filled-required"
          name="customerOrderID"
          label="CUSTOMER ORDER ID"
          variant="filled"
          value={invoice.customerOrderID}
          onChange={handleChange}
          style={{ width: "23%" }}
        />
        <TextField
          id="filled-required"
          name="distributionChannel"
          label="DISTRIBUTION CHANNEL"
          variant="filled"
          value={invoice.distributionChannel}
          onChange={handleChange}
          style={{ width: "48%", marginLeft: '25px' }}
        />
        <TextField
          id="filled-required"
          name="salesOrg"
          label="SALES ORG"
          variant="filled"
          value={invoice.salesOrg}
          onChange={handleChange}
          style={{ width: "23%" }}
        />
        <TextField
          id="filled-required"
          name="division"
          label="DIVISION"
          variant="filled"
          value={invoice.division}
          onChange={handleChange}
          style={{ width: "23%" }}
        />
        <TextField
          id="filled-required"
          name="releasedCreditValue"
          label="RELEASED CREDIT VALUE"
          variant="filled"
          value={invoice.releasedCreditValue}
          onChange={handleChange}
          style={{ width: "24%", marginLeft: '25px' }}
        />
        <TextField
          id="filled-required"
          name="purchaseOrderType"
          label="PURCHASE ORDER TYPE"
          variant="filled"
          value={invoice.purchaseOrderType}
          onChange={handleChange}
          style={{ width: "23%" }}
        />
        <TextField
          id="filled-required"
          name="companyCode"
          label="COMPANY CODE"
          variant="filled"
          value={invoice.companyCode}
          onChange={handleChange}
          style={{ width: "23%" }}
        />
        <TextField
          id="filled-required"
          name="orderCreationDate"
          label="ORDER CREATION DATE"
          variant="filled"
          value={invoice.orderCreationDate}
          onChange={handleChange}
          style={{ width: "23%" }}
        />
        <TextField
          id="filled-required"
          name="orderCreationTime"
          label="ORDER CREATION TIME"
          variant="filled"
          value={invoice.orderCreationTime}
          onChange={handleChange}
          style={{ width: "24%", marginLeft: '25px' }}
        />
        <TextField
          id="filled-required"
          name="creditControlArea"
          label="CREDIT CONTROL AREA"
          variant="filled"
          value={invoice.creditControlArea}
          onChange={handleChange}
          style={{ width: "23%" }}
        />
        <TextField
          id="filled-required"
          name="soldToParty"
          label="SOLD TO PARTY"
          variant="filled"
          value={invoice.soldToParty}
          onChange={handleChange}
          style={{ width: "23%" }}
        />
        <TextField
          id="filled-required"
          name="orderAmount"
          label="ORDER AMOUNT"
          variant="filled"
          value={invoice.orderAmount}
          onChange={handleChange}
          style={{ width: "23%" }}
        />
        <TextField
          id="filled-required"
          name="requestedDeliveryDate"
          label="REQUESTED DELIVERY DATE"
          variant="filled"
          value={invoice.requestedDeliveryDate}
          onChange={handleChange}
          style={{ width: "24%", marginLeft: '25px' }}
        />
        <TextField
          id="filled-required"
          name="orderCurrency"
          label="ORDER CURRENCY"
          variant="filled"
          value={invoice.orderCurrency}
          onChange={handleChange}
          style={{ width: "23%" }}
        />
        <TextField
          id="filled-required"
          name="creditStatus"
          label="CREDIT STATUS"
          variant="filled"
          value={invoice.creditStatus}
          onChange={handleChange}
          style={{ width: "23%" }}
        />
        <TextField
          id="filled-required"
          name="customerNumber"
          label="CUSTOMER NUMBER"
          variant="filled"
          value={invoice.customerNumber}
          onChange={handleChange}
          style={{ width: "23%" }}
        />
        <TextField
          id="filled-required"
          name="amountInUsd"
          label="AMOUNT IN USD"
          variant="filled"
          value={invoice.amountInUsd}
          onChange={handleChange}
          style={{ width: "24%", marginLeft: '25px' }}
        />
        <TextField
          id="filled-required"
          name="uniqueCustNumber"
          label="UNIQUE CUSTOMER NUMBER"
          variant="filled"
          value={invoice.uniqueCustNumber}
          onChange={handleChange}
          style={{ width: "23%" }}
        />
        <Button variant="contained" color="primary" className='Add' onClick={handleSubmit}>
          Edit
        </Button>
        <Button variant="contained" color="primary" className='Clear' onClick={handleClear}>
          Clear Data
        </Button>
      </div>
    </form>
  );
}
