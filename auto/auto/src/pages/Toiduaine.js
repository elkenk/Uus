import React, { useEffect, useState } from 'react'

function Toiduaine() {
    const[toiduaine, setToiduaine] = useState([])
    const[vastus, setVastus] = useState()

    useEffect(() => {
        fetch("http://localhost:8080/toiduained")
        .then(res => res.json())
        .then(json => setToiduaine(json))
      }, []);

  return (
    <div>
        {toiduaine.map(toiduaine =>
            <div>
                <div><b>{toiduaine.nimi}</b></div>
                <div>Valgu sisaldus: {toiduaine.valk}</div>
                <div>Süsivesikute sisaldus: {toiduaine.sysivesik}</div>
                <div>Rasva sisaldus: {toiduaine.rasv}</div><br/>
                </div>
        )}
    </div>
  )
}

export default Toiduaine