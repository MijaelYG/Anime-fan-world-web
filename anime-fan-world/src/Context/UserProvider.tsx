import { useEffect, useState } from "react";
import { UserContext } from "./UserContext";

export function UserProvider({children}: any) {
    const [id,setId] = useState<number | null>(null);
    const [usuario, setUsuario] = useState<string | null>(null);

    useEffect(() => {
      const idToken = localStorage.getItem("id");
      const usuarioToken = localStorage.getItem("usuario");

      if(idToken && usuarioToken){
        setId(parseInt(idToken));
        setUsuario(usuarioToken);
      }
    }, [])

    useEffect(() => {
        if(id !== null && usuario !== null){
            localStorage.setItem("id",id.toString());
            localStorage.setItem("usuario",usuario); 
        }else{
            localStorage.removeItem("id");
            localStorage.removeItem("usuario");
        }
    }, [id,usuario])
    
    

  return (
    <UserContext.Provider value={{id, usuario,setId,setUsuario}}>
        {children}
    </UserContext.Provider>
  )
}
