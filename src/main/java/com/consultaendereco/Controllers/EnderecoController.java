package com.consultaendereco.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.consultaendereco.utils.ViaCepApi;
import com.consultaendereco.Entidades.Endereco;
import com.consultaendereco.Entidades.Regioes;
import com.consultaendereco.Exception.NotFoundException;
import com.consultaendereco.Request.EnderecoRequest;

import com.google.gson.Gson;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;



@RestController
@RequestMapping("/v1")
public class EnderecoController {

    @PostMapping("/consulta-endereco")
    @ApiOperation(response = Endereco.class ,value = "Consulta de Endereço por CEP", notes = "Retorna informações de endereço e calcula o frete com base no CEP fornecido")
    @ApiResponse(responseCode = "200", description = "Endereço encontrado e calculado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Endereco.class)))
    public ResponseEntity<?> consultaEndereco(@RequestBody EnderecoRequest request) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "";
        if (request.getCep() == null || request.getCep() == "" || request.getCep().isBlank() == true)
            throw new NotFoundException("Favor enviar o CEP!");

        url = ViaCepApi.getUrl(request.getCep());

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        Endereco endereco = new Gson().fromJson(response.getBody(), Endereco.class);

        if (endereco.getEstado() == null || endereco.getEstado() == "" || endereco.getEstado().isBlank() == true)
            throw new NotFoundException("CEP não encontrado ou não existente: " + request.getCep());

        endereco.setFrete(Regioes.getValorFrete(Regioes.getRegiaoEndereco(endereco.getEstado())));
        return ResponseEntity.ok(endereco);
    }
}
