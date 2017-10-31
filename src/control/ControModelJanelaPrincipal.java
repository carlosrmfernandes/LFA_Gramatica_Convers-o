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

            System.out.println("Não Terminais :" + jtfnaoterminais + "\n"
                    + "Terminais :" + jtfterminais + "\n"
                    + "Simbolo Inicial :" + jtfsiboloIncial + "\n"
                    + "Producao :" + jtfProducao);

        }

    }

}
