import { createContext } from "react";

interface UserContextType{
    id: number | null,
    usuario: string | null,
    setId: (id: number) => void;
    setUsuario: (usuario: string) => void;
}

export const UserContext = createContext<UserContextType>({
    id:null,
    usuario:null,
    setId: () => {},
    setUsuario: () => {},
});