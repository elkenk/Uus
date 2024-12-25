import React, { useEffect, useRef, useState } from 'react'

function Komakohaga() {
    const[KomaKohaga, setKomaKohaga] = useState([]);
    const [summa, setSumma] = useState([]);
    const [sonum, setSounm] = useState("")

    const numberRef = useRef();

    useEffect(() => {
        fetch("http://localhost:8080/saa-komakohaga")
         .then(res   => res.json())
         .then(json  => setKomaKohaga(json))
        fetch("http://localhost:8080/sonum")
          .then(res   => res.text())
          .then(text  => setSounm(text))
    }, []);

    function kustuta(index) {
        fetch("http://localhost:8080/kustuta-komakohaga/"+ index, {method: "DELETE"})
        .then(res   => res.json())
        .then(json  => setKomaKohaga(json))
        fetch("http://localhost:8080/sonum")
        .then(res   => res.text())
        .then(text  => setSounm(text))
    }

    function lisa() {
        fetch("http://localhost:8080/lisa-komakohaga/" + numberRef.current.value, {method: "POST"} )
        .then(res   => res.json())
        .then(json  => setKomaKohaga(json))
        fetch("http://localhost:8080/sonum")
        .then(res   => res.text())
        .then(text  => setSounm(text))
    }

    function arvutaKOkku() {
        fetch("http://localhost:8080/arvuta-kokku")
        .then(res   => res.json())
        .then(json  => setSumma(json))
    }

    function KoguArv() {
        fetch("http://localhost:8080/kogus")
        .then(res   => res.json())
        .then(json  => setSumma(json))
    }

  return (
    <div>
        <div>{sonum}</div>
        <label>Number</label><br/>
        <input ref={numberRef} type="text" /><br/>
        <button onClick={lisa}>Sisesta</button><br/>
        {KomaKohaga.map((nr, index) =>
             <div>
                {nr}
                <button onClick={() => kustuta(index)}>x</button>
              
            </div>)}
        <button onClick={arvutaKOkku}>Arvuta numbrite summa</button>
        <button onClick={KoguArv}>Arvuta numbrite kogus</button>
        <div>{summa}</div>


    </div>
  )
}

export default Komakohaga