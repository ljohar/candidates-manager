import React from 'react';
import {LoginHeader} from './LoginHeader.js'
import {FormEntry} from './FormEntry.js'
import { LoginCheck } from './LoginCheck.js';
import { LoginButton } from './LoginButton.js';
import { LoginFooter } from './LoginFooter.js';
import { LoginPicture } from './LoginPicture.js';

function Login(props){
    return(
        <React.Fragment>
            <div class="container-fluid">
                <div className="row justify-content-center">
                    <div className=" col-sm-9 col-md-7 col-lg-4 p-5 vh-100">
                        <LoginHeader/>
                        <form>
                            <FormEntry label="Email" placeholder="Introduzca su correo"/>
                            <FormEntry label="Contraseña" placeholder="Introduzca su contraseña"/>
                            <LoginCheck/>
                            <LoginButton/>
                            <LoginFooter/>
                        </form>
                    </div>
                    <div className="col-md-8 p-0 d-none d-lg-block">
                        <LoginPicture/>
                        
                    </div>
                </div>
            </div>
                

            

            </React.Fragment>

            

    );

}

export { Login }