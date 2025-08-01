package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.dto.*;
import br.com.duxusdesafio.mapper.*;
import br.com.duxusdesafio.model.*;
import br.com.duxusdesafio.service.ApiService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ApiControllerDados {

    private final ApiService apiService;
    private final TimeMapper timeMapper = new TimeMapper();
    private final IntegranteMapper integranteMapper = new IntegranteMapper();

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/time-da-data")
    public TimeGetDTO getTimeDaData(@RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        Time time = apiService.timeDaData(data);
        return timeMapper.toGetDto(time);
    }

    @GetMapping("/integrante-mais-usado")
    public IntegranteGetDTO getIntegranteMaisUsado(
            @RequestParam(value = "inicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam(value = "fim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim
    ) {
        Integrante integrante = apiService.integranteMaisUsado(inicio, fim);
        return integranteMapper.toGetDto(integrante);
    }

    @GetMapping("/time-mais-comum")
    public TimeGetDTO getTimeMaisComum(
            @RequestParam(value = "inicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam(value = "fim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim
    ) {
        Time time = apiService.timeMaisComum(inicio, fim);
        return timeMapper.toGetDto(time);
    }

    @GetMapping("/funcao-mais-comum")
    public Map<String, String> getFuncaoMaisComum(
            @RequestParam(value = "inicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam(value = "fim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim
    ) {
        String funcao = apiService.funcaoMaisComum(inicio, fim);
        return Map.of("Função", funcao);
    }

    @GetMapping("/franquia-mais-famosa")
    public Map<String, String> getFranquiaMaisFamosa(
            @RequestParam(value = "inicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam(value = "fim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim
    ) {
        String franquia = apiService.franquiaMaisFamosa(inicio, fim);
        return Map.of("Franquia", franquia);
    }

    @GetMapping("/contagem-por-franquia")
    public Map<String, Integer> getContagemPorFranquia(
            @RequestParam(value = "inicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam(value = "fim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim
    ) {
        return apiService.contagemPorFranquia(inicio, fim);
    }

    @GetMapping("/contagem-por-funcao")
    public Map<String, Integer> getContagemPorFuncao(
            @RequestParam(value = "inicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam(value = "fim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim
    ) {
        return apiService.contagemPorFuncao(inicio, fim);
    }
}
