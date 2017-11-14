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

/**
 *
 * @author Polo UAB
 */
public class GramaticaMatrix {

    HashSet naoterminais = new HashSet();
    HashSet terminais = new HashSet();
    String pp = null;
    String inn = null;

    void gamaticamatri(String prod, String naotermi, String Termi, String in, String p) {
        pp = p;
        inn = in;
        for (int j = 0; j < prod.length(); j++) {

            if (prod.charAt(j) == 'a' || prod.charAt(j) == 'b' || prod.charAt(j) == 'c' || prod.charAt(j) == 'd' || prod.charAt(j) == 'e' || prod.charAt(j) == 'f' || prod.charAt(j) == 'g' || prod.charAt(j) == 'h' || prod.charAt(j) == 'i' || prod.charAt(j) == 'j' || prod.charAt(j) == 'k' || prod.charAt(j) == 'l' || prod.charAt(j) == 'm' || prod.charAt(j) == 'n' || prod.charAt(j) == 'o' || prod.charAt(j) == 'p' || prod.charAt(j) == 'q' || prod.charAt(j) == 'r' || prod.charAt(j) == 's' || prod.charAt(j) == 't' || prod.charAt(j) == 'u' || prod.charAt(j) == 'v' || prod.charAt(j) == 'x' || prod.charAt(j) == 'y' || prod.charAt(j) == 'w' || prod.charAt(j) == 'z') {
                terminais.add(prod.charAt(j));
            } else if (prod.charAt(j) == '&') {

            } else {
                naoterminais.add(prod.charAt(j));
            }

        }
        System.out.println(p);
        System.out.println(in);
        System.out.print(naoterminais);
        System.out.println(terminais);
        //System.out.println(getTabelaMatriz());

    }

//    public List<String> getLinhas() {
//        return Arrays.asList(this.pp.split("\n"));
//    }
//
//    private String verificaEstado(String nTerminal) {
//        String estado = "";
//
//        if (this.inn.equals(inn)) {
//            estado += "->";
//        }
//
//        if (getFinais().contains(nTerminal)) {
//            estado += "*";
//        }
//
//        return estado + nTerminal;
//    }
//
//    public List<String> getProducoes(String linha) {
//        //System.out.println(linha);
//        return Arrays.asList(linha.substring(2).split("[|]"));
//    }
//
//    public Set<String> getFinais() {
//        HashSet<String> pegaFinal = new HashSet<>();
//
//        for (String linha : this.getLinhas()) {
//            //Converte a linha em char
//            List<String> producoes = this.getProducoes(linha);
//            //for criado para fazer toda a operacao com a linha
//            for (String producao : producoes) {
//                //Checa se a letra na posicao j e minuscula E checa se na posicao j+1 e maiuscula
//                if (producao.length() < 2) {
//                    if (linha.contains(producao)) {
//                        for (String verificaFinal : producoes) {
//                            if (producao.equals("&")) {
//                                pegaFinal.add(linha.substring(0, 1));
//                            }
//                            if (verificaFinal.contains(producao) && verificaFinal.length() > 1) {
//                                pegaFinal.add(verificaFinal.substring(1));
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return pegaFinal;
//    }
//
//    private String[][] getTabelaMatriz() {
//        List<String> terminais = new ArrayList<>(this.terminais);
//        List<String> nTerminais = new ArrayList<>(this.naoterminais);
//        List<String> linhas = getLinhas();
//
//        String[][] matriz = new String[nTerminais.size()][terminais.size() + 1];
//        for (int i = 0; i < nTerminais.size(); i++) {
//            matriz[i][0] = verificaEstado(nTerminais.get(i));
//            for (int j = 1; j < terminais.size() + 1; j++) {
//                for (String producao : getProducoes(linhas.get(i))) {
////                    if (producao.length() > 1 && producao.contains(terminais.get(j - 1))) {
////                        if (matriz[i][j] == null) {
////                            matriz[i][j] = "";
////                        }
////                        if (matriz[i][j].length() > 0) {
////                            matriz[i][j] += ",";
////                        }
////                        matriz[i][j] += producao.substring(1);
////                    }
//                }
//            }
//        }
//        return matriz;
//    }
}
