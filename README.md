@lucasmenescal

# Consulta Endereço via CEP

**O desafio é construir uma API REST de consulta de endereço e e cálculo de frete para
um determinado CEP. O contrato da API deve ser conforme especificado abaixo:**

```json
POST v1/consulta-endereco
REQUEST
{
"cep": "01001000"
}
RESPONSE HTTP 200
{
"cep": "01001-000",
"rua": "Praça da Sé",
"complemento": "lado ímpar",
"bairro": "Sé",
"cidade": "São Paulo",
"estado": "SP",
"frete": 7.85
}
```
## Detalhes
```
Para a busca do endereço do CEP, você deve consultar a API VIA CEP, conforme a
documentação https://viacep.com.br/. O valor do frete é fixo de acordo com as regiões
do Brasil: Sudeste (R$ 7,85), Centro-Oeste (R$ 12,50), Nordeste (R$ 15,98), Sul (R$
17,30) e Norte (R$ 20,83). O CEP é obrigatório e pode ser passado com ou sem máscara
na entrada e se o CEP não for encontrado uma mensagem informativa deve ser retornada
para o cliente.
```

### Requisitos

```
> Java 11
> Spring boot
> API REST Template
> Documentação Swagger
> Testes unitários JUnit5
> Testes automatizados utilizando cucumber
```

