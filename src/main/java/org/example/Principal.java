package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {
    private JButton registrarButton;
    private JButton consultarButton;
    public JPanel PanelPrincipal;

    public Principal() {
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1 = new JFrame();
                frame1.setTitle("Registrar Estudiante");
                frame1.setContentPane(new Datos().mainPanel);
                frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame1.pack();
                frame1.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(registrarButton)).dispose();
            }
        });
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent c) {
                JFrame frame2 = new JFrame();
                frame2.setTitle("Consultar Estudiante");
                frame2.setContentPane(new Consulta().PanelConsulta);
                frame2.setLocationRelativeTo(null);
                frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame2.pack();
                frame2.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(consultarButton)).dispose();
            }
        });
    }
}
