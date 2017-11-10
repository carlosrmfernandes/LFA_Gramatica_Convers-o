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
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Polo UAB
 */
public class ValidacaoGramtica {

    String prod = null;
    String naotermi = null;
    String Termi = null;
    String in = null;
    String p = null;

    void validacao(String naoterminal, String terminal, String inicial, String proucoes, String jtfProducao) {
        prod = proucoes;
        Termi = terminal;
        naotermi = naoterminal;
        in = inicial;
        p = jtfProducao;

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
        char ch = inicial.charAt(0);
        for (int iii = 0; iii < naoterminal.length(); iii++) {
            if (naoterminal.charAt(iii) == ch) {
                Validar_Preposicao();
                return;
            }
            JOptionPane.showMessageDialog(null, "O simbolo Inicail deve ser A ser a Primeira"
                    + "\nletra dos Não Terminais");
            return;
        }

    }

    public void Validar_Preposicao() {
        String i = in.toLowerCase();
        String pd = prod;
        String vasio = "&";
        String con = Termi.concat(naotermi).concat(vasio);
        pd = pd.replace("\n", "");

        HashSet hs = new HashSet();
        HashSet hss = new HashSet();

        for (int j = 0; j < con.length(); j++) {
            hs.add(con.charAt(j));
        }
        for (int j = 0; j < pd.length(); j++) {
            hss.add(pd.charAt(j));
        }

        if (hs.containsAll(hss)) {
            GramaticaMatrix gm = new GramaticaMatrix();
            gm.gamaticamatri(prod, naotermi, Termi, in,p);
        } else {
            JOptionPane.showMessageDialog(null, "Erro na entrada das Produçoes voce digitou "
                    + "\nUm caracter que nao existe nos não terminais"
                    + "\nOu nos terminais, reve a entrada");
            return;
        }

    }

}
