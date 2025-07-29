package br.com.duxusdesafio.service;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.*;


/**
 * Service que possuirá as regras de negócio para o processamento dos dados
 * solicitados no desafio!
 *
 * OBS ao candidato: PREFERENCIALMENTE, NÃO ALTERE AS ASSINATURAS DOS MÉTODOS!
 * Trabalhe com a proposta pura.
 *
 * @author carlosau
 */
@Service
public class ApiService {

    /**
     * Vai retornar um Time, com a composição do time daquela data
     */
    public Time timeDaData(LocalDate data, List<Time> todosOsTimes){
        return todosOsTimes.stream()
                .filter(t -> t.getData().equals(data))
                .findFirst();
    }

    /**
     * Vai retornar o integrante que estiver presente na maior quantidade de times
     * dentro do período
     */
    public Integrante integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        List<Time> timesNasDatas = todosOsTimes.stream()
                .filter(t -> t.getData().isAfter(dataInicial) && t.getData().isBefore(dataFinal))
                .collect(Collector.toList());

        Map<Integrante, Integer>contagemIntegrantes = new HashMap<>();

        for(Time time : timesNasDatas){
            for (ComposicaoTime compTime : time.composicaoTime) {
                contagemIntegrantes.put(compTime.getIntegrante(), contagemIntegrantes.getorDefault(compTime.getIntegrante(), 0) + 1);
            }
        }

        Integrante maisUsado = null;
        Integer maiorUso = -1;

        for (Map.Entry<Integrante, Integer> entry : contagemIntegrantes.entrySet()) {
            if (entry.getValue() > maiorUso) {
                maiorUso = entry.getValue();
                maisUsado = entry.getKey();
            }
        }
        return maisUsado;
    }

    /**
     * Vai retornar uma lista com os nomes dos integrantes do time mais comum
     * dentro do período
     */
    public List<String> integrantesDoTimeMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        List<Time> timesNasDatas = todosOsTimes.stream()
                .filter(t -> t.getData().isAfter(dataInicial) && t.getData().isBefore(dataFinal))
                .collect(Collector.toList());

        Map<Time, Integer>contagemTimes = new HashMap<>();

        for(Time time: timesNasDatas) {
            contagemTimes.put(time, contagemTimes.getOrDefault(time, 0) + 1);
        }

        List<String> integrantes = new ArrayList<>();
        Time timeMaisComum = null;
        Integer maiorUso = -1;

        for(Map.Entry<Time, Integer> entry : contagemTimes.entrySet()) {
            if (entry.getValue() > maiorUso) {
                maiorUso = entry.getValue();
                timeMaisComum = entry.getKey();
            }
        }

        for (ComposicaoTime compTime : timeMaisComum.composicaoTime) {
            integrantes.add(compTime.getIntegrante().nome);
        }

        return integrantes;
    }

    /**
     * Vai retornar a função mais comum nos times dentro do período
     */
    public String funcaoMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        List<Time> timesNasDatas = todosOsTimes.stream()
                .filter(t -> t.getData().isAfter(dataInicial) && t.getData().isBefore(dataFinal))
                .collect(Collector.toList());

        Map<String, Integer>contagemFuncoes = new HashMap<>();

        for(Time time : timesNasDatas){
            for (ComposicaoTime compTime : time.composicaoTime) {
                contagemFuncoes.put(compTime.getIntegrante().funcao, contagemFuncoes.getorDefault(compTime.getIntegrante().funcao, 0) + 1);
            }
        }

        String funcMaisComum = "";
        Integer maiorUso = -1;

        for (Map.Entry<String, Integer> entry : contagemFuncoes.entrySet()) {
            if (entry.getValue() > maiorUso) {
                maiorUso = entry.getValue();
                funcMaisComum = entry.getKey();
            }
        }

        return funcMaisComum;

    }

    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    public String franquiaMaisFamosa(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        List<Time> timesNasDatas = todosOsTimes.stream()
                .filter(t -> t.getData().isAfter(dataInicial) && t.getData().isBefore(dataFinal))
                .collect(Collector.toList());

        Map<String, Integer>contagemFranquias = new HashMap<>();

        for(Time time : timesNasDatas){
            for (ComposicaoTime compTime : time.composicaoTime) {
                contagemFranquias.put(compTime.getIntegrante().franquia, contagemFranquias.getorDefault(compTime.getIntegrante().franquia, 0) + 1);
            }
        }

        String franquiaMaisComum = "";
        Integer maiorUso = -1;

        for (Map.Entry<String, Integer> entry : contagemFranquias.entrySet()) {
            if (entry.getValue() > maiorUso) {
                maiorUso = entry.getValue();
                franquiaMaisComum = entry.getKey();
            }
        }

        return franquiaMaisComum;
    }


    /**
     * Vai retornar o número (quantidade) de Franquias dentro do período
     */
    public Map<String, Long> contagemPorFranquia(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        List<Time> timesNasDatas = todosOsTimes.stream()
                .filter(t -> t.getData().isAfter(dataInicial) && t.getData().isBefore(dataFinal))
                .collect(Collector.toList());

        Map<String, Integer>contagemFranquias = new HashMap<>();

        for(Time time : timesNasDatas){
            for (ComposicaoTime compTime : time.composicaoTime) {
                contagemFranquias.put(compTime.getIntegrante().franquia, contagemFranquias.getorDefault(compTime.getIntegrante().franquia, 0) + 1);
            }
        }

        return contagemFranquias;
    }

    /**
     * Vai retornar o número (quantidade) de Funções dentro do período
     */
    public Map<String, Long> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        List<Time> timesNasDatas = todosOsTimes.stream()
                .filter(t -> t.getData().isAfter(dataInicial) && t.getData().isBefore(dataFinal))
                .collect(Collector.toList());

        Map<String, Integer>contagemFuncoes = new HashMap<>();

        for(Time time : timesNasDatas){
            for (ComposicaoTime compTime : time.composicaoTime) {
                contagemFuncoes.put(compTime.getIntegrante().funcao, contagemFuncoes.getorDefault(compTime.getIntegrante().funcao, 0) + 1);
            }
        }

        return contagemFuncoes;
    }

}

/*
Em algumas funções eu reutilizaria outras funções, como contagemPorFranquia em franquiaMaisFamosa,
mas como fiz na ordem, deixarei assim para mostrar a linha de raciocínio
*/
