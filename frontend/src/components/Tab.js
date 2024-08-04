import React, { useState } from 'react';
import PropTypes from 'prop-types';
import { makeStyles } from '@material-ui/core/styles';
import {AppBar,Tabs,Tab,Button,Box,Typography} from '@material-ui/core';
import Table from './datagrid.jsx';
import AddData from './AddData';
import { rows } from './data.js';


function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box p={3}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

TabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.any.isRequired,
  value: PropTypes.any.isRequired,
};

function a11yProps(index) {
  return {
    id: `simple-tab-${index}`,
    'aria-controls': `simple-tabpanel-${index}`,
  };
}

const useStyles = makeStyles((theme) => ({
    root: {
      flexGrow: 1,
      backgroundColor: '#666666',
    },
    button: {
      height: '75%',
      marginTop: '5px',
      marginBottom: '5px',
      marginRight:'5px'
    },
    searchBoxContainer: {
      display: 'flex',
      alignItems: 'center',
      marginLeft: 'auto',
      marginRight: theme.spacing(2),
    },
    searchTxt: {
      marginRight: theme.spacing(1),
      width: '200%',
      height:'55%'
    },
  }));
  

export default function SimpleTabs() {
  const classes = useStyles();
  const [value, setValue] = React.useState(0);

  const [filteredRows, setFilteredRows] = useState(rows);

  const handleSearch = (value) => {
    const filteredData = rows.filter((row) =>
      row.customerOrderId.toString().toLowerCase().includes(value.toLowerCase())
    );
    setFilteredRows(filteredData);
  };
  

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <div className={classes.root}>
      <style>
        {`
        .MuiTabs-flexContainer {
          background-color: #666666;
        }
        .PrivateTabIndicator-colorSecondary-7 {
          background-color: white;
        }
        .MuiButton-contained {
            background-color: #8fd163;
        }
        `}
      </style>
      <AppBar position="static">
        <Tabs value={value} onChange={handleChange} aria-label="simple tabs example">
          <Tab label="HOME PAGE" {...a11yProps(0)} />
          <Tab label="ADD DATA" {...a11yProps(1)} />
          <Tab label="ANALYTICS VIEW" {...a11yProps(2)} />
          <div className={classes.searchBoxContainer}>
            <input type="text" placeholder="Search by Customer Order ID" onChange={(e) => handleSearch(e.target.value)} />
          </div>
          <Button
            variant="contained"
            backgroundColor="#8fd163"
            className={classes.button}
            borderRadius="15px"
          >
            Advance<br></br>Search
          </Button>
        </Tabs>
      </AppBar>
      <TabPanel value={value} index={0}>
        <Table />
      </TabPanel>
      <TabPanel value={value} index={1}>
       <AddData/>
      </TabPanel>
      <TabPanel value={value} index={2}>
        Item Three
      </TabPanel>
    </div>
  );
  
}
