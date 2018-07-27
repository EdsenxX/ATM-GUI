package interfaces;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Deposito extends JFrame implements ActionListener {
    
    private JLabel logo, deposito, instruccion, copy;
    private JTextField depositar;
    private JButton aceptar, salir;
    private int operacion, saldo;
    
    public Deposito(){
        
        Consulta mensajeroConsulta = new Consulta();
        saldo = mensajeroConsulta.getSaldo();
        
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Deposito");
        /////////////////////
        deposito = new JLabel("Deposito");
        deposito.setBounds(130,5,100,30);
        deposito.setFont(new Font("Andale Mono", 1, 17));
        add(deposito);
        ////////////////////
        logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Facilita tu vida-min.png")));
        logo.setBounds(25,35,300,100);
        add(logo);
        ////////////////////
        ///////////////////
        instruccion = new JLabel("Ingrese La Cantidad A Depositar");
        instruccion.setBounds(60,135,300,30);
        instruccion.setFont(new Font("Andale Mono", 1, 14));
        add(instruccion);
        ///////////////////
        depositar = new JTextField();
        depositar.setBounds(25,170,300,30);
        depositar.setBackground(Color.WHITE);
        depositar.setFont(new Font("Andale Mono", 1, 12));
        add(depositar);
        ///////////////////
        aceptar = new JButton("Depositar");
        aceptar.setBounds(125,215,100,30);
        aceptar.setCursor(new Cursor(HAND_CURSOR));
        aceptar.setFont(new Font("Andale Mono", 1, 12));
        aceptar.setBackground(Color.WHITE);
        aceptar.addActionListener(this);
        add(aceptar);
        ///////////////////
        salir = new JButton("Salir");
        salir.setBounds(125,250,100,30);
        salir.setBackground(Color.white);
        salir.setCursor(new Cursor(HAND_CURSOR));
        salir.setFont(new Font("Andale Mono", 1, 12));
        salir.addActionListener(this);
        add(salir);
        ///////////////////
        copy = new JLabel("© Copyright 2018 SerranoCorp");
        copy.setBounds(85,300,200,30);
        copy.setFont(new Font("Andale Mono", 1, 12));
        add(copy);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == salir) {
            this.setVisible(false);
            Menu formMenu = new Menu();
            formMenu.setVisible(true);
            formMenu.setBounds(0,0,350,400);
            formMenu.setLocationRelativeTo(null);
            formMenu.setResizable(false);
        }
        if (e.getSource() == aceptar) {
            
            operacion = Integer.parseInt(depositar.getText());
            
            if (operacion >0 && operacion <= 999999999) {
                Consulta mensajeroConsulta = new Consulta();
                mensajeroConsulta.setSaldo(saldo + operacion);
                this.setVisible(false);
                Menu formMenu = new Menu();
                formMenu.setVisible(true);
                formMenu.setBounds(0,0,350,400);
                formMenu.setLocationRelativeTo(null);
                formMenu.setResizable(false);
                JOptionPane.showMessageDialog(null, "Deposito de $" + operacion + ", Fue Completada Con Exito "
                + "\nTu Saldo Actual Es De: $" + (saldo + operacion));
            }else if(operacion <= 0){
                JOptionPane.showMessageDialog(null, "Cantidad no Valida");
            }else if(operacion > 999999999){
                JOptionPane.showMessageDialog(null, "La Cantidad Maxina Que Puede Depositar es $999999999");
            }
            
        }
    }
    
    public static void main(String[] args){
        Deposito formDeposito = new Deposito();
        formDeposito.setVisible(true);
        formDeposito.setBounds(0,0,350,375);
        formDeposito.setLocationRelativeTo(null);
        formDeposito.setResizable(false);
    }
    
}
