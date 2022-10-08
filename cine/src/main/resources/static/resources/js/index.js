let carrucel = true
document.addEventListener('DOMContentLoaded', async() => {

    //Botones
    const btRegistrar = document.querySelector('.btnRegistrar')
    const btIniciar = document.querySelector('.btnIniciar')
    btRegistrar.addEventListener('click', irRegistro)
    btIniciar.addEventListener('click', irInicioSesion)

    //Cards
    const peliculas = await fetchData('http://localhost:8090/api/peliculas/list')
    const peliculasEstreno = await fetchData('http://localhost:8090/api/peliculas/list')
    const divCards = document.querySelector('.container-cards')
    const divCardsEstrenos = document.querySelector('.container-estrenos')

    
    peliculasEstreno.map( (valor) => {
        if(valor.estado_pelicula === "estreno"){
            let div = document.createElement('div')
            div.className="col-3 shadow card m-4" 
            div.style=""
            div.innerHTML= ` <div class="">
                                <img src="./resources/img/${valor.url_poster}" class="card-img card-img-top" alt="thor cartel">
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

    peliculas.map( (valor) => {
        if(valor.estado_pelicula === "cartelera"){
            console.log('entro')
            let div = document.createElement('div')
            if(carrucel == true){
                div.className = "carousel-item active"
                carrucel = false
                console.log('primer div')
            }else{
                div.className = "carousel-item"
                console.log('segundo div')
            }
        
            div.innerHTML= `<img src="./resources/img/${valor.url_poster}" class="d-block w-100" alt="publicidad">` 
            divCardsEstrenos.appendChild(div)       
        } 
             
    })

})

function irRegistro(){
    window.location.href = "resources/views/registro.html"
}

function irInicioSesion(){
    window.location.href = "resources/views/inicio.html"
}

async function fetchData(url) {
    const response = await fetch(url)
    if (!response.ok) {
        throw new Error(
            `${response.status} - ${response.statusText}, 
             al intentar acceder al recurso '${response.url}'`
        )
    }
    return await response.json()
}

