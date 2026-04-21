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

//Tabla de de categorias
const headerCategoria = document.getElementById("headCategorias");
const bodyCategorias = document.getElementById("bodyTablaCategorias");
async function listarCategorias() {
  const responseData = await sendHTTPRequest(
    "GET",
    "http://localhost:8089/tiendaMia/categorias",
  );
  console.log("Cat: ", responseData);
  const listaCategorias = responseData;
  const celdaHead = document.createElement("th");
  if (listaCategorias != null) {
    console.log("siuuuuu");
    celdaHead.innerText = "CATEGORIAS";
    headerCategoria.appendChild(celdaHead);
  } else {
    celdaHead.innerText = "No hay categorias";
  }

  for (const cat of listaCategorias) {
    const fila = document.createElement("tr");
    const celda = document.createElement("td");
    celda.innerText = cat.nombre;
    fila.appendChild(celda);
    bodyCategorias.appendChild(fila);
  }
}
listarCategorias();

//Productos
const headerProductos = document.getElementById("tbhProductos");
const bodyProductos = document.getElementById("tbdyProductos");
async function listarProductos() {
  const responseData = await sendHTTPRequest(
    "GET",
    "http://localhost:8089/tiendaMia/productos",
  );
  console.log("Pro: ", responseData);
  const listaProductos = responseData;

  if (listaProductos != null) {
    const filaHead = document.createElement("tr");
    const thNombre = document.createElement("th");
    const thMarca = document.createElement("th");
    const thPrecio = document.createElement("th");
    const thStock = document.createElement("th");
    console.log("siuuuuu");
    thNombre.innerText = "NOMBRE"
    thMarca.innerText = 'MARCA'
    thPrecio.innerText = "PRECIO"
    thStock.innerText = "STOCK"
    filaHead.appendChild(thNombre)
    filaHead.appendChild(thMarca)
    filaHead.appendChild(thPrecio)
    filaHead.appendChild(thStock)
    headerProductos.appendChild(filaHead);
  } else {
    //celdaHead.innerText = "No hya categorias";
  }

  for (const pro of listaProductos) {
    const fila = document.createElement("tr");
    const celdaNombre = document.createElement("td");
    const celdaMarca = document.createElement("td");
    const celdaPrecio = document.createElement("td");
    const celdaStock = document.createElement("td");

    celdaNombre.innerText = pro.nombre;
    celdaMarca.innerText = pro.marca;
    celdaPrecio.innerText = pro.precio;
    celdaStock.innerText = pro.stock;
    //celda.innerText = pro.precio;
    fila.appendChild(celdaNombre);
    fila.appendChild(celdaMarca);
    fila.appendChild(celdaPrecio);
    fila.appendChild(celdaStock);
    bodyProductos.appendChild(fila);
  }
}
listarProductos();


//Clientes

const headerClientes = document.getElementById("thClientes");
const bodyClientes = document.getElementById("tbClientes");
async function listarClientes() {
  const responseData = await sendHTTPRequest(
    "GET",
    "http://localhost:8089/tiendaMia/clientes",
  );
  console.log("Cat: ", responseData);
  const listarClientes = responseData;
  const filaHead = document.createElement("tr");
  if (listarClientes != null) {
    filaHead.innerHTML = `
        <th>NOMBRE</th>
        <th>APELLIDO</th>
        <th>DNI</th>
        <th>TELEFONO</th>
    `
    headerClientes.appendChild(filaHead);
  } else {
    filaHead.innerText = "No hay categorias";
  }

  for (const cli of listarClientes) {
    const fila = document.createElement("tr");
    const nombre = document.createElement("td");
    const apellido = document.createElement("td");
    const dni = document.createElement("td");
    const telefono = document.createElement("td");
    nombre.innerText = cli.nombre;
    apellido.innerText = cli.apellido;
    dni.innerText = cli.dni;
    telefono.innerText = cli.telefono;
    fila.appendChild(nombre);
    fila.appendChild(apellido);
    fila.appendChild(dni);
    fila.appendChild(telefono);
    bodyClientes.appendChild(fila);
  }
}
listarClientes();