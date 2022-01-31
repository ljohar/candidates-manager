import React from "react";

function LoginButton (props) {
    return(
        <div  className="text-center d-grid gap-2">
          <button
            id="buttonLogin"
            type="submit"
            className="btn btn-primary"
              >
            Iniciar Sesión
          </button>
        </div>
    )
}

export { LoginButton }