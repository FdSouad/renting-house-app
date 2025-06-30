import React, { useEffect, useState } from 'react';
import {
  TextField, Button, Container, Typography
} from '@mui/material';
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';

export default function HouseForm() {
  const [house, setHouse] = useState({
    title: '',
    description: '',
    price: '',
    location: '',
    available: true
  });

  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    if (id) {
      axios.get(`http://localhost:8080/api/houses/${id}`)
        .then(res => setHouse(res.data))
        .catch(err => console.error(err));
    }
  }, [id]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setHouse({ ...house, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const saveFn = id
      ? axios.put(`http://localhost:8080/api/houses/${id}`, house)
      : axios.post('http://localhost:8080/api/houses', house);

    saveFn.then(() => navigate("/"))
      .catch(err => console.error(err));
  };

  return (
    <Container sx={{ mt: 4 }}>
      <Typography variant="h4" gutterBottom>{id ? 'Edit' : 'Add'} House</Typography>
      <form onSubmit={handleSubmit}>
        <TextField
          label="Title"
          name="title"
          fullWidth
          margin="normal"
          value={house.title}
          onChange={handleChange}
          required
        />
        <TextField
          label="Description"
          name="description"
          fullWidth
          margin="normal"
          value={house.description}
          onChange={handleChange}
        />
        <TextField
          label="Location"
          name="location"
          fullWidth
          margin="normal"
          value={house.location}
          onChange={handleChange}
          required
        />
        <TextField
          label="Price"
          name="price"
          type="number"
          fullWidth
          margin="normal"
          value={house.price}
          onChange={handleChange}
          required
        />
        <Button variant="contained" type="submit" sx={{ mt: 2 }}>
          Save
        </Button>
      </form>
    </Container>
  );
}
