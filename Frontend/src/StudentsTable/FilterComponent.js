import React from "react";
import './FilterComponent.css'

function FilterComponent(searchValue, setSearchValue){
    // const onSearchValueChange = (event) => {
    //     console.log(event.target.value);
    //     setSearchValue(event.target.value)
    // }
    return(
        <div className="row m-2">
            <div className=" col-10 form-group form-inline">
                <label  className="form-label Students me-2" htmlFor="search">
                    Alumnos 
                </label>
                <input
                    type="text"
                    className="form-control d-inline-flex w-50"
                    id="search"
                    placeholder="Buscar por Nombre, Email o palabra clave"
                    value={searchValue}
                    onChange={(event) => setSearchValue(event.target.value)}
                />                                                       
            </div>

            <div className="col content-center gap-2 "> 
                <button
                    id="buttonLogin"
                    type="submit"
                    className="btn btn-light"
                    >
                    Crear nuevo alumno
                </button>
                
            </div>
            
        </div>        

    );
}

export {FilterComponent}