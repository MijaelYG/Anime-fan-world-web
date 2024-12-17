import Logo from "../../assets/img/IconoAFW.webp";
import Iconuser from "../../assets/Icons/IconUser";
import IconPassword from "../../assets/Icons/IconPassword";
import LoginBoy from "../../assets/img/LoginBoy.webp";
import { Link, useNavigate } from "react-router-dom";
import styles from "./Login.module.css";
import React, {useContext, useEffect, useState } from "react";
import { LoginUser } from "../../Interfaces/LoginInterface";
import { FetchIniciarSesion } from "../../Services/UserServices";
import { UserContext } from "../../Context/UserContext";

const Login = () => {

  const [loading, setLoading] = useState(true);
  const [valuelogin, setValuelogin] = useState(true);
  const {setId,setUsuario} = useContext(UserContext);
  const [login, setLogin] = useState<LoginUser>({
    id: null,
    usuario: "",
    password: "",
    message: null,
  });
  const navegation = useNavigate();
  const tokencod = localStorage.getItem("token");

  useEffect(() => {
    if (tokencod) {
      setLoading(true);
      navegation("/");
    }else{
      setLoading(false)
    }
  }, [valuelogin]);

  const btnLogin = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (login.usuario == " " || login.password == " ") {
      console.log("sin espacios");
    } else {
      const respuesta = await FetchIniciarSesion(login);
      if (respuesta == 0) {
        console.log("La cuenta no existe.");
      } else if(respuesta == 1){
        console.log("La contraseña o el usuario es incorrecto." );
      }else if(respuesta == -1){
        console.log("Hubo un problema con su cuenta.")
      }else{
        console.log(localStorage.getItem("token"))
        setValuelogin(false);
        setId(respuesta.id)
        setUsuario(respuesta.usuario)
      }
    }
  };

 if (loading) {
    return null ;
  }

  return (
    <div className={styles.mainlogin}>
      <div className={styles.contlogin}>
        <img className={styles.boylogin} src={LoginBoy}></img>
        <div className={styles.iconlogo}>
          <Link to={"/"}>
            <img src={Logo} alt="" />
          </Link>
        </div>
        <div className={styles.title}>Iniciar Sesión</div>
        <form onSubmit={btnLogin} className={styles.formlogin} action="">
          <div className={styles.inputlogin}>
            <input
              type="text"
              value={login.usuario}
              onChange={(e) => setLogin({ ...login, usuario: e.target.value })}
              required
            />
            <Iconuser></Iconuser>
            <span className={styles.line}></span>
            <span className={styles.textp}>Usuario</span>
          </div>
          <div className={styles.inputlogin}>
            <input
              type="password"
              value={login.password}
              onChange={(e) => setLogin({ ...login, password: e.target.value })}
              required
            />
            <IconPassword></IconPassword>
            <span className={styles.line}></span>
            <span className={styles.textp}>Contraseña</span>
          </div>
          <button type="submit" className={styles.btniniciar}>
            INICIAR SESIÓN
          </button>
        </form>
        <div className={styles.register}>
          <p>¿No tienes cuenta?</p> <Link to={"/Register"}>Registrate</Link>
        </div>
      </div>
    </div>
  );
};

export default Login;
