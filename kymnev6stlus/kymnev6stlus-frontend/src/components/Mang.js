import React, { useEffect, useState } from 'react'

function Mang() {
    const [kaardid, setKaardid] = useState({})
    const [sonum, setSonum] = useState("")
    const [skoorElud, setSkoorElud] = useState({})

    useEffect(() => {
        alusta()
    }, []);

    const votaSkoorJaElud = () => {
        fetch("http://localhost:8080/skoor-ja-elud")
        .then(res => res.json())
        .then(json => setSkoorElud(json))
    }
    const vordleKaarte = (guess) => {
        fetch("http://localhost:8080/vordle-kaarte/" + guess)
        .then(res => res.text())
        .then(json => setSonum(json))
    }
    const mangiUuesti = () => {
        fetch("http://localhost:8080/mangi-uuesti")
        .then(res => res.json())
        .then(json => setKaardid(json))
        setSonum("")
        votaSkoorJaElud()
    }
    const alusta = () => {
        fetch("http://localhost:8080/alusta")
            .then(res => res.json())
            .then(json => {
            setKaardid(json)
            votaSkoorJaElud()
        })
    }


  return (

    <div>
        <div>Skoor: {skoorElud.skoor}</div>
        <div>Elud: {skoorElud.elud}</div>
        <div>{kaardid.mast} {kaardid.nimi}</div>
        {sonum === "" ?
        <>
        <div>Arva järgmine kaart</div>
        <button onClick={() => vordleKaarte("less")}>Väiksem</button>
        <button onClick={() => vordleKaarte("same")}>Sama</button>
        <button onClick={() => vordleKaarte("more")}>Suurem</button>
        </>:
        <button onClick={mangiUuesti}>Mängi veel</button>
        }
        <div>{sonum}</div>
        {skoorElud.elud === 0 && <button onClick={alusta}>Uus mäng</button>}
    </div>
  )
}

export default Mang