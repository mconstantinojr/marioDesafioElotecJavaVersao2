package pessoas.api.domain.contato;

import pessoas.api.domain.pessoa.DadosDetalhamentoPessoa;
import pessoas.api.domain.pessoa.DadosDetalhamentoPessoaContato;
import pessoas.api.domain.pessoa.Pessoa;

public record DadosListagemContato(Long id, String nome, String telefone, String email, DadosDetalhamentoPessoaContato pessoa) {

    public DadosListagemContato(Contato contato) {
        this(contato.getId(), contato.getNome(), contato.getTelefone(), contato.getEmail(), new DadosDetalhamentoPessoaContato(contato.getPessoa().getId(), contato.getPessoa().getNome(), contato.getPessoa().getCpf(), contato.getPessoa().getData_nascimento()));
    }
}
