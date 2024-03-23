package pessoas.api.domain.pessoa;

import pessoas.api.domain.contato.DadosDetalhamentoContato;

import java.time.LocalDate;
import java.util.List;

public record DadosDetalhamentoPessoaContato(Long id, String nome, String cpf, LocalDate data_nascimento) {

    public DadosDetalhamentoPessoaContato(Pessoa pessoa, List<DadosDetalhamentoContato> dadosDetalhamentoContatoList) {
        this(pessoa.getId(), pessoa.getNome(),pessoa.getCpf(), pessoa.getData_nascimento());
    }
}
