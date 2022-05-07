import React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { CardActionArea } from "@mui/material";
import logo from "../logo.svg";
import "./Product.css";

function Product() {
  // TODO 商品情報を取得する

  return (
    <Card sx={{ maxWidth: 345 }}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="140"
          image={logo}
          alt="green iguana"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            商品名
          </Typography>
          <Typography variant="body2" color="text.secondary">
            説明です。
          </Typography>
        </CardContent>
      </CardActionArea>
    </Card>
  );
}

export default Product;
