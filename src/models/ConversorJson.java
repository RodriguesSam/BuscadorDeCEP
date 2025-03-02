package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversorJson {

    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public List<EnderecoViaCEP> converterParaEndereco(String respostaHttp) {
        List<EnderecoViaCEP> listaDeEnderecos = new ArrayList<>();

        if(respostaHttp.startsWith("[")) {
            EnderecoViaCEP[] arrayEnderecosJson = gson.fromJson(respostaHttp, EnderecoViaCEP[].class);
            listaDeEnderecos.addAll(Arrays.asList(arrayEnderecosJson));

        } else {
            EnderecoViaCEP enderecoJson = gson.fromJson(respostaHttp, EnderecoViaCEP.class);
            listaDeEnderecos.add(enderecoJson);
        }

        return listaDeEnderecos;
    }



}
