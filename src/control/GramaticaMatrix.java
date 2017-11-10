/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Polo UAB
 */
public class GramaticaMatrix {

    ValidacaoGramtica vald = new ValidacaoGramtica();

    public List<String> DividirLinha() {
        return Arrays.asList(vald.prod.split("\n"));
    }

}
