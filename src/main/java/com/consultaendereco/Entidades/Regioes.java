package com.consultaendereco.Entidades;

public class Regioes {

    public static String getRegiaoEndereco(String estado) {
        String regiao = "";
        if (estado.equals("AC") || estado.equals("AM") || estado.equals("AP") || estado.equals("PA")
                || estado.equals("RO") || estado.equals("RR") || estado.equals("TO")) {
            regiao = "Norte";
        } else if (estado.equals("AL") || estado.equals("BA") || estado.equals("CE") || estado.equals("MA")
                || estado.equals("PB") || estado.equals("PE") || estado.equals("PI") || estado.equals("RN")
                || estado.equals("SE")) {
            regiao = "Nordeste";
        } else if (estado.equals("DF") || estado.equals("GO") || estado.equals("MT") || estado.equals("MS")) {
            regiao = "Centro-Oeste";
        } else if (estado.equals("ES") || estado.equals("MG") || estado.equals("RJ") || estado.equals("SP")) {
            regiao = "Sudeste";
        } else if (estado.equals("PR") || estado.equals("RS") || estado.equals("SC")) {
            regiao = "Sul";
        }
        return regiao;
    }

    public static Double getValorFrete(String regiao) {
        Double frete = 0.0;
        if (regiao.equals("Norte")) {
            return frete = 20.83;
        } else if (regiao.equals("Nordeste")) {
            return frete = 15.98;
        } else if (regiao.equals("Sudeste")) {
            return frete = 7.85;
        } else if (regiao.equals("Sul")) {
            return frete = 17.30;
        } else if (regiao.equals("Centro-Oeste")) {
            return frete = 12.50;
        }
        return frete;
    }
}
