
import models.ConstrutorDeLink;
import models.Consulta;
import models.EnderecoViaCEP;
import models.Validador;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String menuOpcoes = """
            \nSelecione uma opção:
            
            1. Consulta por CEP
            2. Consulta por endereço
            3. Sair
            """;

    private Consulta consulta;
    private Validador validador;
    private Scanner entrada;
    private int contadorDeConsultas;


    public Main(){
        this.consulta = new Consulta();
        this.validador = new Validador();
        this.entrada = new Scanner(System.in);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Main programa = new Main();
        programa.executar();
    }


    public void executar() throws IOException {
        String escolha;

        do {
            mostrarMenu();
            escolha = entrada.nextLine();

            if (escolha.equals("3")) {
                System.out.println("Programa encerrado.");
                break;
            }

            processarEscolha(escolha);

        } while(true);

        entrada.close();
    }

    private void mostrarMenu() {
        System.out.println(menuOpcoes);
    }

    private void processarEscolha(String escolha) throws IOException {
        List<String> atributos = consulta.coletarAtributos(escolha);

        if (!atributos.isEmpty()) {
            ConstrutorDeLink contrutor = new ConstrutorDeLink();

            String link = contrutor.montarLink(atributos);
            String respostaHttp = consulta.pegaJson(link);

            List<EnderecoViaCEP> enderecos = consulta.criaObjEndereco(respostaHttp);

            if(validador.retornouErro(enderecos)) {
                System.out.println("A pesquisa não retornou resultados...");

            } else {
                exibirResultados(enderecos);
                salvarResultados(enderecos);
            }
        }
    }

    private void exibirResultados(List<EnderecoViaCEP> enderecos) {
        System.out.printf("\n%d resultado(s) encontrado(s): \n\n",enderecos.size());

        for(EnderecoViaCEP endereco : enderecos) {
            System.out.println(endereco);
        }
    }

    private void salvarResultados(List<EnderecoViaCEP> enderecos) throws IOException {
        String diretorioAtual = System.getProperty("user.dir");

        contadorDeConsultas++;

        String nomeDoArquivo = "ConsultaDeEnderecos_" +  contadorDeConsultas;

        System.out.println("Pressione enter para salvar os resultados em \"" + nomeDoArquivo + ".json\"..");
        entrada.nextLine();

        consulta.imprimirConsulta(enderecos, nomeDoArquivo);

        System.out.println("Consulta salva em \"" + diretorioAtual + "\\" + nomeDoArquivo + ".json\"");
        System.out.println("Pressione Enter para continuar ou digite \"Sair\" para encerrar o programa..");
        String escolha = entrada.nextLine().toLowerCase();

        if(escolha.equals("sair")){
            System.out.println("Programa encerrado.");
            System.exit(0);
        }
    }

}
