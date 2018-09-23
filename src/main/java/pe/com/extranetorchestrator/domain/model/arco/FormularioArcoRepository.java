package pe.com.extranetorchestrator.domain.model.arco;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pe.com.extranetorchestrator.infrastructure.persistence.jpa.arco.entity.FormularioArcoEntity;

public interface FormularioArcoRepository extends CrudRepository<FormularioArcoEntity, Integer> {

	@Query("SELECT coalesce(max(ch.id), 0) FROM FormularioArco ch")
	Long getMaxId();
}
