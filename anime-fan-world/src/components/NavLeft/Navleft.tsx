import { useState } from "react";
import { Link } from "react-router-dom";
import Arrowbtnhome from "../../assets/Icons/Arrowbtnhome";
import "./Navleft.css"

const Navleft = () => {
  const [number, setNumber] = useState(0);

  const navleft = () => {
    if (number === 0) {
      setNumber(1);
    } else {
      setNumber(0);
    }
  };

  return (
    <>
      <div
        className="navbarleft"
        style={{
          transform: number === 0 ? "translateX(-423px)" : "translateX(0)",
        }}
      >
        <div
          className={`header-navbarleft ${
            number === 0 ? "" : "header-navbarleft_1"
          }`}
          style={{
            opacity: number === 0 ? "0" : "1",
          }}
        >
          <ul>
            <li>
              <Link to={""}>Inicio</Link>
            </li>
            <li>
              <Link to={""}>En Emisión</Link>
            </li>
            <li>
              <Link to={""}>Catálogo</Link>
            </li>
            <li>
              <Link to={""}>Próximamente</Link>
            </li>
            <li>
              <Link to="https://somoskudasai.com/">Noticias</Link>
            </li>
          </ul>
        </div>
        <div onClick={navleft} className="header-navbarleft-button">
          <div className="black-btn-control"></div>
          <div
            className="btn-control"
            style={{
              transform: number === 0 ? "rotate(0deg)" : "rotate(180deg)",
            }}
          >
            <Arrowbtnhome />
            <Arrowbtnhome />
          </div>
        </div>
      </div>
      <div onClick={navleft}
        className="dark-window"
        style={{
          opacity: number === 0 ? "0" : "0.6",
          visibility: number === 0 ? "hidden" : "visible",
        }}
      ></div>
    </>
  )
}

export default Navleft
