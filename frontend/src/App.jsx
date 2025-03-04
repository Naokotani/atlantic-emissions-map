import { useState, useEffect } from "react";
import "./styles/App.css";
import Header from "./components/Header";
import Hero from "./components/Hero";
import MapWrapper from "./components/MapWrapper";
import Footer from "./components/Footer";
import background from "./assets/images/background.webp";

function App() {
  return (
    <main>
      <Header />
      <Hero />
      <MapWrapper />
      <Footer year={new Date().getFullYear()} />
    </main>
  );
}

export default App;
