package models;


import java.util.InputMismatchException;
import java.util.List;

public class Validador {

    public boolean entradaValida(String entrada){

        try {
            Integer.parseInt(entrada);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean cepValido(String cep) {
        cep = cep.replace("-", "");

        try {
            Integer.parseInt(cep);
        } catch (NumberFormatException e){
            return false;
        }

        return cep.length() == 8;
    }

    public boolean ufValida(String uf) {
        return uf.length() == 2;
    }

    public boolean retornouErro(List<EnderecoViaCEP> enderecoRetornado) {

        return enderecoRetornado.isEmpty() || enderecoRetornado.getFirst().erro();
    }

}
