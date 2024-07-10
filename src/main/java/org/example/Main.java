package org.example;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame MainFrame=new JFrame();
        MainFrame.setContentPane(new Principal().PanelPrincipal);
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setTitle("Registro y Consulta");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.pack();
        MainFrame.setVisible(true);
    }
}