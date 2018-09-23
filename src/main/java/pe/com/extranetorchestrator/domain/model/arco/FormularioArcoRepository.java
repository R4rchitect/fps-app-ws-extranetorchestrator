package pe.com.extranetorchestrator.domain.model.arco;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FormularioArcoRepository extends CrudRepository<FormularioArco, Integer> {

	@Query("SELECT coalesce(max(ch.id), 0) FROM FormularioArco ch")
	Long getMaxId();
}
