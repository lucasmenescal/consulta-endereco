package com.consultaendereco;

import com.consultaendereco.Controllers.EnderecoController;
import com.consultaendereco.EntidadesCucumber.EnderecoTestCucumber;
import com.consultaendereco.Request.EnderecoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

@CucumberContextConfiguration
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EnderecoControllerSteps {

    @Autowired
    private EnderecoController enderecoController;

    private ResponseEntity<?> response;

    @Given("que eu envio um POST para {string} com o seguinte payload:")
    public void queEuEnvioUmPOSTParaComOSeguintePayload(String url, String payload) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        EnderecoRequest request = objectMapper.readValue(payload, EnderecoRequest.class);
        response = enderecoController.consultaEndereco(request);
    }

    @Then("a resposta deve conter o status code {int}")
    public void aRespostaDeveConterOStatusCode(int statusCode) {
        HttpStatus currentStatusCode = response.getStatusCode();
        Assertions.assertEquals(statusCode, currentStatusCode.value(), "O status code é diferente do esperado");
    }

    @Then("a resposta deve conter o seguinte JSON:")
    public void aRespostaDeveConterOSeguinteJSON(String json) throws IOException {
        EnderecoTestCucumber enderecoEsperado = new Gson().fromJson(json, EnderecoTestCucumber.class);
        ObjectMapper mapper = new ObjectMapper();
        String expectedJson = mapper.writeValueAsString(enderecoEsperado);
        String responseJson = mapper.writeValueAsString(response.getBody());

        Assertions.assertEquals(expectedJson, responseJson, "A resposta JSON é diferente do esperado");

    }

}
