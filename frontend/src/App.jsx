import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [emitter, setEmitter] = useState([]);
  const apiUrl = import.meta.env.DEV?import.meta.env.VITE_DEV_API_URL:import.meta.env.VITE_PROD_API_URL


  function getData() {
    setCount(count + 1)
    fetch(apiUrl + 'emitter/id?id=' + count)
      .then((res) => {
        return res.json();
      })
      .then((data) => {
        setEmitter(data);
      });

  }
  useEffect(() => {
    getData(1)
  }, []);

  const [count, setCount] = useState(1)

  return (
    <>
      <div>
        <a href="https://vite.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      <h2>Hi Nick and Rose! 👋</h2>
      <div className="card">
        <button onClick={() => getData()}>
          emitter number {count}.
        </button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>
      <p>Version: {import.meta.env.DEV?"Development":"Production"}</p>
    <div className="row">
        {
        (emitter)
          ? <p> {emitter.facilityDescription}: {emitter.totalEmissions} tonnes of co2 equivalent</p>
          : <p> Loading data ... </p> 
        }
    </div>
    </>
  )
}

export default App
