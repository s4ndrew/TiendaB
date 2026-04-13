

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
        let response = await fetch ("http://localhost:8089/tiendaMia/categorias")
        let data = await response.json();
        //console.log(data);
        const container = document.getElementById("list")
        
        container.innerHTML = "";

         data.forEach(categoria => {
            const li = document.createElement('li')
            
            li.textContent = `${categoria.idCategoria} ${categoria.nombre}`
            container.appendChild(li)
         });
    } catch (error) {
        console.log(error);
    }
}
dataCategorias()



async function dataClientes() {
    try {
        let response = await fetch("http://localhost:8089/tiendaMia/clientes")
        let data = await response.json()
        
        let cl = document.getElementById("clientes")
        cl.innerHTML="";
        data.forEach(clientes => {
            let li = document.createElement("li")
            li.textContent = clientes.nombre
            cl.appendChild(li)
        });
    } catch (error) {
        console.log("error" + error);
    }
}
dataClientes()
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