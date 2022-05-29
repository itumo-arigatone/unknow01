import React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { CardActionArea } from "@mui/material";
import logo from "../logo.svg";

type Props = {
  data: {
    id: string;
    product_name: string;
    description: string;
  };
};

function Product(props: Props) {
  return (
    <Card>
      <CardActionArea>
        <CardMedia component="img" height="300" image={logo} alt="商品名" />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {props.data.product_name}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            {props.data.description}
          </Typography>
        </CardContent>
      </CardActionArea>
    </Card>
  );
}

export default Product;
