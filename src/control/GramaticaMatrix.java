/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import visao.JanelaPrincipal;

/**
 *
 * @author Polo UAB
 */
public class GramaticaMatrix {

    HashSet naoterminais = new HashSet();
    HashSet terminais = new HashSet();
    String inn = null;
    static String pp = "";

    private JanelaPrincipal janelaprincipal;
    String estado = "";

    public Set<String> Terminais() {
        return LinhaProducao()
                .stream()
                .map(s -> Producoes(s))
                .flatMap(List::stream)
                .filter(s -> !s.equalsIgnoreCase("$"))
                .map(s -> s.substring(0, 1))
                .collect(Collectors.toSet());
    }

    public Set<String> NaoTerminais() {
        return LinhaProducao()//recebe as linhas
                .stream()//pega uma linha por vez
                .map(linha -> linha.substring(0, 1))//pega o primeiro carácter de cada linha
                .collect(Collectors.toSet());//passa cada carácter para um set
    }

    boolean gamaticamatri(String prod, String naotermi, String Termi, String in, String p) {
        pp = p;
        inn = in;
        for (int j = 0; j < prod.length(); j++) {

            if (prod.charAt(j) == 'a' || prod.charAt(j) == 'b' || prod.charAt(j) == 'c' || prod.charAt(j) == 'd' || prod.charAt(j) == 'e' || prod.charAt(j) == 'f' || prod.charAt(j) == 'g' || prod.charAt(j) == 'h' || prod.charAt(j) == 'i' || prod.charAt(j) == 'j' || prod.charAt(j) == 'k' || prod.charAt(j) == 'l' || prod.charAt(j) == 'm' || prod.charAt(j) == 'n' || prod.charAt(j) == 'o' || prod.charAt(j) == 'p' || prod.charAt(j) == 'q' || prod.charAt(j) == 'r' || prod.charAt(j) == 's' || prod.charAt(j) == 't' || prod.charAt(j) == 'u' || prod.charAt(j) == 'v' || prod.charAt(j) == 'x' || prod.charAt(j) == 'y' || prod.charAt(j) == 'w' || prod.charAt(j) == 'z') {
                terminais.add(prod.charAt(j));
            } else if (prod.charAt(j) == '$') {

            } else {
                naoterminais.add(prod.charAt(j));
            }

        }
        return false;
    }

    public List<String> LinhaProducao() {
        return Arrays.asList(this.pp.split("\n"));
    }

    public List<String> Producoes(String linha) {
        return Arrays.asList(linha.substring(2).split("[|]"));
    }

    String[][] MatrixApresentacao() {

        List<String> terminais = new ArrayList<>(Terminais());
        List<String> nTerminais = new ArrayList<>(NaoTerminais());
        List<String> linhas = LinhaProducao();

        String[][] matriz = new String[nTerminais.size()][terminais.size() + 1];

        for (int i = 0; i < nTerminais.size(); i++) {
            matriz[i][0] = verificaEstado(nTerminais.get(i));
            for (int j = 1; j < terminais.size() + 1; j++) {
                for (String producao : Producoes(linhas.get(i))) {
                    if (producao.length() > 1 && producao.contains(terminais.get(j - 1))) {
                        if (matriz[i][j] == null) {
                            matriz[i][j] = "";
                        }
                        if (matriz[i][j].length() > 0) {
                            matriz[i][j] += ",";
                        }
                        matriz[i][j] += producao.substring(1);
                    }
                }
            }
        }
        
        return matriz;
        
    }

    public String getTransition(String terminal, String naoterminal) {

        List<String> terminais = new ArrayList<>(Terminais());
        List<String> nTerminais = new ArrayList<>(NaoTerminais());
        List<String> linhas = LinhaProducao();
        String tran = "";
        for (int i = 0; i < nTerminais.size(); i++) {
            if (nTerminais.get(i) == naoterminal) {
                for (int j = 0; j < terminais.size(); j++) {
                    if (terminais.get(j) == terminal) {
                        return MatrixApresentacao()[i][j];
                    }
                }
            }
        }
        return tran;
    }

    private String verificaEstado(String nTerminal) {
        NaoTeFinais nt = new NaoTeFinais();

        if (nt.getFinais().contains(nTerminal)) {
            estado += "#";
        }

        return estado + nTerminal;
    }

}
