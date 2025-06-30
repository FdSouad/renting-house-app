import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {
  Card, CardContent, Typography, Button, Grid, Container
} from '@mui/material';
import { useNavigate } from 'react-router-dom';

export default function HouseList() {
  const [houses, setHouses] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    axios.get('http://localhost:8080/api/houses')
      .then(res => setHouses(res.data))
      .catch(err => console.error(err));
  }, []);

  const handleDelete = (id) => {
    axios.delete(`http://localhost:8080/api/houses/${id}`)
      .then(() => setHouses(houses.filter(h => h.id !== id)))
      .catch(err => console.error(err));
  };

  return (
    <Container sx={{ marginTop: 4 }}>
      <Button
        variant="contained"
        color="primary"
        onClick={() => navigate("/add")}
        sx={{ marginBottom: 2 }}
      >
        Add House
      </Button>

      <Grid container spacing={2}>
        {houses.map((house) => (
          <Grid item xs={12} md={6} lg={4} key={house.id}>
            <Card>
              <CardContent>
                <Typography variant="h5">{house.title}</Typography>
                <Typography>{house.description}</Typography>
                <Typography variant="subtitle1">Location: {house.location}</Typography>
                <Typography variant="subtitle1">Price: ${house.price}</Typography>
                <Button variant="contained" onClick={() => navigate(`/edit/${house.id}`)} sx={{ mr: 1 }}>
                  Edit
                </Button>
                <Button variant="outlined" color="error" onClick={() => handleDelete(house.id)}>
                  Delete
                </Button>
              </CardContent>
            </Card>
          </Grid>
        ))}
      </Grid>
    </Container>
  );
}
