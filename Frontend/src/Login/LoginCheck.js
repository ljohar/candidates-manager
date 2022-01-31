import React from "react";
import './LoginCheck.css'

function LoginCheck(props) {
    return(
        <div className="my-4 form-check position-relative">
              <input
                type="checkbox"
                class="form-check-input"
                id="exampleCheck1"
              />
              <label className="form-check-label" htmlFor="exampleCheck1"
                >Recuérdame</label
              >

              <a id="labelLink" className="text-decoration-none label-link right-0 top-0 green-color " href="/"
                >He olvidado la contraseña</a
              >
        </div>

    );
}

export { LoginCheck }
