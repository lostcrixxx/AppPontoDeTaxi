package br.com.cristianomoraiscruz.pontodetaxi.controller;

public class FuelChooseController {

    //Função para calcular qual combustível é mais vantajoso
    public static String calcularVantagem(double gasolina, double alcool){
        String msg = "";
        alcool = alcool * 1.3;
        if (alcool > gasolina ){
            msg = "Abasteça com gasolina";
        }
        else if (alcool == gasolina){
            msg = "Abasteça com qualquer um, os dois estão equivalentes  ";
        }
        else if (gasolina > alcool){
            msg = "Abasteça com Etanol";
        }
        return msg;
    }
}
