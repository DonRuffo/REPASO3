package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Datos {
    private JTextField Nota1Usuario;
    private JTextField NombreUsuario;
    private JTextField CedulaUsuario;
    private JTextField Nota2Usuario;
    private JButton registrarButton;
    private JLabel PromedioLabel;
    public JPanel mainPanel;

    public Datos() {
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user="root";
                String pass="Lap20112023$";
                String url="jdbc:mysql://localhost:3306/MIDB";

                String sql="INSERT INTO estudiantes (cedula,nombre,b1,b2) VALUES(?,?,?,?)";

                try(Connection conec= DriverManager.getConnection(url,user,pass)){
                    System.out.println("Conexión Exitosa");
                    double nota1=Double.parseDouble(Nota1Usuario.getText());
                    double nota2=Double.parseDouble(Nota2Usuario.getText());
                    PreparedStatement pst=conec.prepareStatement(sql);
                    pst.setString(1,CedulaUsuario.getText());
                    pst.setString(2,NombreUsuario.getText());
                    pst.setDouble(3,nota1);
                    pst.setDouble(4,nota2);
                    double promedio=(nota1+nota2)/2;
                    PromedioLabel.setText("Promedio: "+String.format("%.2f",promedio));

                    int resultado=pst.executeUpdate();
                    if(resultado>0){
                        JOptionPane.showMessageDialog(null,"Registro exitoso","Información",JOptionPane.INFORMATION_MESSAGE);
                    }
                    pst.close();
                }catch (SQLException v){
                    v.printStackTrace();
                }
            }
        });
    }
}
