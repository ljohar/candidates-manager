import React from "react";

function FilterComponent(props){
    return(
        <div className="row">
            <label  className="form-label" htmlFor="search">
                Alumnos 
            </label>
            <input
                type="text"
                className="form-control"
                id="search"
                placeholder="Buscar por Nombre, Email o palabra clave"
            />
            
        </div>        

    );
}

export {FilterComponent}