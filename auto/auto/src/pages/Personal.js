import React, { useEffect, useRef, useState } from 'react'

function Personal() {
    const [personal, setPersonal] = useState([])
    const [vastus, setVastus] =useState()

    const eesnimiRef = useRef()
    const perenimiRef = useRef()
    const vanusRef = useRef()
    const elukohtRef = useRef()

    useEffect(() => {
        fetch("http://localhost:8080/Personal")
        .then(res => res.json())
        .then(json => setPersonal(json))
      }, []);

      function lisaPersonal() {
        fetch("http://localhost:8080/lisa-Personal", {method: "POST", headers: {"Content-Type": "application/json"},
            body: JSON.stringify({
                eesnimi: eesnimiRef.current.value,
                perenimi: perenimiRef.current.value,
                vanus: Number(vanusRef.current.value),
                elukoht: elukohtRef.current.value
            })
        })
        .then(res => res.json())
        .then(json => setPersonal(json))
      }

      function kustutaPersonal(index) {
        fetch("http://localhost:8080/kustuta-Personal/"+ index, {method: "DELETE"})
        .then(res => res.json())
        .then(json => setPersonal(json))
      }

      function keskmineVanus() {
        fetch("http://localhost:8080/keskmine-vanus")
        .then(res => res.json())
        .then(json => setVastus(json))
      }
      function vanusKasvavalt() {
        fetch("http://localhost:8080/vanus-kasvavalt")
        .then(res => res.json())
        .then(json => setPersonal(json))
      }
      function sellestLinnast() {
        fetch("http://localhost:8080/sellest-linnast")
        .then(res => res.json())
        .then(json => setPersonal(json))
      }
      function eesnimiAZ() {
        fetch("http://localhost:8080/eesnimi-az")
        .then(res => res.json())
        .then(json => setPersonal(json))
      }
      function perenimiAZ() {
        fetch("http://localhost:8080/perenimi-az")
        .then(res => res.json())
        .then(json => setPersonal(json))
      }



  return (
    <div>
        <label>Töötaja</label><br/>
        Eesnimi: <input ref={eesnimiRef} type="text"/><br/>
        Perenimi: <input ref={perenimiRef} type="text"/><br/>
        Vanus: <input ref={vanusRef} type="number"/><br/>
        Elukoht: <input ref={elukohtRef} type="text"/><br/>
        <button onClick={lisaPersonal}>Lisa</button><br/><br/>
        <button onClick={keskmineVanus}>Töötajate keskmine vanus</button>
        <button onClick={vanusKasvavalt}>Vanus kasvavalt</button>
        <button onClick={eesnimiAZ}>Eesnime järgi A-Z</button>
        <button onClick={perenimiAZ}>Perekonna nime järgi A-Z</button><br/>
        <button onClick={() => sellestLinnast("Pärnu")}>Pärnu</button>
        <div><b>{vastus}</b></div><br/><br/>
        
          {personal.map((person, index) =>
        <div>
            <div><b>{person.eesnimi}</b></div>
            <div>{person.perenimi}</div>
            <div>Vanus: {person.vanus}</div>
            <div>Elukoht: {person.elukoht}</div>
            <button onClick={() => kustutaPersonal(index)}>x</button><br/><br/>
            </div>
        )}
    </div>
  )
}

export default Personal