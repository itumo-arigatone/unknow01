import React from "react";
import DetailButton from "../parts/DetailButton";
import logo from "../logo.svg";
import "./Product.css";

function Product() {
  // TODO 商品情報を取得する

  return (
    <div className="product">
      <img src={logo} className="product_img" alt="product_img" />
      <DetailButton value={"詳細を見る"} />
    </div>
  );
}

export default Product;
