import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./index.css";
import reportWebVitals from "./reportWebVitals";
import Showcase from "./shop/Showcase";
import App from "./App";
import Header from "./parts/Header";
import SignIn from "./sign/SignIn";
import SignUp from "./sign/SignUp";

const root = ReactDOM.createRoot(
  document.getElementById("root") as HTMLElement
);
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Header />
      <Routes>
        <Route index element={<Showcase />} />
        <Route path="App" element={<App />} />
        <Route path="login" element={<SignIn />} />
        <Route path="signUp" element={<SignUp />} />
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
