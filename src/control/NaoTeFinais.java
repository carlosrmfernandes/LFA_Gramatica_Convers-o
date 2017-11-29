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

    public Set<String> Finais() {
        HashSet<String> finalret = new HashSet<>();

        for (String linha : x.LinhaProducao()) { // tranforma em char

            List<String> producoes = x.Producoes(linha);

            for (String producao : producoes) { //ver se a primeira e a segunda letras sao maiucula

                if (producao.length() < 2) {
                    if (linha.contains(producao)) {
                        for (String verificaFinal : producoes) {
                            if (producao.equals("$")) {
                                finalret.add(linha.substring(0, 1));
                            }
                            if (verificaFinal.contains(producao) && verificaFinal.length() > 1) {
                                finalret.add(verificaFinal.substring(1));
                            }
                        }
                    }
                }
            }
        }
        return finalret;
    }

}
