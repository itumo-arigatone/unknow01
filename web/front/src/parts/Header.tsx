import React from "react";
import { Link } from "react-router-dom";
import { AppBar, Toolbar, Typography } from "@mui/material";

function Header() {
  return (
    <AppBar position="static">
      <Toolbar>
        <nav>
          <Link to="/">
            <Typography className="">unknow01</Typography>
          </Link>
        </nav>
        <nav>
          <Link to="blog">Blog</Link>
        </nav>
        <nav>
          <Link to="login">Login</Link>
        </nav>
      </Toolbar>
    </AppBar>
  );
}

export default Header;
