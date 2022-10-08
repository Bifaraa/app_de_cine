'use strict'
let nombre 
let puntos
document.addEventListener('DOMContentLoaded', async () => {
    sessionStorage.setItem('myCat', 'Tom');
    const btnIniciar = document.querySelector('.btnIniciar')
    let datos = {}
    console.log('antes del fetchData')
    btnIniciar.addEventListener('click', async () => {
        datos.correo = document.querySelector('.usuario').value
        datos.contraseña = document.getElementById('inputcontraseña').value
        //const usuarios = await fetchData('http://localhost:8080/api/user/list')
        //console.log(usuarios)
        try{
        const request = await fetch('https://vast-forest-15070312.herokuapp.com/api/user/recibir',{
            method: 'POST',
            body: JSON.stringify(datos),
            mode: "cors",
            headers: {
                //'Accept':'application/json',
                "Content-Type": "application/json"
            }
            }).then(response =>{
                return response.json()
            }).then(usuario =>{
                localStorage.setItem('cliente', JSON.stringify(usuario))
                const cliente = JSON.parse(localStorage.getItem('cliente'))
                console.log()
                if("cliente" === cliente['tipo_de_usuario']){
                    vista_usuario()
                }else{
                    vista_amd()
                }
            })}catch(SyntaxError){
                alert('Usuario incorrecto')
            }
    })
    
    
})

export function getNombre(){
    return nombre
}

async function fetchData(url) {
    const response = await fetch(url)
    if (!response.ok) {
        throw new Error('Error al hacer la peticion')
    }
    return await response.json()
}

function vista_usuario(){
    window.location.href = "../views/vista_usuario.html"
}

function vista_amd(){
    window.location.href = "../views/vista_adm.html"
}