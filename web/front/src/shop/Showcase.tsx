import React, { useEffect, useState } from "react";
import Product from "./Product";
import Grid from "@mui/material/Grid";
import Container from "@mui/material/Container";
import Box from "@mui/material/Box";

function Showcase() {
  // すべての商品を取得する
  const [error, setError] = useState({ message: null });
  const [isLoaded, setIsLoaded] = useState(false);
  const [items, setItems] = useState([
    { id: "", product_name: "", description: "" },
  ]);
  useEffect(() => {
    fetch("https://localhost:8080/products/all", {
      method: "GET",
      headers: {
        "x-xsrf-token": "b4562164-b959-4fcb-82f7-5b8e7e5c8e4e",
      },
    })
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          console.log(result);
          setItems(result);
        },
        // Note: it's important to handle errors here
        // instead of a catch() block so that we don't swallow
        // exceptions from actual bugs in components.
        (error) => {
          setIsLoaded(true);
          console.log(error);
          setError(error);
        }
      );
  }, []);

  if (error.message) {
    return <div>Error: {error.message}</div>;
  } else if (!isLoaded) {
    return <div>Loading...</div>;
  } else {
    return (
      <Container>
        <Box p={3}>
          <Grid container spacing={2}>
            {items.map((item) => {
              return (
                <Grid item xs={12} sm={6} md={4} key={item.id}>
                  <Product data={item} />
                </Grid>
              );
            })}
          </Grid>
        </Box>
      </Container>
    );
  }
}
export default Showcase;
