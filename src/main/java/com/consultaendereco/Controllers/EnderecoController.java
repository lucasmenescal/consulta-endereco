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

@RestController
@RequestMapping("/v1")
public class EnderecoController {

    @PostMapping("/consulta-endereco")
    public ResponseEntity<?> consultaEndereco(@RequestBody EnderecoRequest request) {
        String cep = request.getCep();
        RestTemplate restTemplate = new RestTemplate();
        String url = "";
        if (cep == null || cep == "" || cep.isBlank() == true)
            throw new NotFoundException("CEP não encontrado: " + cep);

        url = ViaCepApi.getUrl(cep);

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        Endereco endereco = new Gson().fromJson(response.getBody(), Endereco.class);

        if (endereco.getEstado() == null || endereco.getEstado() == "" || endereco.getEstado().isBlank() == true)
            throw new NotFoundException("CEP não encontrado ou não existente: " + cep);

        endereco.setFrete(Regioes.getValorFrete(Regioes.getRegiaoEndereco(endereco.getEstado())));
        return ResponseEntity.ok(endereco);
    }
}
