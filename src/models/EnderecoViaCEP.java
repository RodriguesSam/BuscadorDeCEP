package models;

public record EnderecoViaCEP(String cep, String logradouro, String bairro, String localidade, String uf, String estado, String regiao, String ddd, boolean erro) {
    @Override
    public String toString() {
        return "CEP: " + cep + "\n" + logradouro + " - " + bairro + "\n" +
                localidade + ", " + uf + "\n" + estado + "\n";
    }
}
