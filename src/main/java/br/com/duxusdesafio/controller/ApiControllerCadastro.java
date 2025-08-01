package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.dto.*;
import br.com.duxusdesafio.mapper.*;
import br.com.duxusdesafio.model.*;
import br.com.duxusdesafio.service.ApiCadastroService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/cadastro")
public class ApiCadastroController {

    private final ApiCadastroService apiCadastroService;
    private final TimeMapper timeMapper = new TimeMapper();
    private final IntegranteMapper integranteMapper = new IntegranteMapper();

    public ApiCadastroController(ApiCadastroService apiCadastroService) {
        this.apiCadastroService = apiCadastroService;
    }

    @PostMapping("/time")
    public TimeGetDTO cadastrarTime(@RequestBody TimePostDTO timePostDTO) {
        Time novoTime = apiCadastroService.cadastrarTime(timePostDTO.getData());
        return timeMapper.toGetDto(novoTime);
    }

    @PostMapping("/time/{data}/integrante")
    public IntegranteGetDTO adicionarIntegranteAoTime(
            @PathVariable("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
            @RequestBody IntegrantePostDTO integrantePostDTO
    ) {
        Integrante integrante = apiCadastroService.adicionarIntegranteAoTime(data, integrantePostDTO);
        return integranteMapper.toGetDto(integrante);
    }
}
