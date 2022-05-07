import React from "react";
import Product from "./Product";
import Grid from "@mui/material/Grid";
import Container from "@mui/material/Container";
import Box from "@mui/material/Box";

function Showcase() {
  // すべての商品を取得する
  const array: number[] = [0, 0, 0, 0, 0];
  return (
    <Container>
      <Box p={3}>
        <Grid container spacing={2}>
          {array.map((a, i) => {
            return (
              <Grid item xs={12} sm={6} md={4} key={i}>
                <Product />
              </Grid>
            );
          })}
        </Grid>
      </Box>
    </Container>
  );
}

export default Showcase;
