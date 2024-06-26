function Formulario({botao, eventoTeclado, cadastrar, obj, cancelar}) {
    
    return (
        <form>
            <input type="text" value={obj.nome} onChange={eventoTeclado} name="nome" placeholder="Nome" className="form-control"/>
            <input type="text" value={obj.cpf} onChange={eventoTeclado} name="cpf" placeholder="Cpf" className="form-control"/>
            <input type="text" value={obj.data_nascimento} onChange={eventoTeclado} name="dataNascimento" placeholder="dataNascimento" className="form-control"/>

            {
                botao
                ?
                <input type="button" value="Cadastrar" onClick={cadastrar} className="btn btn-primary"/>
                :
                <div>
                    <input type="button" value="Alterar" className="btn btn-warning"/>
                    <input type="button" value="Remover" className="btn btn-danger"/>
                    <input type="button" value="Cancelar" onClick={cancelar} className="btn btn-secondary"/>
                </div>
            }
            
        </form>    
    )

}

export default Formulario;