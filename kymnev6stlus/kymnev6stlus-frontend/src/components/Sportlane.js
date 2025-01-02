import React, { useEffect, useRef, useState } from 'react'

function Sportlane() {
    const [sportlased, setSportlased] = useState([])
    const [activePage, setActivePage] = useState(1)
    const [pages, setPages] = useState([])

    const nameRef = useRef()
    const riikRef = useRef()
    const vanusRef = useRef()

    useEffect(() => {
        fetch("http://localhost:8080/Sportlased?size=2&page=" + (activePage - 1))
        .then(res => res.json())
        .then(json => {
            setSportlased(json.content)
        let items = []
        for (let page =1; page <= json.totalPages; page++) {
            items.push(page)
        }
        setPages(items)
    })
    }, [activePage]);

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
        .then(json => setSportlased(json.content))
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
                <div>{Sportlane.id}</div>
                <div>{Sportlane.name}</div>
                <div>{Sportlane.riik}</div>
                <span>{Sportlane.vanus}</span><br/><br/>
                </div>
        )}
        {pages.map(page => <button key={page} onClick={() =>
            setActivePage(page)}>{page}</button>)}
    </div>
  )
}

export default Sportlane