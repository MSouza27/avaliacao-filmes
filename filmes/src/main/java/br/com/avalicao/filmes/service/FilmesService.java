package br.com.avalicao.filmes.service;

import br.com.avalicao.filmes.model.Filmes;
import br.com.avalicao.filmes.repository.FilmesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FilmesService {

    private final FilmesRepository filmesRepository;

    public FilmesService(FilmesRepository filmesRepository) {
        this.filmesRepository = filmesRepository;
    }

    public Filmes cadastrar(Filmes filmes){
        return filmesRepository.save(filmes);
    }

    public Page<Filmes> listar(Pageable pageable){
        return filmesRepository.findAll(pageable);
    }

    public Filmes localizar(Long id){
        return filmesRepository.findById(id).orElse(null);
    }

    public Filmes atualizar(Long id, Filmes filmes){
        Filmes dados = filmesRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Filme não encontrado"));

        dados.setNome(filmes.getNome());
        dados.setTipoFilme(filmes.getTipoFilme());
        dados.setDuracao(filmes.getDuracao());
        dados.setEstrelasAvaliacao(filmes.getEstrelasAvaliacao());

        return filmesRepository.save(dados);
    }

    public void deletar(Long id){
        filmesRepository.deleteById(id);
    }

}
