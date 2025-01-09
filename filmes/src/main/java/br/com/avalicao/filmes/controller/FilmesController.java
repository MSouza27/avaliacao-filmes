package br.com.avalicao.filmes.controller;

import br.com.avalicao.filmes.model.Filmes;
import br.com.avalicao.filmes.service.FilmesService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filme")
public class FilmesController {

    private final FilmesService filmesService;

    public FilmesController(FilmesService filmesService) {
        this.filmesService = filmesService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Filmes> cadastrarFilme(@RequestBody @Valid Filmes filmes){
        Filmes dados = filmesService.cadastrar(filmes);
        return ResponseEntity.status(201).body(dados);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<Page<Filmes>> listarFilme(@PageableDefault(size = 3, sort = {"id"})Pageable pageable){
        Page<Filmes> dados = filmesService.listar(pageable);
        return ResponseEntity.ok(dados);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Filmes> atualizarFilme(@PathVariable Long id, @RequestBody @Valid Filmes filmesAtualizado){
        Filmes dados = filmesService.localizar(id);
        if (dados == null){
            return ResponseEntity.notFound().build();
        }

        Filmes dadosAtualizados = filmesService.atualizar(id, filmesAtualizado);
        return ResponseEntity.ok(dadosAtualizados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletarFilme(@PathVariable Long id){
        Filmes dados = filmesService.localizar(id);
        if (dados == null){
            return ResponseEntity.notFound().build();
        }

        filmesService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
