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
    fetch("http://localhost:8080/products/all", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setItems(result);
          console.log(result);
        },
        (error) => {
          console.log("Error:", error);
          setIsLoaded(true);
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
              console.log(item);
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
