function Tabela({vetor, selecionar}) {
    
    return (
       <table class="table">
        <thead>
            <tr>
                <th>#</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>DATA NASCIMENTO</th>
                <th>DATA NASCIMENTO</th>
                <th>Selecionar</th>
            </tr>
        </thead>
        <body>
            {
                vetor.map((obj, indice) => (
                    <tr key={indice}>
                    <td>{indice+1}</td>
                    <td>{obj.nome}</td>
                    <td>{obj.cpf}</td>
                    <td>{obj.data_nascimento}</td>
                    <td><button onClick={() => {selecionar(indice)}} className="btn btn-success">Selecionar</button></td>
                </tr>

                ))
            }
        </body>
       </table>
    )

}

export default Tabela;