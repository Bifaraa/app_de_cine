'use strict'
const valorSilla = 10000
let combo
let total
let comboId
let id_combo
let cantSillas
document.addEventListener('DOMContentLoaded', async() => {
    //Salas JSON
    /* const salasDeCine = await fetchData('../data/sillas.json')
    document.querySelector('#inputSillasDisponibles').value = salasDeCine['sala_1']['sillas']
    document.querySelector('#') */
    let pedido = {}
    const combos = await fetchData('https://vast-forest-15070312.herokuapp.com/api/comida/list')
    let divCombos = document.querySelector('.combos')
            combos.map( (valor) => {
                let div = document.createElement('div')
                div.className="card mb-5" 
                div.style="width: 15rem; height: 15rem;"
                div.innerHTML= ` </div class="">
                                    <img src="../img/${valor.url_img}" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title">${valor.precio}</h5>
                                        <p class="card-text">${valor.descripcion}</p>
                                    </div>
                `
                divCombos.appendChild(div)
            })
    const pelicula = JSON.parse(localStorage.getItem('pelicula'))
    if(pelicula != null){
        let nombrePelicula = pelicula['nombre']
        let salaDeCine
        let id_peli
        try{
            const request = await fetch('https://vast-forest-15070312.herokuapp.com/api/peliculas/sala',{
                method: 'POST',
                body: JSON.stringify(nombrePelicula),
                mode: "cors",
                headers: {
                    //'Accept':'application/json',
                    "Content-Type": "application/json"
                }
                }).then(response =>{
                    return response.json()
                }).then(sala =>{
                    console.log(sala)
                    salaDeCine = sala
                })}catch(SyntaxError){
                    alert('Sala no encontrada')
                }
        try{
            const request = await fetch('https://vast-forest-15070312.herokuapp.com/api/peliculas/id_pelicula',{
            method: 'POST',
            body: JSON.stringify(nombrePelicula),
            mode: "cors",
            headers: {
                //'Accept':'application/json',
                "Content-Type": "application/json"
                }
                }).then(response =>{
                    return response.json()
                }).then(id =>{
                    console.log(id)
                    id_peli = id
        })}catch(SyntaxError){
            alert('id_pelicula no encontrado')
        }
        let infoPelicula = pelicula['duracion']
        let duracion = infoPelicula.slice(0,infoPelicula.indexOf(" "))
    
        document.querySelector('.nombre_pelicula').textContent = nombrePelicula
        document.querySelector('.fecha').textContent = duracion
        document.querySelector('.sillas-disponibles').value = salaDeCine['numero_sillas']
        localStorage.removeItem('pelicula')
    
        document.querySelector('.area-total').addEventListener('click', () =>{
            let valorDelCombo = parseInt(valorSelecionado())
            cantSillas = cantSilla()
            total = calTotal(valorDelCombo, cantSillas)
            let idcombo = '.'+comboId
            let nombreCombo = document.querySelector(idcombo).textContent
            id_combo = cargarIdCombo(nombreCombo)
            document.querySelector('.label-total').textContent = total
        })
        document.querySelector('.comprar').addEventListener('click', () =>{
            let id_usuario = 0
            let id_pelicula = id_peli
            pedido.id_usuario = id_usuario
            pedido.id_pelicula = parseInt(id_pelicula)
            //pedido.id_combo = parseInt(id_combos)
            pedido.id_combo= 2
            pedido.numero_de_sillas = parseInt(cantSillas)
            console.log(pedido)
            postPedido(pedido)
                   
            //alert('Su pedido fue registrado')
        })
    }else{
        document.querySelector('.comprar').addEventListener('click', () =>{
            
            alert('Selecione una pelicula del catalogo')
        })

    }
    
   
    
})

async function fetchData(url) {
    const response = await fetch(url)
    if (!response.ok) {
        throw new Error('Error')
    }
    return await response.json()
}

function cantSilla(){
    const cantidadSillas = document.querySelector('.cantidadTxt').value
    if(cantidadSillas.length === 0 || cantidadSillas <= 0 ){
        alert('Cantidad de boletos sin llenar')
    }else if(cantidadSillas < document.querySelector('.sillas-disponibles').value){
        return cantidadSillas
    }else{
        alert('Cantidad de boletos a llevar debe de ser menor a la cantidad disponible')
    }
}

function calTotal(valorCombo, cantidadSillas){
    return (valorSilla*cantidadSillas)+valorCombo
}

function valorSelecionado(){
    const radioBtn = document.querySelectorAll('.select-combo')
    //console.log(radioBtn)
    let valor = 0
    radioBtn.forEach(radio => {
        if(radio.checked){
            valor = radio.value
            comboId = radio.id
        }
    })
    return valor
}

async function cargarIdCombo(nombreCombo){
    let id_combos
    try{
        const request =  fetch('https://vast-forest-15070312.herokuapp.com/api/comida/id',{
            method: 'POST',
            body: JSON.stringify(nombreCombo),
            mode: "cors",
            headers: {
                //'Accept':'application/json',
                "Content-Type": "application/json"
            }
            }).then(response =>{
                return response.json()
            }).then(id_combo =>{
                console.log('devolvio el id '+id_combo)
                id_combos = id_combo
            })}catch(SyntaxError){
                alert('nombre de combo incorrecto')
            }
    return id_combos
}

async function postPedido(pedido){
    let pedidos
    try{
        const request =  fetch('https://vast-forest-15070312.herokuapp.com/api/compra/create',{
            method: 'POST',
            body: JSON.stringify(pedido),
            mode: "cors",
            headers: {
                //'Accept':'application/json',
                "Content-Type": "application/json"
            }
            }).then(response =>{
                return response.json()
            }).then(pedido =>{
                pedidos = pedido
                clear()
                alert('Su pedido fue tomado')
            })}catch(SyntaxError){
                alert('error en el pedido')
            }
    return pedidos
} 

function clear (){
    document.querySelector('.sillas-disponibles').value = ""
    document.querySelector('.label-total').textContent = "$ 0.000.000"
}
