function sendHTTPRequest(method, url, data) {
  return fetch(url, {
    method: method,
    body: data ? JSON.stringify(data) : null,
    headers: {
      "Content-type": "application/json",
    },
  }).then((response) => {
    if (response.status === 204) {
      return { success: true }; 
    }
    return response.text().then((text) => {
      if (!text) {
        return { success: true };
      }
      return JSON.parse(text);
    });
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
  headerCategoria.innerHTML = ""
  bodyCategorias.innerHTML = ""
  if (listaCategorias != null) {
    const filaHead = document.createElement("tr")
    filaHead.innerHTML = `
      <th>CATEGORIA</th>
      <th>ACCIONES</th>
    `
    headerCategoria.appendChild(filaHead);
  } else {
    celdaHead.innerText = "No hay categorias";
  }

  for (const cat of listaCategorias) {
    const fila = document.createElement("tr");
    fila.innerHTML = `
      <td>${cat.nombre}</td>
      <td class=" text-center">
        <btn class="btn btn-danger" onclick="eliminarCategorias(${cat.idCategoria})">Eliminar</btn>
      </td>
    `
    bodyCategorias.appendChild(fila);
  }
}
listarCategorias();

//Agregar categorias

async function agregaCategorias() {
    const bodCate = {
      nombre : document.getElementById("categoria").value
    }
    const responseData = await sendHTTPRequest(
      "POST",
      "http://localhost:8089/tiendaMia/categorias",bodCate
    )

    if (responseData) {
      alert("Nuevo registro exitoso")
      console.log("Nueva categoria: " + bodCate);
      listarCategorias();
    }
}

//Eliminar categorias
async function eliminarCategorias(id) {
    const responseData = await sendHTTPRequest(
      "DELETE",
      `http://localhost:8089/tiendaMia/categorias/${id}`
    )

    if (responseData) {
      listarCategorias();
      alert("Categoria eliminada")
    }
}




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
  headerProductos.innerHTML = ""
  bodyProductos.innerHTML = ""
  if (listaProductos != null) {
    const filaHead = document.createElement("tr");
    filaHead.innerHTML = `
      <th>NOMBRE</th>
      <th>MARCA</th>
      <th>PRECIO</th>
      <th>STOCK</th>
      <th>ACCIONES</th>
    `
    headerProductos.appendChild(filaHead)
  } else {
    //celdaHead.innerText = "No hya categorias";
  }

  for (const pro of listaProductos) {
    const fila = document.createElement("tr");
    fila.innerHTML = `
      <td>${pro.nombre}</td>
      <td>${pro.marca}</td>
      <td>${pro.precio}</td>
      <td>${pro.stock}</td>
      <td>
        <btn class=" btn btn-danger" onclick="eliminarProducto(${pro.idProducto})">Eliminar</btn>
      </td>
    `
    bodyProductos.appendChild(fila)
  }
}
listarProductos();

//Agregar productos


//Eliminar productos

async function eliminarProducto(id) {
  const responseData = await sendHTTPRequest(
    "DELETE",
    `http://localhost:8089/tiendaMia/productos/${id}`
  )

  if(responseData){
    alert("Producto eliminado")
    listarProductos()
  }
}

//Clientes

const headerClientes = document.getElementById("thClientes");
const bodyClientes = document.getElementById("tbClientes");
async function listarClientes() {
  const responseData = await sendHTTPRequest(
    "GET",
    "http://localhost:8089/tiendaMia/clientes",
  );
  console.log("Cat: ", responseData);
  const listaClientes = responseData;
  const filaHead = document.createElement("tr");
  headerClientes.innerHTML = ""
  bodyClientes.innerHTML = ""
  if (listaClientes != null) {
    filaHead.innerHTML = `
        <th>NOMBRE</th>
        <th>APELLIDO</th>
        <th>DNI</th>
        <th>TELEFONO</th>
        <th>OPCIONES</th>
    `
    headerClientes.appendChild(filaHead);
  } else {
    filaHead.innerText = "No hay categorias";
  }

  for (const cli of listaClientes) {
    const fila = document.createElement("tr");
    fila.innerHTML = `
      <td>${cli.nombre}</td>
      <td>${cli.apellido}</td>
      <td>${cli.dni}</td>
      <td>${cli.telefono}</td>
      <td>
        <btn class="btn btn-danger" onclick="eliminarCliente(${cli.idCliente})">Eliminar</btn>
      </td>

    `
    bodyClientes.appendChild(fila);
  }
}
listarClientes();

//INGRESAR NUEVO CLIENTE
async function registrarCliente() {
    const nuevoCliente = {
        nombre: document.getElementById("inputNombre").value,
        apellido: document.getElementById("inputApellido").value,
        dni: document.getElementById("inputDni").value,
        telefono: document.getElementById("inputTelefono").value
    };

    const response = await sendHTTPRequest(
        "POST", 
        "http://localhost:8089/tiendaMia/clientes", 
        nuevoCliente
    );

    if (response != null) {
        alert("¡Cliente registrado con éxito!");
        listarClientes(); 
        document.getElementById("formCliente").reset();
    }
}

//Elimnar cliente
async function eliminarCliente(id) {

  const response = await sendHTTPRequest(
    "DELETE",
    `http://localhost:8089/tiendaMia/clientes/${id}`
  )

  if (response != null) {
    alert("Cliente eliminado")

    listarClientes();
  }
}