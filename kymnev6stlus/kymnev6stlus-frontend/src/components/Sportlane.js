import React, { useEffect, useRef, useState } from 'react'

function Sportlane() {
    const [sportlased, setSportlased] = useState([])

    const nameRef = useRef()
    const riikRef = useRef()
    const vanusRef = useRef()

    useEffect(() => {
        fetch("http://localhost:8080/Sportlased")
        .then(res => res.json())
        .then(json => setSportlased(json))
    }, []);

    function lisa() {
        const lisatavSportlane = {
            "name" : nameRef.current.value,
            "riik" : riikRef.current.value,
            "vanus" : vanusRef.current.value,
        }
        fetch("http://localhost:8080/Sportlased", {
            method: "POST",
            body: JSON.stringify(lisatavSportlane),
            headers: {"Content-Type" : "application/json"}
        })
        .then(res => res.json())
        .then(json => setSportlased(json))
    }

  return (
    <div>
        <label>Nimi</label><br/>
        <input ref={nameRef} type="text"/><br/>
        <label>Riik</label><br/>
        <input ref={riikRef} type="text"/><br/>
        <label>Vanus</label><br/>
        <input ref={vanusRef} type="number"/><br/>
        <button onClick={lisa}>Lisa</button><br/><br/>
        
        {sportlased.map(Sportlane =>
            <div key={Sportlane.id}>
                {/* <div>{Sportlane.id}</div> */}
                <div>{Sportlane.name}</div>
                <div>{Sportlane.riik}</div>
                <span>{Sportlane.vanus}</span><br/><br/>
                </div>
        )}<br/>
    </div>
  )
}

export default Sportlane