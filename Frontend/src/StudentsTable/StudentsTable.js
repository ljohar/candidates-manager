import React from "react";
import DataTable from "react-data-table-component";
import { FilterComponent } from "./FilterComponent";
import './etiqueta.css'

const defaultStudentsTable = [
    {name:"student1", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "student1@gmail.com", tags:["Python", "Java"] },
    {name:"student2", city: "Valencia", country:"Colombia", phone: "+ 34 657852546", email: "student2@gmail.com", tags:["Python", "Java"] },
    {name:"student3", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "student3@gmail.com", tags:["Python", "Java"] },
    {name:"student4", city: "Valencia", country:"España", phone: "+ 34 657852546", email: "smoteagudo@gmail.com", tags:["Python", "Java"] }
   
    
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

    const [data, setData] = React.useState(defaultStudentsTable);
    const [searchValue, setSearchValue] = React.useState("");
    const [resetPaginationToggle, setResetPaginationToggle] = React.useState(false);
    const filteredStudents = defaultStudentsTable.filter(
        item => item.country && item.country.toLowerCase().includes(searchValue.toLowerCase()),
        );

    // const subHeaderComponentMemo = React.useMemo(() => {
    //     const handleClear = () => {
    //         if (searchValue) {
    //             setResetPaginationToggle(!resetPaginationToggle);
    //             setSearchValue('');
    //             }
    //         };
    //         return (
    //             <FilterComponent 
    //                 onSearchValueChange={e => setSearchValue(e.target.value)} 
    //                 //onClear={handleClear} 
    //                 searchValue={searchValue} 
    //             />
    //         );
    //     }, [searchValue, resetPaginationToggle]);

    

    // const subHeaderComponentMemo = React.useMemo(() => {
    //     const handleClear = () => {
    //         if (filterText) {
    //             setResetPaginationToggle(!resetPaginationToggle);
    //             setFilterText('');
    //             }
    //         };
    

    // if (!searchValue.length >= 1){
    //     searchedStudents = defaultStudentsTable
    // }else{
    //     searchedStudents = defaultStudentsTable.filter (student => {
    //     const studentCountry = student.country.toLowerCase();
    //     const searchText = searchValue.toLocaleLowerCase;
    //     return studentCountry.includes(searchText)
    //     })
    // }
    function search(rows){
        return rows.filter(row =>
             row.name.toLowerCase().indexOf(searchValue.toLowerCase())> -1 ||
             row.email.toLowerCase().indexOf(searchValue.toLowerCase())> -1
             );
    }


    return(

        <React.Fragment>

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
                <div className="col content-center gap-2 my-2 "> 
                    <button
                        id="buttonLogin"
                        type="submit"
                        className="btn btn-light"
                        >
                        Crear nuevo alumno
                    </button>
                </div>
            </div>

            
            <DataTable
                columns = {columns}
                data = {search(data)} //luego probamos con poner data(almacenda en el hook)
                noHeader
                pagination
                paginationComponentOptions={paginacionOpciones}
                fixedHeader
                fixedHeaderScrollHeight="100vh"
			    selectableRows
			    persistTableHead
                highlightOnHover
                className="table-responsive"
            />      
            
        </React.Fragment>

    );
}

export { StudentsTable, defaultStudentsTable }