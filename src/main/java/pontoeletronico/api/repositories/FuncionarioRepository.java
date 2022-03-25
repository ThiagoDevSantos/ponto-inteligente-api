package pontoeletronico.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pontoeletronico.api.entities.Funcionario;


@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {

    Funcionario findByCpf (String cpf);
    Funcionario findByEmail (String email);
    Funcionario findByCpfOrEmail(String cpf, String email);
}
