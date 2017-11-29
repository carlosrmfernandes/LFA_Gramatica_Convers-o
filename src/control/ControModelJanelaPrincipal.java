/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exception.Excecao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ModelJanelaPrincipal;
import model.modelreconhecer;
import visao.JanelaPrincipal;

/**
 *
 * @author comp9
 */
public class ControModelJanelaPrincipal implements ActionListener {

    private ModelJanelaPrincipal modeljanelaprincipal;
    private JanelaPrincipal janelaprincipal;
    private String jtfProducao, jtfnaoterminais, jtfsiboloIncial, jtfterminais;
    private String senteca;

    public ControModelJanelaPrincipal(JanelaPrincipal janelaprincipal) {
        this.janelaprincipal = janelaprincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("geraautomato".equals(e.getActionCommand())) {

            try {
                modeljanelaprincipal = janelaprincipal.modelojanelaprincipal();
            } catch (Excecao ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }
            jtfnaoterminais = modeljanelaprincipal.getJtfnaoterminais();
            jtfterminais = modeljanelaprincipal.getJtfterminais();
            jtfsiboloIncial = modeljanelaprincipal.getJtfsiboloIncial();
            jtfProducao = modeljanelaprincipal.getJtfProducao();

            String producoes = "([A-Z]=?)|"
                    + "([A-Z]=[a-z][A-Z]?)|"
                    + "([A-Z]=([a-z][A-Z]?[|])*)|"
                    + "(([A-Z]=([a-z][A-Z]?[|])*([$]|([a-z][A-Z]?)))\n?)*";

            String Terminais = "([a-z])|"
                    + "([a-z],)|"
                    + "([a-z],[a-z]*)|"
                    + "([a-z],([a-z]?)*)|"
                    + "([a-z],([a-z],[a-z]?)*)";

            String NaoTerminais = "([A-Z])|"
                    + "([A-Z],)|"
                    + "([A-Z],[A-Z]*)|"
                    + "([A-Z],([A-Z]?)*)|"
                    + "([A-Z],([A-Z],[A-Z]?)*)";
            String SimboloInicial = "([A-Z])";

            if (jtfnaoterminais.matches(NaoTerminais) && jtfterminais.matches(Terminais) && jtfProducao.matches(producoes) && jtfsiboloIncial.matches(SimboloInicial)) {
                String NT = jtfnaoterminais.replace(",", "");
                String TN = jtfterminais.replace(",", "");
                String SI = jtfsiboloIncial;
                String PD = jtfProducao.replace("=", "");
                String PD_aux = PD.replace("|", "");

                ValidacaoGramtica vd = new ValidacaoGramtica();
                vd.validacao(NT, TN, SI, PD_aux, jtfProducao);

                GramaticaMatrix x = new GramaticaMatrix();
                List<String> terminais = new ArrayList<>();
                terminais.addAll(x.Terminais());
                terminais.add(0, "");

                // System.out.println(jtfsiboloIncial);
                //System.out.println(x.MatrixApresentacao().toString());
                DefaultTableModel mod = new DefaultTableModel(x.MatrixApresentacao(), terminais.toArray(new String[terminais.size()]));
                janelaprincipal.jTable1.setModel(mod);

            } else {
                JOptionPane.showMessageDialog(null, "Erro de Sinatxe"
                        + "\nExemplo : "
                        + "\nNão Terminais : A,B,C"
                        + "\n Terminais : a,b,c,d"
                        + "\n Produções :"
                        + "\n S = aA"
                        + "\n A = a|bB"
                        + "\n B = b|d"
                        + "\n C = bB|$");

            }

        }
        if ("reconhecer".equals(e.getActionCommand())) {

            try {
                modeljanelaprincipal = janelaprincipal.modelojanelaprincipal1();
            } catch (Excecao ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }
            senteca = modeljanelaprincipal.getSenteca();

            System.out.println(Reconhecer());

        }

    }

    boolean Reconhecer() {
        NaoTeFinais fim = new NaoTeFinais();
        GramaticaMatrix x = new GramaticaMatrix();

        String Inicial = jtfsiboloIncial;
        String ConFinal = fim.getFinais().toString();
        String Caracter = senteca;

        for (int i = 0; i < Caracter.length(); i++) {
            if (Inicial == "") {
                return false;
            }
            Inicial = x.getTransition(Caracter.substring(i, i + 1), Inicial);

        }

        NaoTeFinais f = new NaoTeFinais();
        
        return f.getFinais().contains(Inicial);

    }

    

}
