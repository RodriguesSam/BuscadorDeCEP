package models;

import java.util.Scanner;

public class EntradaUsuario {
    private Scanner input = new Scanner(System.in);

    public String coletarCEP() {
        System.out.println("Digite o CEP:");
        return input.nextLine();
    }

    public String coletarUF() {
        System.out.println("Digite a UF:");
        return input.nextLine();
    }

    public String coletarCidade() {
        System.out.println("Digite a cidade:");
        return input.nextLine();
    }

    public String coletarLogradouro() {
        System.out.println("Digite o logradouro:");
        return input.nextLine();
    }

}
