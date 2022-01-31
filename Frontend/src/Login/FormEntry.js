import React from "react";


function FormEntry(props){
    return(
        <div className="my-4">
              <label htmlfor="email" className="form-label">{props.label}</label>
              <input
                type="email"
                className="form-control"
                id="email"
                placeholder={props.placeholder}
              />
        </div>

    )
}

export {FormEntry}