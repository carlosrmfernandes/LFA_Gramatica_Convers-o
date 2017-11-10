/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import exception.Excecao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ModelJanelaPrincipal;
import visao.JanelaPrincipal;

/**
 *
 * @author comp9
 */
public class ControModelJanelaPrincipal implements ActionListener {

    private ModelJanelaPrincipal modeljanelaprincipal;
    private JanelaPrincipal janelaprincipal;
    private String jtfProducao, jtfnaoterminais, jtfsiboloIncial, jtfterminais;

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
            

            String producoes = "([A-Z])|"
                    + "([A-Z]=)|"
                    + "([A-Z]=[a-z][A-Z]?)|"
                    + "([A-Z]=([a-z][A-Z]?[|])*)|"
                    + "(([A-Z]=([a-z][A-Z]?[|])*([&]|([a-z][A-Z]?)))\n?)*";

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
                vd.validacao(NT, TN, SI, PD_aux,jtfProducao);

            } else {
                JOptionPane.showMessageDialog(null, "Erro de Sinatxe"
                        + "\nExemplo : "
                        + "\nNão Terminais : A,B,C"
                        + "\n Terminais : a,b,c,d"
                        + "\n Produções :"
                        + "\n S = aA"
                        + "\n A = a|bB"
                        + "\n B = b|d"
                        + "\n C = bB|&");
            }
        }

    }

}
