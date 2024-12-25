import React, { useEffect, useRef, useState } from 'react'

function Sonad() {
    const [sonad, setSonad] = useState([])
    const [tulemus, setTulemus] = useState([])
    const sonaRef = useRef()

    useEffect(() => {
        fetch("http://localhost:8080/sonad")
        .then(res => res.json())
        .then(json => setSonad(json))
      }, []);

      function lisaSona() {
        fetch("http://localhost:8080/lisaSona/"+ sonaRef.current.value)
        .then(res => res.json())
        .then(json => setSonad(json))
      }

      function kustutaSona(index) {
        fetch("http://localhost:8080/kustutaSona/"+ index)
        .then(res => res.json())
        .then(json => setSonad(json))
      }

      function tahed() {
        fetch("http://localhost:8080/tahed")
        .then(res => res.json())
        .then(json => setTulemus(json))
      }

      function tahedKeskmine() {
        fetch("http://localhost:8080/tahedKeskmine")
        .then(res => res.json())
        .then(json => setTulemus(json))
      }

      function tahti(index) {
        fetch("http://localhost:8080/arvuta-tahed/"+ index)
        .then(res   => res.json())
        .then(json  => setTulemus(json))
    }

    function esimene(index) {
        fetch("http://localhost:8080/esimene-taht/"+ index)
        .then(res   => res.text())
        .then(text  => setTulemus(text))
    }

    function viimane(index) {
      fetch("http://localhost:8080/viimane-taht/"+ index)
      .then(res   => res.text())
      .then(text  => setTulemus(text))
  }

  return (
    <div>
        <label>Uus sõna</label><br/>
      <input ref={sonaRef} type="text" /><br/>
      <button onClick={lisaSona}>Lisa</button><br/><br/> 
      {sonad.map((sona, index) =>
       <div>
        {sona}
        <button onClick={() => kustutaSona(index)}>x</button>
        <button onClick={() => tahti(index)}>Mitu tähte on sõnas</button>
        <button onClick={() => esimene(index)}>Näita esimest tähte</button>
        <button onClick={() => viimane(index)}>Näita viimast tähte</button>
        </div>)}<br/><br/>
        <button onClick={tahed}>Tähtede arv</button>
        <button onClick={tahedKeskmine}>Keskmine tähtede arv</button>
        <div>{tulemus}</div>
    </div>
  )
}

export default Sonad