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

                char a[][] = new char[10][10];
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        a[0][0] = NaoTerminais.charAt(0);
                        System.out.print(a[0][0]);
                    }
                    System.out.println("");
                }

            }
        }

    }

}
