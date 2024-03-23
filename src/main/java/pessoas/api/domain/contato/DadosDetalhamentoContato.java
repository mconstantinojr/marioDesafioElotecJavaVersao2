package pessoas.api.domain.contato;

import pessoas.api.domain.pessoa.Pessoa;

import java.time.LocalDate;

public record DadosDetalhamentoContato(Long id, String nome, String telefone, String email) {

    public DadosDetalhamentoContato(Contato contato) {
        this(contato.getId(), contato.getNome(),contato.getTelefone(), contato.getEmail());
    }
}
