import React from "react";

function CreateInput (props) {
    return(
        <div className="col">
        <label for="nombre" class="form-label">
            {props.label}
        </label>
        <input 
            type="name" 
            id="nombre" 
            placeholder={props.placeholder}
            class="form-control">
        </input>
        </div>
    );

}
