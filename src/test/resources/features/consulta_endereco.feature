Feature: Consulta Endereço

    Scenario: Consultar endereço
        Given que eu envio um POST para "/v1/consulta-endereco" com o seguinte payload:
            """
            {
                "cep": "60720000"
            }
            """
        Then a resposta deve conter o status code 200
        And a resposta deve conter o seguinte JSON:
            """
            {
                "cep": "60720-000",
                "complemento": "até 1672 - lado par",
                "bairro": "Parangaba",
                "frete": 15.98,
                "rua": "Avenida General Osório de Paiva",
                "cidade": "Fortaleza",
                "estado": "CE"
            }
            """
