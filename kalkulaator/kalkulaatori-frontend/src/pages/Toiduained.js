import React, { useEffect, useState } from 'react'

function Toiduained() {
    const[toiduained, setToiduained] = useState([])
    const [vastus, setVastus] = useState()

    useEffect(() => {
        fetch("http://localhost:8080/toiduained")
        .then(res => res.json())
        .then(json => setToiduained(json))
      }, []);

      function sorteeriAZ() {
        fetch("http://localhost:8080/toiduained-az")
        .then(res => res.json())
        .then(json => setToiduained(json))
      }

      function valkeKokku() {
        fetch("http://localhost:8080/liida-valgud")
        .then(res => res.json())
        .then(json => setVastus(json))
      }

      function rasvuKokku() {
        fetch("http://localhost:8080/liida-rasvad")
        .then(res => res.json())
        .then(json => setVastus(json))
      }

      function sysivesikuidKokku() {
        fetch("http://localhost:8080/liida-sysivesikud")
        .then(res => res.json())
        .then(json => setVastus(json))
      }

      function RasvKesmiselt() {
        fetch("http://localhost:8080/keskmine-rasv")
        .then(res => res.json())
        .then(json => setVastus(json))
      }

      function lisa() {
        const uusToiduaine= {
            "nimi": "Või", //nimiRef.current.value ja teistel ka
            "rasv": 10,
            "sysivesik": 8,
            "valk": 5
        }
        fetch("http://localhost:8080/lisa-toiduaine", {
            method: "POST", 
            body: JSON.stringify(uusToiduaine),
            headers: {"Content-Type" : "application/json"}
        })
        .then(res => res.json())
        .then(json => setToiduained(json))

      }
        
      

  return (
    <div>
        <button onClick={valkeKokku}>Näita palju on valke</button>
        <button onClick={sysivesikuidKokku}>Näita palju on süsivesikuid</button>
        <button onClick={rasvuKokku}>Näita palju on rasva</button>
        <button onClick={RasvKesmiselt}>Näita palju on rasva keskmiselt</button>
        <div>{vastus}</div>
        <button onClick={sorteeriAZ}>Sorteeri A-Z</button>
        {toiduained.map(toiduaine =>
        <div>
            <div><b>{toiduaine.nimi}</b></div>
            <div>Valk:{toiduaine.valk}</div>
            <div>Süsivesik:{toiduaine.sysivesik}</div>
            <div>Rasv:{toiduaine.rasv}</div>
            </div>
        )}
        <label></label>
        <input type="text"/>
        <button onClick={lisa}>Lisa</button>
    </div>
  )
}

export default Toiduained