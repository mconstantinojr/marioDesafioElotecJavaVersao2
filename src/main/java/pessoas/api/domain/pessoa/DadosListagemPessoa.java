package pessoas.api.domain.pessoa;

import pessoas.api.domain.contato.Contato;
import pessoas.api.domain.contato.DadosDetalhamentoContato;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record DadosListagemPessoa(Long id, String nome, String cpf, LocalDate data_nascimento, List<DadosDetalhamentoContato> contatos) {

    public DadosListagemPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(), pessoa.getData_nascimento(), pessoa.obterDetalhamentoContato(pessoa.getListaContato()));
    }

}
