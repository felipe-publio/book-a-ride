package br.com.cadastrocorridas.repository;

import br.com.cadastrocorridas.domain.Corrida;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorridaRepository extends CrudRepository<Corrida, Integer> {
}
