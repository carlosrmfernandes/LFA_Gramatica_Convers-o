/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JOptionPane;

/**
 *
 * @author Polo UAB
 */
public class ValidacaoGramtica {

    void validacao(String naoterminal, String terminal, String inicial) {
        int i = 0, j, cont = 0;
        char c, d;
        for (j = 0; j < naoterminal.length(); j++) {
            for (i = j + 1; i < naoterminal.length(); i++) {
                c = naoterminal.charAt(i);
                d = naoterminal.charAt(j);
                if (c == d) {
                    JOptionPane.showMessageDialog(null, "Existe não terminails repetidos"
                            + "\nRever a entrada dos não terminais");
                    return;
                }

            }
        }

        int ii = 0, jj, contt = 0;
        char cc, dd;
        for (jj = 0; jj < terminal.length(); jj++) {
            for (ii = jj + 1; ii < terminal.length(); ii++) {
                cc = terminal.charAt(ii);
                dd = terminal.charAt(jj);
                if (cc == dd) {
                    JOptionPane.showMessageDialog(null, "Existe terminails repetidos"
                            + "\nRever a entrada dos não terminais");
                    return;
                }

            }
        }
        
        
    }
}
