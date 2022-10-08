let carrucel = true
document.addEventListener('DOMContentLoaded', async() => {
    //Salas JSON
    const peliculas = await fetchData('http://localhost:8080/api/peliculas/list')
    const peliculasEstreno = await fetchData('http://localhost:8080/api/peliculas/list')
    const divCards = document.querySelector('.container-cards')
    const divCardsEstrenos = document.querySelector('.container-estrenos')

    peliculas.map( (valor) => {
        if(valor.estado_pelicula === "cartelera"){
            let div = document.createElement('div')
            div.className="col-3 shadow card m-4" 
            div.style=""
            div.innerHTML= ` <div class="card-cartelera">
                                <img src="../img/${valor.url_poster}" class="card-img card-img-top" alt="thor cartel">
                                <div class="card-body">
                                    <h5 class="card-title" style="display:none;">${valor.url_poster}</h5>                                
                                    <p class="card-text">2022 ‧ ${valor.genero} ‧ ${valor.duracion}</p>
                                    <p class="card-text duracion">2022 ${valor.duracion}</p>
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

    const listaCards = document.querySelectorAll('.card-cartelera')
    console.log(listaCards)
    listaCards.forEach( card =>{
        card.addEventListener('click', function (evento) {
            //nombre de la pelicula
            //let nombrePelicula = document.querySelector('.card-title').textContent
            let nombrePelicula = this.querySelector('.card-title').textContent
            let posicion = nombrePelicula.indexOf('.')
            let nomP = nombrePelicula.slice(0,posicion)
            //duracion
            let duracion = this.querySelector('.duracion').textContent
            let pelicula = {}
            pelicula.nombre = nomP
            pelicula.duracion = duracion
            localStorage.setItem('pelicula', JSON.stringify(pelicula))
            //console.log(JSON.parse(localStorage.getItem('pelicula')))
            vistaCompraBoleta()
        })
            
    })
})

async function fetchData(url) {
    const response = await fetch(url)
    if (!response.ok) {
        throw new Error('Error')
    }
    return await response.json()
}

function vistaCompraBoleta(){
    window.location.href = "../views/comprar_boleta.html"
}
