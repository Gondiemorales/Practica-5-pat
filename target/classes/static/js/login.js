function crearCuenta() {

  const username = document.getElementById("nombre").value;
    const password = document.getElementById("contraseña").value;

    // Crear un objeto usuario
    const usuario = {
      "username": username,
      "password": password
    };
    
  fetch('/Usuarios', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(usuario)
  })
  .then(response => {
    if (response.ok) {
      // Si la respuesta es exitosa, ocultar el formulario de registro y mostrar el formulario de inicio de sesión
      hideRegistroForm();
    } else {
      throw new Error('Error en la solicitud');
    }
    return response.json();
  })
  .then(data => {
    // El usuario ha sido agregado exitosamente
    console.log(data);
    window.location.href = "./login.html";
  })
  .catch(error => {
    console.error('Ha ocurrido un error:', error);

    if (error.message === "Failed to fetch") {
      const errorMessage2 = document.getElementById("error-message2");
      errorMessage2.textContent = "¡El servidor está caído!";
      errorMessage2.style.color = "red";
    }else {
            const errorMessage2 = document.getElementById("error-message2");
            errorMessage2.textContent = "¡Algo ha ido mal!";
            errorMessage2.style.color = "red";
          }
          
        })

  
      
  };


function getUsuarios(){
        fetch('/Usuarios')
          .then(response => response.json())
          .then(data => {
            console.log(data); // aquí puedes hacer lo que necesites con la respuesta
          })
          .catch(error => console.error(error));
      
}

function showRegistroForm() {
    // Oculta el formulario de inicio de sesión
    document.querySelector('.form-container').style.display = 'none';
  
    // Muestra el formulario de registro
    document.querySelector('.registro-form').style.display = 'block';
  }

  function hideRegistroForm() {
    document.querySelector(".registro-form").style.display = "none";
    document.querySelector(".form-container").style.display = "block";
  }

  function mostrarFormularioBorrarCuenta() {
    // Ocultar el formulario de inicio de sesión
    document.querySelector('.form-container').style.display = 'none';
    // Mostrar el formulario de borrar cuenta
    document.querySelector('.borrar-cuenta-form').style.display = 'block';
  }
  function volver() {
    // Ocultar el formulario de borrar cuenta
    document.querySelector('.borrar-cuenta-form').style.display = 'none';
    // Mostrar el formulario de inicio de sesión
    document.querySelector('.form-container').style.display = 'block';
  }

  

  function login() {

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    fetch("/Usuarios/"+ username)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            let credentialsValid = false;
            if(password==data.password){
              credentialsValid=true;
            }

            if (credentialsValid) {
                // Las credenciales son correctas, hacer algo aquí
                console.log("Credenciales correctas");
                window.location.href = "./stockzapatos.html";
            } else {
              console.error("Credenciales incorrectas");
              const passwordInput = document.getElementById("password");
              passwordInput.classList.add("error");
              const errorMessage = document.getElementById("error-message");
              errorMessage.textContent = "¡Algo ha ido mal!";
              errorMessage.style.color = "red";
            }
        })
        .catch(error => {
          console.error(error);
          if (error.message === "Failed to fetch") {
            const errorMessage = document.getElementById("error-message");
            errorMessage.textContent = "¡El servidor está caído!";
            errorMessage.style.color = "red";
          } else {
            const errorMessage = document.getElementById("error-message");
            errorMessage.textContent = "¡Algo ha ido mal!";
            errorMessage.style.color = "red";
          } 
        });
        
}

function borrarCuenta(){

  const username = document.getElementById("username2").value;
    const password = document.getElementById("password2").value;

    console.log("--------------")

    // Crear un objeto usuario
    const usuario = {
      "username": username,
      "password": password
    };

  fetch('/Usuarios/' + username, {
    method: 'DELETE',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(username)
  })
  .then(response => {
    if (response.ok) {
      // Si la respuesta es exitosa, ocultar el formulario de registro y mostrar el formulario de inicio de sesión
      volver();
    } else {
      throw new Error('Error en la solicitud');
    }
    return response.json();
  })
  .then(data => {
    // El usuario ha sido agregado exitosamente
    console.log(data);
    window.location.href = "./login.html";
  })
  .catch(error => {
    console.error('Ha ocurrido un error:', error);

    if (error.message === "Failed to fetch") {
      const errorMessage2 = document.getElementById("error-message2");
      errorMessage2.textContent = "¡El servidor está caído!";
      errorMessage2.style.color = "red";
    }else {
            const errorMessage2 = document.getElementById("error-message2");
            errorMessage2.textContent = "¡Algo ha ido mal!";
            errorMessage2.style.color = "red";
          }
          
        })

}