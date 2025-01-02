import React, { useEffect, useRef, useState } from 'react'

function Tulemus() {
    const [tulemused, setTulemused] = useState([])
    const [sportlased, setSportlased] = useState([])
    const [punktidKokku, setPunktidKokku] = useState()
    const [activePage, setActivePage] = useState(1)
    const [pages, setPages] = useState([])

    const nameRef = useRef()
    const sooritusRef = useRef()
    // const punktidRef = useRef()
    const sportlaseIdRef = useRef()
     
    useEffect(() => {
        fetch("http://localhost:8080/Tulemused?size=2&page=" + (activePage - 1))
        .then(res => res.json())
        .then(json => {
            setTulemused(json.content)
        let items = []
        for (let page = 1; page <= json.totalPages; page++) {
            items.push(page)
        }
        setPages(items)
        })
    }, [activePage]);

    useEffect(() => {
        fetch("http://localhost:8080/Sportlased")
        .then(res => res.json())
        .then(json => setSportlased(json.content))
    }, []);

    function lisa() {
        const lisatavTulemus = {
            "name" : nameRef.current.value,
            "sooritus" : Number(sooritusRef.current.value),
            // "punktid" : punktidRef.current.value,
            "sportlane" : {"id" : Number(sportlaseIdRef.current.value)}
        }
        fetch("http://localhost:8080/Tulemused", {
            method: "POST",
            body: JSON.stringify(lisatavTulemus),
            headers: {"Content-Type" : "application/json"}
        })
        .then(res => res.json())
        .then(json => setTulemused(json.content))
    }

    function kustuta(tulemusId) {
        console.log(tulemusId)
        fetch("http://localhost:8080/Tulemused/" + tulemusId, {
            method : "DELETE"
        })
        .then(res => res.json())
        .then(json => setTulemused(json.content))
    }

    function punktideKogusumma(sportlaneId){
        fetch("http://localhost:8080/LiidaPunktid?id=" + sportlaneId)
        .then(res => res.json())
        .then(json => setPunktidKokku(json))
    }
  return (

    <div>
        <label>Nimi</label><br/>
        <input ref={nameRef} type="text"/><br/>
        <label>Sooritus</label><br/>
        <input ref={sooritusRef} type="number"/><br/>
        {/* <label>Punktid</label><br/>
        <input ref={punktidRef} type="number"/><br/> */}
        <label>Sportlane</label><br/>
        <input ref={sportlaseIdRef} type="number"/><br/>
        <button onClick={lisa}>Lisa</button><br/><br/>
        <div>{punktidKokku}</div>
        {sportlased.map(sportlane =>
            <div key= {sportlane.id}>
                <div>{sportlane.name}</div>
                <button onClick={() => punktideKogusumma(sportlane?.id)}>Punktid kokku</button><br/>
            </div>
        )}

        {tulemused.map(tulemus =>
            <div key = {tulemus.id}>
                <div>{tulemus.id}</div>
                <div>{tulemus.name}</div>
                <div>{tulemus.sooritus}</div>
                <div>{tulemus.punktid}</div>
                <div>Sportlane: {tulemus.sportlane?.name}<br/>
                <button onClick={() =>kustuta(tulemus.id)}>Kustuta</button></div><br/>
                </div>
        )}
        {pages.map(page => <button key={page} onClick={() => 
            setActivePage(page)}>{page}</button>)}
    </div>
  )
}

export default Tulemus