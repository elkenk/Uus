import React, { useEffect, useRef, useState } from 'react'

function Film() {
    const [film, setFilm] = useState([])
    const [type, setType] = useState([])

    const filmRef = useRef()
    const typeRef = useRef()

    useEffect(() => {
        fetch("http://localhost:8080/films")
        .then(res => res.json())
        .then(json => setFilm(json))
    }, []);

    function add() {
        const addedFilm = {
            "name" : filmRef.current.value,
            "type" : typeRef.current.value
        }
        fetch("http://localhost:8080/films", {
            method: "POST",
            body: JSON.stringify(addedFilm),
            headers: {"Content-Type" : "application/json"}
        })
        .then(res => res.json())
        .then(json => setFilm(json))
    }
    function changeType(filmId, newType) {
        fetch("http://localhost:8080/films" + filmId + "/type", {
            
        })
    }

  return (
    <div>Film</div>
  )
}

export default Film