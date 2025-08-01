package br.com.duxusdesafio.service;

import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.ComposicaoTimeRepository;
import br.com.duxusdesafio.repository.IntegranteRepository;
import br.com.duxusdesafio.repository.TimeRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ApiCadastro {

    private final IntegranteRepository integranteRepository;
    private final TimeRepository timeRepository;
    private final ComposicaoTimeRepository composicaoTimeRepository;

    public ApiCadastro(IntegranteRepository integranteRepository, TimeRepository timeRepository, ComposicaoTimeRepository composicaoTimeRepository) {
        this.integranteRepository = integranteRepository;
        this.timeRepository = timeRepository;
        this.composicaoTimeRepository = composicaoTimeRepository;
    }

    public Integrante cadastrarIntegrante(Integrante integrante) {
        Integrante newIntegrante = new Integrante();

        newIntegrante.setNome(integrante.getNome());
        newIntegrante.setFuncao(integrante.getFuncao());
        newIntegrante.setFranquia(integrante.getFranquia());
        newIntegrante.setComposicaoTime(null); // vai atualizar depois que for cadastrado em um time

        return integranteRepository.save(newIntegrante);
    }

    public Time cadastrarTime(Time time) {
        Time newTime = new Time();
        newTime.setData(time.getData());
        newTime.setComposicaoTime(null); // depois cadastra os integrantes

        return timeRepository.save(newTime);
    }

    public Integrante adicionarIntegranteAoTime(Integrante newIntegrante, Long timeId) {
        try {
            Optional<Time> timeOpt = timeRepository.findById(timeId);
            if (timeOpt.isEmpty()) {
                throw new RuntimeException("Time não encontrado");
            }

            Time time = timeOpt.get();
            Integrante integrante = cadastrarIntegrante(newIntegrante);

            ComposicaoTime compTime = new ComposicaoTime(time, integrante);
            composicaoTimeRepository.save(compTime);

            time.getComposicaoTime().add(compTime);
            integrante.getComposicaoTime().add(compTime);

            return integrante;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar integrante: " + e.getMessage());
        }
    }
}
