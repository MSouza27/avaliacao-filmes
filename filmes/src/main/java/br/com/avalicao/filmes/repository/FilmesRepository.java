package br.com.avalicao.filmes.repository;

import br.com.avalicao.filmes.model.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmesRepository extends JpaRepository<Filmes, Long> {
}
