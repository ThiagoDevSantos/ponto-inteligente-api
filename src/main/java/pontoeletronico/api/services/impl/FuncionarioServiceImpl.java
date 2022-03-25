package pontoeletronico.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pontoeletronico.api.entities.Funcionario;
import pontoeletronico.api.repositories.FuncionarioRepository;
import pontoeletronico.api.services.FuncionarioService;

import java.util.Optional;


@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario persistir(Funcionario funcionario) {
        log.info("Persistindo funcionário: {}", funcionario);
        return this.funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> buscarPorCpf(String cpf) {
        log.info("Buscando funcionário pelo CPF {}", cpf);
        return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
    }

    public Optional<Funcionario> buscarPorEmail(String email) {
        log.info("Buscando funcionário pelo email {}", email);
        return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
    }

    @Override
    public Optional<Funcionario> buscarPorId(Long id) {
        log.info("Buscando funcionario por ID {}", id);
        return this.funcionarioRepository.findById(id);
    }

}
