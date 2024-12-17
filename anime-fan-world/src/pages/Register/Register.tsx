import { Link } from "react-router-dom";
import { useState } from "react";
import styles from "./Register.module.css";
import Logo from "../../assets/img/IconoAFW.webp";
import IconUser from "../../assets/Icons/IconUser";
import IconLastName from "../../assets/Icons/IconLastName";
import IconNinja from "../../assets/Icons/Iconninja";
import IconEmail from "../../assets/Icons/IconEmail";
import IconPassword from "../../assets/Icons/IconPassword";
import IconPasswordOpen from "../../assets/Icons/IconPasswordOpen";
import RegisterBoy from "../../assets/img/RegisterBoy.webp";
import { fetchCrearCuentaUsuario } from "../../Services/UserServices";
import { Usuario } from "../../Interfaces/UserInterface";

const Register = () => {
  const [passwordval, setPasswordval] = useState("");
  const [usuario, setUsuario] = useState<Usuario>({
    nombres:"",
    apellidos:"",
    correo:"",
    usuario:"",
    password:"",
  });

  const btnregister = async (e: React.FormEvent<HTMLFormElement>)=> {
    e.preventDefault();
    if(usuario.usuario.includes(" ") || usuario.correo.includes(" ") || usuario.password.includes(" ") || passwordval.includes(" ")){
      console.log("sin espacios porfavor")
    }else{
      if(usuario.password === passwordval){
        const respuesta = await fetchCrearCuentaUsuario(usuario);
        console.log(respuesta);
      }else{
        console.log("contraseñas diferentes");
      }
    }
  }

  return (
    <div className={styles.mainregister}>
      <div className={styles.contregister}>
        <img className={styles.boyregister} src={RegisterBoy}></img>
        <div className={styles.iconregister}>
          <Link to={"/"}>
            <img src={Logo} alt="" />
          </Link>
        </div>
        <div className={styles.title}>Registrate</div>
        <form onSubmit={btnregister} className={styles.formregister}>
          <div className={styles.inputregister}>
            <input type="text" value={usuario.nombres} onChange={(e) => setUsuario({...usuario, nombres: e.target.value})} required />
            <IconUser></IconUser>
            <span className={styles.line}></span>
            <span className={styles.textp}>Nombres</span>
          </div>
          <div className={styles.inputregister}>
            <input type="text" value={usuario.apellidos} onChange={(e) => setUsuario({...usuario, apellidos: e.target.value})} required />
            <IconLastName></IconLastName>
            <span className={styles.line}></span>
            <span className={styles.textp}>Apellidos</span>
          </div>
          <div className={styles.inputregister}>
            <input type="text" value={usuario.usuario} onChange={(e) => setUsuario({...usuario, usuario: e.target.value })} required />
            <IconNinja></IconNinja>
            <span className={styles.line}></span>
            <span className={styles.textp}>Usuario</span>
          </div>
          <div className={styles.inputregister}>
            <input type="text" value={usuario.correo} onChange={(e)=> setUsuario({...usuario, correo:e.target.value})} required />
            <IconEmail></IconEmail>
            <span className={styles.line}></span>
            <span className={styles.textp}>Correo Electronico</span>
          </div>
          <div className={styles.inputregister}>
            <input type="password" value={usuario.password} onChange={(e) => setUsuario({...usuario, password: e.target.value})} required />
            <IconPassword></IconPassword>
            <span className={styles.line}></span>
            <span className={styles.textp}>Contraseña</span>
          </div>
          <div className={styles.inputregister}>
            <input type="password" value={passwordval} onChange={(e) => setPasswordval(e.target.value)} required />
            <IconPasswordOpen></IconPasswordOpen>
            <span className={styles.line}></span>
            <span className={styles.textp}>Repetir Contraseña</span>
          </div>
          <button type="submit" className={styles.btnregister}>REGISTRAR CUENTA</button>
        </form>
        <div className={styles.register}>
          <p>¿Ya te creaste una cuenta?</p>{" "}
          <Link to={"/Login"}>Ingresa aqui</Link>
        </div>
      </div>
    </div>
  );
};

export default Register;
