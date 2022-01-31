import React from "react";
import DataTable from "react-data-table-component";
import { FilterComponent } from "./FilterComponent";
// import { CreateTag } from "./CreateTag";
import './etiqueta.css'
const studentsTable = [
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    {name:"Alvaro Sanchez Monteagudo", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] },
    
]

const columns = [
    {
        name: "Nombre",
        selector: row => row.name,
        sortable: true,
    },
    {
        name: "Ciudad",
        selector: row => row.city,
        sortable: true,
    },
    {
        name: "País",
        selector: row => row.country,
        sortable: true,
    },
    {
        name: "Teléfono",
        selector: row =>row.phone,
        sortable: true,
    },
    {
        name: "Email",
        selector: row=>row.email,
        sortable: true,
        
    },
    {
        name: "Etiquetas",
        selector: row=>row.tags,
        sortable: true,
        // cell: d => <span className="etiqueta">{d.tags}</span>
        cell: d => d.tags.map(tag =>(<span className="etiqueta">{tag}</span>))
    }
]

const paginacionOpciones = {
    rowsPerPageText: 'Filas por página',
    rangeSeparatorText: 'de',
    selectAllrowsItem: true,
    selectAllRowsItemText: 'Todos'

}

function StudentsTable() {
    return(

        <React.Fragment>

            <FilterComponent/>

            <div className="table-responsive"> 
                <DataTable
                    columns = {columns}
                    data = {studentsTable}
                    noHeader
                    pagination
                    paginationComponentOptions={paginacionOpciones}
                    fixedHeader
                    fixedHeaderScrollHeight="100vh"
                    highlightOnHover
                />      
            </div>
        </React.Fragment>

    );
}

export { StudentsTable }