package pessoas.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pessoas.api.domain.contato.*;
import pessoas.api.domain.pessoa.*;

import java.util.*;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "*")
public class PessoaController {

        @Autowired
        private PessoaRepository pessoaRepository;

        @Autowired ContatoRepository contatoRepository;

        @PostMapping
        @Transactional
        public void cadastrar(@RequestBody @Valid DadosCadastroPessoa dados) {
            var pessoa = new Pessoa(dados);
            List<Contato> contatos = new ArrayList<>();
            for (Contato contatoIn : dados.listaContato()) {
                    var dadosContato = new DadosContato(contatoIn.getNome(), contatoIn.getTelefone(), contatoIn.getEmail());
                    var contato = new Contato(dadosContato);
                    contato.setPessoa(pessoa);
                    contatos.add(contato);
            }
            pessoa.setListaContato(contatos);
            pessoaRepository.save(pessoa);
        }

        @GetMapping
        public Page<DadosListagemPessoa> listar(@PageableDefault(size=10, page=0, sort={"nome"}) Pageable paginacao) {
                return pessoaRepository.findAll(paginacao).map(DadosListagemPessoa::new);
        }


        @PutMapping
        @Transactional
        public void atualizar(@RequestBody @Valid DadosAtualizacaoPessoa dados) {
                var pessoa = pessoaRepository.getReferenceById(dados.id());
                for (Contato contatoParaAlterar : dados.listaContato()) {
                    for (Contato contato : pessoa.getListaContato()) {
                        if (contato.getId() == contatoParaAlterar.getId()) {
                            var dadosContato = new DadosAtualizacaoContato(contatoParaAlterar.getId(),contatoParaAlterar.getNome(),contatoParaAlterar.getTelefone(),contatoParaAlterar.getEmail());
                            contato.atualizarInformacoes(dadosContato);
                        }
                    }
                }
                pessoa.atualizarInformacoes(dados);
        }

        @DeleteMapping("/{id}")
        @Transactional
        public void excluir(@PathVariable Long id) {
                pessoaRepository.deleteById(id);
        }

        @GetMapping("/{id}")
        public ResponseEntity detalhar(@PathVariable Long id) {
           var pessoa = pessoaRepository.getReferenceById(id);

           List<DadosDetalhamentoContato> contatos = new ArrayList<>();
           for (Contato contato : pessoa.getListaContato()) {
               contatos.add(new DadosDetalhamentoContato(contato.getId(), contato.getNome(), contato.getTelefone(), contato.getEmail()));
           }

           return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa,contatos));

        }
}
