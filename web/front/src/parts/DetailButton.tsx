import React from "react";

type Props = {
  value: string;
};

function DetailButton(props: Props) {
  return <input type="button" value={props.value} />;
}

export default DetailButton;
