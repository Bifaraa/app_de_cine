document.addEventListener('DOMContentLoaded', async () => {
    const nom_adm = document.querySelector('.nom_adm')
    const cliente = JSON.parse(localStorage.getItem('cliente'))
    nom_adm.textContent =  cliente['nombre']

    document.getElementById('cerrarSesion').addEventListener('click', () =>{
        window.open('../../index.html')
        window.close('./vista_adm.html')
    })
})