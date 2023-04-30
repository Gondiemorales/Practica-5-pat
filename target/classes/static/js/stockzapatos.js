const marcas = {
    nike: {
      logo: 'https://via.placeholder.com/150x150?text=Nike',
      nombre: 'Nike',
      stock: 50,
    },
    adidas: {
      logo: 'https://via.placeholder.com/150x150?text=Adidas',
      nombre: 'Adidas',
      stock: 30,
    },
    'new-balance': {
      logo: 'https://via.placeholder.com/150x150?text=New+Balance',
      nombre: 'New Balance',
      stock: 20,
    },
    pompeii: {
      logo: 'https://via.placeholder.com/150x150?text=Pompeii',
      nombre: 'Pompeii',
      stock: 10,
    },
    vans: {
      logo: 'https://via.placeholder.com/150x150?text=Vans',
      nombre: 'Vans',
      stock: 40,
    },
  };

  function buscarStock(nombre_marca) {
    fetch("/Zapatos/"+ nombre_marca)
      .then(response => response.json())
      .then(data => {
        console.log(data);
        const marca = {
          nombre: data.zapato,
          stock: data.stock
        };
        resultados.innerHTML = `
        <br> </br>
        <br> </br>
        <h2>${marca.nombre}</h2>
        <br> </br>
        <p>Stock: ${marca.stock}</p>
        
      `
        resultados.style.display = 'block';
        console.log(marca);
        return marca;
      })
      .catch(error => {
        console.error(error);
      });
  };
  
  const selectMarcas = document.getElementById('marcas');
  const botonBuscar = document.getElementById('buscar');
  const resultados = document.getElementById('resultados');
  
  botonBuscar.addEventListener('click', () => {
    console.log(selectMarcas.value);
    marca =buscarStock(selectMarcas.value);
    
  });