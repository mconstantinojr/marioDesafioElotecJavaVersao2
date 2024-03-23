package pessoas.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pessoas.api.domain.contato.*;
import pessoas.api.domain.pessoa.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {


        @Autowired ContatoRepository contatoRepository;

        @GetMapping
        public Page<DadosListagemContato> listar(@PageableDefault(size=10, page=0, sort={"nome"}) Pageable paginacao) {
                return contatoRepository.findAll(paginacao).map(DadosListagemContato::new);
        }




}
