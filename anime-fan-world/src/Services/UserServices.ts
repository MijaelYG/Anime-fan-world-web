import { LoginUser } from "../Interfaces/LoginInterface";
import { Usuario } from "../Interfaces/UserInterface";

export const fetchCrearCuentaUsuario = async (usuario: Usuario) => {
  try {
    const response = await fetch("http://localhost:8080/api/usuario", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(usuario),
    });

    if (!response.ok) {
      throw new Error("Error al crear la cuenta");
    }
    return await response.json();
    
  } catch (error) {
    throw console.error(error);
  }
};

export const FetchIniciarSesion = async (loginuser: LoginUser) =>{
  try {
    const response = await fetch("http://localhost:8080/api/login/iniciar",{
      method: "POST",
      headers:{
        "Content-Type": "application/json"
      },
      body: JSON.stringify(loginuser),
    })
    if(!response.ok){
      throw new Error("Hubo un error interno."); 
    }
    const respuesta = await response.json();
    localStorage.setItem("token",respuesta.message);
    if(respuesta.message == "0"){
      return 0
    }else if(respuesta.message == "1"){
      return 1
    }else if (respuesta.message == "-1"){
      return -1
    }else{
      localStorage.setItem("token",respuesta.message);
      return respuesta
    }
  } catch (error) {
    throw console.error(error);
  }
}
