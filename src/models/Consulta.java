package models;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Consulta {

    private ExclusionStrategy excluirCampoErro = new ExclusionStrategy() {
        @Override
        public boolean shouldSkipField(FieldAttributes campo) {
            return campo.getName().startsWith("erro");
        }

        @Override
        public boolean shouldSkipClass(Class<?> aClass) {
            return false;
        }
    };

    private Gson gson = new GsonBuilder()
            .addSerializationExclusionStrategy(excluirCampoErro)
            .setPrettyPrinting()
            .create();


    public List<String> coletarAtributos(String escolha) {
        // Usuário escolhe se deseja consultar por CEP ou por endereco.
        List<String> atributos = new ArrayList<>();

        EntradaUsuario entradaUsuario = new EntradaUsuario();
        Validador validador = new Validador();

        if (validador.entradaValida(escolha)) {

            switch (escolha) {
                case "1":
                    String cep = entradaUsuario.coletarCEP();

                    if (validador.cepValido(cep)) {
                        atributos.add(cep);
                    } else {
                        System.out.println("CEP em formato inválido!");
                    }
                    break;

                case "2":
                    String uf = entradaUsuario.coletarUF();

                    if (validador.ufValida(uf)) {
                        atributos.add(uf);
                        atributos.add(entradaUsuario.coletarCidade());
                        atributos.add(entradaUsuario.coletarLogradouro());

                    } else {
                        System.out.println("A UF deve conter apenas 2 dígitos.");
                    }
                    break;

                case "3":
                    System.out.println("Programa encerrado. Até a próxima!");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;

            }
        } else {
            System.out.println("Entrada inválida!");
        }


        return atributos;
    }

    public List<EnderecoViaCEP> criaObjEndereco(String respostaHttp) {
        ConversorJson conversor = new ConversorJson();
        return conversor.converterParaEndereco(respostaHttp);
    }


    public String pegaJson(String link) {
        ServicoHttp service = new ServicoHttp();
        return service.consultar(link);
    }

    public void imprimirConsulta(List<EnderecoViaCEP> resultados, String nomeDoArquivo) throws IOException {
        FileWriter escreverParaJson = new FileWriter(nomeDoArquivo + ".json");

        escreverParaJson.write(gson.toJson(resultados));

        escreverParaJson.close();
    }

}