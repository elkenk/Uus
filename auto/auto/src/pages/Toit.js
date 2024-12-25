import React, { useEffect, useState } from 'react'

function Toit() {
    const[toit, setToit] = useState([])
    const[vastus, setVastus] = useState()
    
    useEffect(() => {
        fetch("http://localhost:8080/Toit")
        .then(res => res.json())
        .then(json => setToit(json))
      }, []);


  return (
    <div>
        {toit.map(toidud =>
            <div>
                <div><b>{toidud.nimi}</b></div>
                <div>{toidud.kogus}</div><br/>
            </div>
        )}
    </div>
  )
}

export default Toit