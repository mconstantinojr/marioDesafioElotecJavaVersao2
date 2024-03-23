package pessoas.api.domain.pessoa;

import pessoas.api.domain.contato.DadosDetalhamentoContato;

import java.time.LocalDate;
import java.util.List;

public record DadosDetalhamentoPessoa(Long id, String nome, String cpf, LocalDate data_nascimento, List<DadosDetalhamentoContato> contatos) {

    public DadosDetalhamentoPessoa(Pessoa pessoa, List<DadosDetalhamentoContato> contatos) {
        this(pessoa.getId(), pessoa.getNome(),pessoa.getCpf(), pessoa.getData_nascimento(), contatos);
    }
}
