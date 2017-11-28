/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author CarlosFernandes
 */
public class NaoTeFinais {

    GramaticaMatrix x = new GramaticaMatrix();

    public Set<String> getFinais() {
        HashSet<String> pegaFinal = new HashSet<>();

        for (String linha : x.LinhaProducao()) {
            //Converte a linha em char
            List<String> producoes = x.Producoes(linha);
            //for criado para fazer toda a operacao com a linha
            for (String producao : producoes) {
                //Checa se a letra na posicao j e minuscula E checa se na posicao j+1 e maiuscula
                if (producao.length() < 2) {
                    if (linha.contains(producao)) {
                        for (String verificaFinal : producoes) {
                            if (producao.equals("$")) {
                                pegaFinal.add(linha.substring(0, 1));
                            }
                            if (verificaFinal.contains(producao) && verificaFinal.length() > 1) {
                                pegaFinal.add(verificaFinal.substring(1));
                            }
                        }
                    }
                }
            }
        }
        return pegaFinal;
    }

}
