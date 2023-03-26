package com.consultaendereco.utils;

public class ViaCepApi {
    private static String Url = "https://viacep.com.br/ws/";

    public static String getUrl(String cep) {
        return Url + cep + "/json/";
    }
}
