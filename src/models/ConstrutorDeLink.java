package models;

import java.util.List;

public class ConstrutorDeLink {

    public String montarLink (List<String> partesDoEndereco) {
        StringBuilder linkconsulta = new StringBuilder("https://viacep.com.br/ws/");

        for(String parte : partesDoEndereco) {
            linkconsulta.append(parte).append("/");
        }
        linkconsulta.append("/json");
        linkconsulta = new StringBuilder(linkconsulta.toString().replace(" ", "%20"));

        return linkconsulta.toString();
    }
}
