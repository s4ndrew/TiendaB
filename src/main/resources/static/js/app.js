/*
function fetchData1(){
    fetch("http://localhost:8089/tiendaMia/ventas")
    .then((response) => {
        if(!response.ok) throw new Error("Error en el servidor");
        return response.json();
    })
    .then((data) => console.log(data))
    .catch((error) => console.log("Erro capturado: ", error));
}
fetchData1();
*/

async function dataCategorias() {
  try {
    let response = await fetch("http://localhost:8089/tiendaMia/categorias");
    let data = await response.json();
    //console.log(data);
    const container = document.getElementById("list");

    container.innerHTML = "";

    data.forEach((categoria) => {
      const li = document.createElement("li");

      li.textContent = `${categoria.idCategoria} ${categoria.nombre}`;
      container.appendChild(li);
    });
  } catch (error) {
    console.log(error);
  }
}
//dataCategorias()

async function dataClientes() {
  try {
    let response = await fetch("http://localhost:8089/tiendaMia/clientes");
    let data = await response.json();

    let cl = document.getElementById("clientes");
    cl.innerHTML = "";
    data.forEach((clientes) => {
      let li = document.createElement("li");
      li.textContent = clientes.nombre;
      cl.appendChild(li);
    });
  } catch (error) {
    console.log("error" + error);
  }
}
//dataClientes()
//Bucle con varias peticiones
/*
const urls = [
    "http://localhost:8089/tiendaMia/categorias",
    "http://localhost:8089/tiendaMia/ventas",
    "http://localhost:8089/tiendaMia/clientes"
]


async function fecthName() {
    try {
        for await (const url of urls) {
            let response = await fetch(url)
            let data = await response.json
            ();
            console.log(data);
        }
    } catch (error) {
        console.log(error);
    }
}
fecthName() */

function sendHTTPRequest(method, url, data) {
  return fetch(url, {
    method: method,
    body: JSON.stringify(data),
    headers: {
      "Content-type": "applicaction/json",
    },
  }).then((response) => {
    return response.json();
  });
}

//CATEGORIAS
const form = document.getElementById("form");
//const selectCategoria = document.createElement("select");
const contenedorCategoria = document.getElementById("opcionesCategorias")
const contenerdorProductos = document.getElementById("opcionesProductos")
const cuadroDePrecio = document.getElementById("precioProducto")

async function fecthCategorias() {
  const responseData = await sendHTTPRequest(
    "GET",
    "http://localhost:8089/tiendaMia/categorias",
  );
  console.log(responseData);
  const listaCategorias = responseData;
  //CREACION DE CONTENEDOR

  for (const categoria of listaCategorias) {
    const optionCategoria = document.createElement("option");
    optionCategoria.innerHTML = "";
    optionCategoria.value = categoria.idCategoria;
    optionCategoria.textContent = categoria.nombre;
    contenedorCategoria.appendChild(optionCategoria);
  }

  fetchProductos();
}

//PRODUCTOS  
//const selectProducto = document.createElement("select");
async function fetchProductos() {
  const responseData = await sendHTTPRequest(
    "GET",
    "http://localhost:8089/tiendaMia/productos",
  );
  //console.log(responseData);

  //const listaProductos = responseData.filter(p => p.idCategoria == idCategoriaSeleccionada);
  const listaProductos = responseData;
  contenerdorProductos.innerHTML = ""
  for (const producto of listaProductos) {
    if (contenedorCategoria.value == producto.idCategoria) {
      const optionProducto = document.createElement("option");
      optionProducto.value = producto.idProducto;
      optionProducto.textContent = producto.nombre;
      optionProducto.setAttribute("data-precio", producto.precio);
      contenerdorProductos.appendChild(optionProducto);
    }
  }
  precio();
}

function precio(params) {
    const precioElegido = contenerdorProductos.options[contenerdorProductos.selectedindex]    
    if (precioElegido) {
          cuadroDePrecio.value = precioElegido.getAttribute("data-precio");
    } else {
          cuadroDePrecio.value = ""
    }

  }

 contenedorCategoria.onchange = fetchProductos
 contenerdorProductos.onchange = precio
//fetchProductos();
fecthCategorias();
