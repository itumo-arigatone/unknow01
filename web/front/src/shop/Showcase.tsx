import React from "react";
import Product from "./Product";

function Showcase() {
  // すべての商品を取得する
  const array: number[] = [0, 0, 0, 0];
  return (
    <>
      {array.map((a, i) => {
        return <Product key="" />;
      })}
    </>
  );
}

export default Showcase;
