document.addEventListener('DOMContentLoaded', () => {
    //Salas JSON
    let datos = {}
    
    let btn_registrar = document.getElementById('btn-registrar')
    btn_registrar.addEventListener('click', ()=>{
        //datos.id_usuario = 2
        let usuario 
        datos.correo = document.getElementById('inputEmail').value
        datos.apellido = " "
        datos.celular = document.getElementById('inputCelular').value
        datos.contraseña = document.getElementById('inputcontraseña').value
        datos.tipo_de_usuario = "cliente"
        if(datos['nombre'] != "" &&  datos['correo'] != ""){
            datos.nombre = document.getElementById('inputNom').value
            if(datos['contraseña'] != "" && document.getElementById('inputcontraseña2').value != ""){
                if(datos['contraseña'] === document.getElementById('inputcontraseña2').value){
                    peticion(datos)
                    alert('registrado')
                    vista_usuario()
                }else{
                    clearPassword()
                    alert('error contraseñas no coinciden')
                }
            }
        }else{
            alert("El campo de nombre y correo son obligatorios")
        }
        
        
        
    })
    })



    async function peticion(datos) {
        const request = await fetch('http://localhost:8080/api/user/create',{
            method: 'POST',
            body: JSON.stringify(datos),
            headers: {
                "Content-Type": "application/json"
            }
            }).then(Response =>{
                return Response.json()
            }).then(usuario =>{
                localStorage.setItem('cliente', JSON.stringify(usuario))
                clear()
                alert('Usuario registrado')
            })
    }

    function clear(){
        document.getElementById('inputEmail').value = ""
        document.getElementById('inputCelular').value = ""
        document.getElementById('inputNom').value = ""
        document.getElementById('inputcontraseña').value = ""
        document.getElementById('inputcontraseña2').value = ""
    }

    
    function clearPassword(){
        document.getElementById('inputcontraseña').value = ""
        document.getElementById('inputcontraseña2').value = ""
    }

    function vista_usuario(){
        window.location.href = "../views/vista_usuario.html"
    }