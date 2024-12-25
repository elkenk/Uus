import React, { useEffect, useRef, useState } from 'react'

function Auto() {
    const [auto, setAuto] = useState([])
    const [vastus, setVastus] = useState()

    const makeRef=useRef()
    const modelRef=useRef()
    const yearRef=useRef()
    const priceRef=useRef()

    useEffect(() => {
        fetch("http://localhost:8080/Auto")
        .then(res => res.json())
        .then(json => setAuto(json))
      }, []);

      function lisaAuto() {
        fetch("http://localhost:8080/lisa-Auto", {method: "POST", headers: {"Content-Type": "application/json"},
            body: JSON.stringify({
                make: makeRef.current.value,
                model: modelRef.current.value,
                year: Number(yearRef.current.value),
                price: Number(priceRef.current.value)
            })
        })
        .then(res => res.json())
        .then(json => setAuto(json))
      }

      function kustutaAuto(index) {
        fetch("http://localhost:8080/kustuta-auto/"+ index, {method: "DELETE"})
        .then(res => res.json())
        .then(json => setAuto(json))
      }

      function keskmineVanus() {
        fetch("http://localhost:8080/keskmine-Auto-Vanus")
        .then(res => res.json())
        .then(json => setVastus(json))
      }
      function vanusKasvavalt() {
        fetch("http://localhost:8080/autod-vanus-kasvavalt")
        .then(res => res.json())
        .then(json => setAuto(json))
      }
      function keskmineHind() {
        fetch("http://localhost:8080/keskmine-hind")
        .then(res => res.json())
        .then(json => setVastus(json))
      }
      function hindKasvavalt() {
        fetch("http://localhost:8080/autod-hind-kasvavalt")
        .then(res => res.json())
        .then(json => setAuto(json))
      }
      function hindAlla40k() {
        fetch("http://localhost:8080/hind-alla-40k")
        .then(res => res.json())
        .then(json => setAuto(json))
      }
      function markAZ() {
        fetch("http://localhost:8080/make-az")
        .then(res => res.json())
        .then(json => setAuto(json))
      }
      function mudelAZ() {
        fetch("http://localhost:8080/model-az")
        .then(res => res.json())
        .then(json => setAuto(json))
      }


  return (
// Teha hind vähem kui nii, et saab sisestada hinda!
    <div>
        <label>Uus auto</label><br/>
        Mark: <input ref={makeRef} type="text"/><br/>
        Mudel: <input ref={modelRef} type="text"/><br/>
        Aasta: <input ref={yearRef} type="number"/><br/>
        Hind: <input ref={priceRef} type="number"/><br/>
        <button onClick={lisaAuto}>Lisa</button><br/><br/>
        <button onClick={keskmineVanus}>Autode keskmine vanus</button>
        <button onClick={vanusKasvavalt}>Vanus kasvavalt</button>
        <button onClick={keskmineHind}>Autode keskmine hind</button>
        <button onClick={hindKasvavalt}>Hind kasvavalt</button>
        <button onClick={hindAlla40k}>Hind vähem kui 40 000€</button>
        
        <button onClick={markAZ}>Margi järgi A-Z</button>
        <button onClick={mudelAZ}>Mudeli järgi A-Z</button>
        <div><b>{vastus}</b></div>
        {auto.map((autod, index) =>
        <div>
            <div><b>{autod.make}</b></div>
            <div>{autod.model}</div>
            <div>Aasta: {autod.year}</div>
            <div>Hind: {autod.price}</div>
            <button onClick={() => kustutaAuto(index)}>x</button><br/><br/>
            </div>
        )}<br/><br/>
       
    </div>
  )
}

export default Auto