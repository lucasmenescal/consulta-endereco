Feature: Consulta Endereço

    Scenario: Consultar endereço
        Given que eu envio um POST para "/v1/consulta-endereco" com o seguinte payload:
            """
            {
                "cep": "01001000"
            }
            """
        Then a resposta deve conter o status code 200
        And a resposta deve conter o seguinte JSON:
            """
            {
                "cep": "01001-000",
                "rua": "Praça da Sé",
                "complemento": "lado ímpar",
                "bairro": "Sé",
                "cidade": "São Paulo",
                "estado": "SP",
                "frete": 7.85
            }
            """
