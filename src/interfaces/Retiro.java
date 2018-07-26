package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Retiro extends JFrame implements ActionListener {

    private JLabel logo, retiro, instruccion, copy;
    private JTextField retirar;
    private JButton aceptar, salir;
    private int operacion, saldo;

    public Retiro() {

        Consulta mensajeroConsulta = new Consulta();
        saldo = mensajeroConsulta.getSaldo();

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Retiro");
        //////////////////////
        retiro = new JLabel("Retiro");
        retiro.setBounds(130, 5, 100, 30);
        retiro.setFont(new Font("Andale Mono", 1, 17));
        add(retiro);
        ////////////////////
        logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Facilita tu vida-min.png")));
        logo.setBounds(25, 35, 300, 100);
        add(logo);
        ////////////////////
        instruccion = new JLabel("Ingrese La Cantidad A Retirar");
        instruccion.setBounds(55, 135, 300, 30);
        instruccion.setFont(new Font("Andale Mono", 1, 14));
        add(instruccion);
        ///////////////////
        retirar = new JTextField();
        retirar.setBounds(25, 170, 300, 30);
        retirar.setBackground(Color.WHITE);
        retirar.setFont(new Font("Andale Mono", 1, 12));
        add(retirar);
        ///////////////////
        aceptar = new JButton("Retirar");
        aceptar.setBounds(125, 215, 100, 30);
        aceptar.setCursor(new Cursor(HAND_CURSOR));
        aceptar.setFont(new Font("Andale Mono", 1, 12));
        aceptar.setBackground(Color.WHITE);
        aceptar.addActionListener(this);
        add(aceptar);
        ///////////////////
        salir = new JButton("Salir");
        salir.setBounds(125, 250, 100, 30);
        salir.setBackground(Color.white);
        salir.setCursor(new Cursor(HAND_CURSOR));
        salir.setFont(new Font("Andale Mono", 1, 12));
        salir.addActionListener(this);
        add(salir);
        ///////////////////
        copy = new JLabel("© Copyright 2018 SerranoCorp");
        copy.setBounds(85, 300, 200, 30);
        copy.setFont(new Font("Andale Mono", 1, 12));
        add(copy);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salir) {
            this.setVisible(false);
            Menu formMenu = new Menu();
            formMenu.setVisible(true);
            formMenu.setBounds(0, 0, 350, 400);
            formMenu.setLocationRelativeTo(null);
            formMenu.setResizable(false);
        }
        if (e.getSource() == aceptar) {
            operacion = Integer.parseInt(retirar.getText());
            if (operacion > saldo) {
                JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
            }else if(operacion <= 0){
                JOptionPane.showMessageDialog(null, "Operacion NO Valida");
            }else {
                operacion = Integer.parseInt(retirar.getText());
                Consulta mensajeroConsulta = new Consulta();
                mensajeroConsulta.setSaldo(saldo - operacion);
                this.setVisible(false);
                Menu formMenu = new Menu();
                formMenu.setVisible(true);
                formMenu.setBounds(0,0,350,400);
                formMenu.setLocationRelativeTo(null);
                formMenu.setResizable(false);
                JOptionPane.showMessageDialog(null, "Retiro de $" + operacion + ", Fue Completada Con Exito"
                        + "\nTu Saldo Actual Es De: $" + (saldo - operacion));
            }
        }
    }

    public static void main(String[] args) {
        Retiro formRetiro = new Retiro();
        formRetiro.setVisible(true);
        formRetiro.setBounds(0, 0, 350, 375);
        formRetiro.setLocationRelativeTo(null);
        formRetiro.setResizable(false);
    }

}
