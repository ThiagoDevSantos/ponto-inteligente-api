package pontoeletronico.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pontoeletronico.api.entities.Lancamento;
import pontoeletronico.api.repositories.LancamentoRepository;
import pontoeletronico.api.services.LancamentoService;

import java.util.Optional;

@Service
public class LancamentoServiceImpl implements LancamentoService {

    private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
        log.info("Buscando lançamentos para o funcionário ID {}", funcionarioId);
        return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
    }

    @Cacheable("lancamentoPorId")
    public Optional<Lancamento> buscarPorId(Long id) {
        log.info("Buscando lannçamento por ID {}", id);
        return this.lancamentoRepository.findById(id);
    }

    @CachePut("lancamentoPorId")
    public Lancamento persistir(Lancamento lancamento) {
        log.info("Persistindo o lançamento: {}", lancamento);
        return this.lancamentoRepository.save(lancamento);
    }

    public void remover(Long id) {
        log.info("Removendo o lançamento ID {}", id);
        this.lancamentoRepository.delete(id);
    }
}
