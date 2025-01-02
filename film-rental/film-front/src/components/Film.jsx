import React, { useEffect, useRef, useState } from 'react'

function Film() {
    const [films, setFilms] = useState([])
    const [type, setType] = useState([])
    const [activePage, setActivePage] = useState(1)
    const [pages, setPages] = useState([])

    const filmRef = useRef()
    const typeRef = useRef()

    useEffect(() => {
        fetch("http://localhost:8080/films?page=$(activePage)&size=3")
        .then(res => res.json())
        .then(json => {
            setFilms(json.content)
        let items = []
        for (let page = 1; page <= json.totalPages; page++) {
            items.push(page)
        }
        setPages(items)
    })
    }, [activePage]);

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
        .then(json => 
            setFilms(json.content))
    }

    function changeType(filmId, newType) {
        fetch("http://localhost:8080/films/" + filmId + "/type", {
            method : "PATCH"
        })
        .then(res => res.json())
        .then(json => setFilms(json.content))
    }

    function remove(filmId) {
        fetch("http://localhost:8080/films/" + filmId, {
            method : "DELETE"
        })
        .then(res => res.json())
        .then(json => setFilms(json.content))
    }

  return (
    <div>
        <label>Film</label><br/>
        <input ref={filmRef} type="text"/><br/>
        <label>Type</label><br/>
        <input ref={typeRef} type="text"/><br/>
        <button onClick={add}>Add new</button><br/><br/>

        {films.map(film =>
            <div key={film.id}>
                 <input ref={typeRef} type="text"/>
                 <button onClick={changeType}>New type</button><br/>
                <div>{film.name}</div>
                <div>{film.type}</div>
                <button onClick={() => remove(film.id)}>Delete</button>
                   
                
            </div>
            
        )}
        {pages.map(page => <button onClick={() => setActivePage(page)}>{page}</button>)}
    </div>
  )
}

export default Film