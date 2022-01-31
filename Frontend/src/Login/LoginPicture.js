import React from "react";
import background from './background_picture.jpeg';
import './LoginPicture.css'

console.log(background);

function LoginPicture(props){
    return(
        <img
            src={background}
            alt="Background"
            className="img-fluid background-image"
          />
    );
}

export {LoginPicture}