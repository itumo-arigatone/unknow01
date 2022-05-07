import React from "react";
import Product from "./Product";
import { Grid } from "@mui/material";

function Showcase() {
  // すべての商品を取得する
  const array: number[] = [0, 0, 0, 0];
  return (
    <Grid container spacing={2}>
      {array.map((a, i) => {
        return (
          <Grid item xs={4} key="">
            <Product />
          </Grid>
        );
      })}
    </Grid>
  );
}

export default Showcase;
