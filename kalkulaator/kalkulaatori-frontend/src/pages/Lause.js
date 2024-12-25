import React, { useEffect, useRef, useState } from 'react'

function Lause() {
    const [lause, setLause]     = useState([])
    const [tulemus, setTulemus] = useState([])

    const sonaRef = useRef()

    useEffect(() => {
        fetch("http://localhost:8080/lause")
        .then(res => res.json())
        .then(json => setLause(json))
      }, []);

      function lisaLoppuSona() {
        fetch("http://localhost:8080/lisaLoppuSona/"+ sonaRef.current.value)
        .then(res => res.json())
        .then(json => setLause(json))
      }

      function mituTahte() {
        fetch("http://localhost:8080/mituTahte")
        .then(res   => res.json())
        .then(json  => setTulemus(json))
    }

    function mituSona() {
        fetch("http://localhost:8080/sonadeArv")
        .then(res   => res.json())
        .then(json  => setTulemus(json))
    }

    function mituAtahte() {
        fetch("http://localhost:8080/mituAtahte")
        .then(res   => res.json())
        .then(json  => setTulemus(json))
    }

    function mituKtahte() {
        fetch("http://localhost:8080/mituKtahte")
        .then(res   => res.json())
        .then(json  => setTulemus(json))
    }

    function mituMtahte() {
        fetch("http://localhost:8080/mituMtahte")
        .then(res   => res.json())
        .then(json  => setTulemus(json))
    }

    function mituStahte() {
        fetch("http://localhost:8080/mituStahte")
        .then(res   => res.json())
        .then(json  => setTulemus(json))
    }

  return (
    <div>
        <label>Lisa sõna</label>
        <br/>
        <input ref={sonaRef} type="text"/>
        <br/>
        <button onClick={lisaLoppuSona}>Lisa</button>
        <br/><br/>
        {lause.map(lause =>
    <div>
        {lause}<br/>
    </div>
    )}<br/>
    <button onClick={mituTahte}>Tähtede arv</button>
    <button onClick={mituSona}>Sõnade arv</button>
    <button onClick={mituAtahte}>Mitu A-d</button>
    <button onClick={mituKtahte}>Mitu K-d</button>
    <button onClick={mituMtahte}>Mitu M-i</button>
    <button onClick={mituStahte}>Mitu S-i</button>
    <br/><br/>
    <div>{tulemus}</div>
    </div>
  )
}

export default Lause