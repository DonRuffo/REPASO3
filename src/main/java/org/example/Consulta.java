package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Consulta {
    private JLabel NombreLabel;
    private JLabel CedulaLabel;
    private JLabel B1Label;
    private JLabel B2Label;
    private JLabel PromedioLabel;
    private JTextField NombreUsuario;
    private JTextField CedulaUsuario;
    private JTextField notaB1;
    private JTextField notaB2;
    private JTextField PromedioNotas;
    private JTextField ingresoDatos;
    private JButton buscarButton;
    public JPanel PanelConsulta;
    public Consulta() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user="root";
                String pass="Lap20112023$";
                String url="jdbc:mysql://localhost:3306/MIDB";

                try(Connection conec= DriverManager.getConnection(url,user,pass)){
                    System.out.println("Conexión exitosa");
                    String id=ingresoDatos.getText();
                    String sql="SELECT * FROM estudiantes WHERE cedula='"+id+"'";
                    Statement statement=conec.createStatement();
                    ResultSet resul=statement.executeQuery(sql);
                    while(resul.next()){
                        NombreUsuario.setText(resul.getString("nombre"));
                        CedulaUsuario.setText(resul.getString("cedula"));
                        notaB1.setText(resul.getString("b1"));
                        notaB2.setText(resul.getString("b2"));
                        double nota1=Double.parseDouble(notaB1.getText());
                        double nota2=Double.parseDouble(notaB2.getText());
                        double promedio=(nota1+nota2)/2;
                        PromedioNotas.setText(String.format("%.2f",promedio));
                    }
                    conec.close();
                }catch(SQLException v){
                    v.printStackTrace();
                }
            }
        });
    }

}
