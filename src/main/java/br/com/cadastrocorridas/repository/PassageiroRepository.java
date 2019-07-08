
package br.com.cadastrocorridas.repository;

import br.com.cadastrocorridas.domain.Passageiro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassageiroRepository extends CrudRepository<Passageiro, Long> {
}

