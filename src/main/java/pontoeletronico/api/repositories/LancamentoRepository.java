package pontoeletronico.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pontoeletronico.api.entities.Funcionario;
import pontoeletronico.api.entities.Lancamento;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;

@Transactional
  @NamedQueries({
          @NamedQuery(name = "LancamentoRepository.findByFuncionarioId",
          query = "SELECT lanc FROM Lancamento lanc WHERE lanc.funcionario.id = :funcionarioId") })
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
    List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
    
    Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
}
