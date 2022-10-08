'use strict'
let carrucel = true
document.addEventListener('DOMContentLoaded', async () => {
    const peliculas = await fetchData('http://localhost:8080/api/peliculas/list')
    const peliculasEstreno = await fetchData('http://localhost:8080/api/peliculas/list')
    const divCards = document.querySelector('.container-cards')
    const divCardsEstrenos = document.querySelector('.container-estrenos')
    const nomUsuario = document.querySelector('.nomUsuario')
    const puntosUsuario = document.querySelector('.puntosUsuario')
    console.log(localStorage.getItem('cliente'))
    const cliente = JSON.parse(localStorage.getItem('cliente'))
    let nombre = cliente['nombre']
    let apellido = cliente['apellido']
    let nombreCompleto = nombre + apellido
    nomUsuario.textContent = nombreCompleto
    puntosUsuario.textContent = cliente['puntos']
    //puntosUsuario.textContent = usuarios[usuario]['puntos']
    
    peliculas.map( (valor) => {
        if(valor.estado_pelicula === "cartelera"){
            let div = document.createElement('div')
            div.className="col-3 shadow card m-4" 
            div.style=""
            div.innerHTML= ` <div class="">
                                <img src="../img/${valor.url_poster}" class="card-img card-img-top" alt="thor cartel">
                                <div class="card-body">
                                    <p class="card-text">2022 ‧ ${valor.genero} ‧ ${valor.duracion}</p>
                                    <p class="card-text">2022 ${valor.duracion}</p>
                                    <hr class="card-text">
                                    <p class="card-text card-descripcion" style="display:none;">${valor.descripcion}</p>
                                </div>
                            </div>
        `
            divCards.appendChild(div)
        }
    })
    
    peliculasEstreno.map( (valor, i) => {
        if(valor.estado_pelicula === "estreno"){
            let div = document.createElement('div')
            if(carrucel == true){
                div.className = "carousel-item active"
                carrucel = false
            }else{
                div.className = "carousel-item"
            }
        
        div.innerHTML= `<img src="../img/${valor.url_poster}" class="d-block w-100" alt="publicidad">` 
        divCardsEstrenos.appendChild(div)       
        }        
    })

  

    let btnGuardarEdit = document.getElementById('btnGuardar')
    let editNom = document.querySelector('.editNom')
    editNom.addEventListener('click', () =>{
        document.querySelector('.edicion').style.display = "block"
        document.getElementById('labelEdit').textContent = "Edite su  nombre"

    })
    let editNum = document.querySelector('.editNum')
    editNum.addEventListener('click', () => {
        document.querySelector('.edicion').style.display = "block"
        document.getElementById('labelEdit').textContent = "Nuevo número"
    })
    btnGuardarEdit.addEventListener('click', () => {
        document.querySelector('.edicion').style.display = "none"
        alert('Edito con exito su información')
    })
    let btneditContraseña = document.getElementById('btnEditContraseña')
    btneditContraseña.addEventListener('click', () =>{
        document.querySelector('.editContraseña').style.display ="block"
    })
    document.getElementById('btnGuardarContraseña').addEventListener('click', () => {
        document.querySelector('.editContraseña').style.display = "none"
        alert('Edito con exito su contraseña')
    })
    document.getElementById('cerrarSesion').addEventListener('click', () =>{
        window.open('../../index.html')
        window.close('./vista_usuario.html')
    })
    
})

async function fetchData(url) {
    const response = await fetch(url)
    if (!response.ok) {
        throw new Error('Error')
    }
    return await response.json()
}