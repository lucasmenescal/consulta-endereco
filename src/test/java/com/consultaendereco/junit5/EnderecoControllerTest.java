package com.consultaendereco.junit5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.consultaendereco.Controllers.EnderecoController;
import com.consultaendereco.Entidades.Endereco;
import com.consultaendereco.Request.EnderecoRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EnderecoControllerTest {

    @Autowired
    private EnderecoController endereco;

    @Test
    public void testMyServiceMethod() throws JsonProcessingException {
        Endereco enderecoEsperado = new Endereco();
        enderecoEsperado.setCep("60720-000");
        enderecoEsperado.setComplemento("até 1672 - lado par");
        enderecoEsperado.setBairro("Parangaba");
        enderecoEsperado.setFrete(15.98);
        enderecoEsperado.setRua("Avenida General Osório de Paiva");
        enderecoEsperado.setCidade("Fortaleza");
        enderecoEsperado.setEstado("CE");

        EnderecoRequest request = new EnderecoRequest();
        request.setCep("60720000");
        ResponseEntity<?> response = endereco.consultaEndereco(request);

        ObjectMapper mapper = new ObjectMapper();
        String expectedJson = mapper.writeValueAsString(enderecoEsperado);
        String responseJson = mapper.writeValueAsString(response.getBody());

        assertThat(responseJson).isEqualTo(expectedJson);
        System.out.println(assertThat(responseJson).isEqualTo(expectedJson));
    }

}
