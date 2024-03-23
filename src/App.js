import logo from './logo.svg';
import './App.css';
import Formulario from './Formulario';
import Tabela from './Tabela';
import { useEffect, useState } from 'react';
import axios from "axios";

function App() {

  // Objeto pessoa
  const pessoa = {
    nome: '',
    cpf: ''
  }
  
  //UseState
  const [btnCadastrar, setBtnCadastrar] = useState(true);
  const [pessoas, setPessoas] = useState([]);
  const [objPessoa, setObjPessoa] = useState(pessoa);

  //UseEffect
  useEffect(()=>{
    fetch("http://localhost:8080/react/pessoas")
    .then(retorno => retorno.json())
    .then(retorno_convertido => setPessoas(retorno_convertido));
  }, []);

  // Obtendo os dados do formularii
  const aoDigitar = (e) => {
    //console.log(e.target);
    setObjPessoa({...objPessoa, [e.target.name]:e.target.value});
  }

  // Cadastrar produto
  const cadastrar = () => {
    fetch("http://localhost:8080/pessoas",{
      method:'post',
      body:JSON.stringify(objPessoa),
      headers: {
        'Content-type':'application/json',
        'Accept':'application/json'
      }
    })
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      //console.log(retorno_convertido);
      if (retorno_convertido.mensagem !== undefined) {
        alert(retorno_convertido.mensagem);
      }else{
        setPessoas([...pessoas, retorno_convertido]);
        alert("Pessoa cadastrada com sucesso!!");
        limparFormulario();
      }
    })
  }

  //Limpar formulario
  const limparFormulario = () => {
    setObjPessoa(pessoa);
    setBtnCadastrar(true);
  }

  //Selecionar pessoa
  const selecionarPessoa = (indice) => {
    setObjPessoa(pessoas[indice]);
    setBtnCadastrar(false);
  }
  //Retorno
  //return (
  //  <div>
  //    <p>{JSON.stringify(pessoas)}</p>
  //<p>{JSON.stringify(objPessoa)}</p>
  //    <Formulario botao={btnCadastrar}></Formulario>
  //    <Tabela vetor={pessoas}></Tabela>
  //  </div>
  //);
  return (
    <div>
      <Formulario botao={btnCadastrar} eventoTeclado={aoDigitar} cadastrar={cadastrar} obj={objPessoa} cancelar={limparFormulario}></Formulario>
      <Tabela vetor={pessoas} selecionar={selecionarPessoa}></Tabela>
    </div>
  );

}

export default App;
