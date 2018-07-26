package interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Consulta extends JFrame implements ActionListener{
    
    private JLabel logo, consulta, copy;
    private JTextArea info;
    private JButton regresar;
    private String nombre;
    private static int saldo;
    
    public Consulta(){
        Inicio mensajeroInicio = new Inicio();
        nombre = mensajeroInicio.nombre;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Consulta");
        //this.getContentPane().setBackground(Color.WHITE);
        /////////////////////
        consulta = new JLabel("Consulta");
        consulta.setBounds(125,5,100,30);
        consulta.setFont(new Font("Andale Mono", 1, 17));
        add(consulta);
        ////////////////////
        logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Facilita tu vida-min.png")));
        logo.setBounds(25,35,300,100);
        add(logo);
        /////////////////////
        info = new JTextArea("\n\n                Tu Saldo Actual Es De: \n\t        $" + saldo);
        info.setBounds(25,140,300,150);
        info.setFont(new Font("Andale Mono", 1, 14));
        info.enable(false);
        add(info);
        /////////////////////
        regresar = new JButton("Salir");
        regresar.setBounds(125,300,100,30);
        regresar.setFont(new Font("Andale Mono", 1, 14));
        regresar.setCursor(new Cursor(HAND_CURSOR));
        regresar.setBackground(Color.WHITE);
        regresar.addActionListener(this);
        add(regresar);
        //////////////////////
        copy = new JLabel("© Copyright 2018 SerranoCorp");
        copy.setBounds(85,340,200,30);
        copy.setFont(new Font("Andale Mono", 1, 12));
        add(copy);
        ///////////////////////
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == regresar) {
            this.setVisible(false);
            Menu formMenu = new Menu();
            formMenu.setVisible(true);
            formMenu.setBounds(0,0,350,400);
            formMenu.setLocationRelativeTo(null);
            formMenu.setResizable(false);
        }
    }
    
    public static void main(String[] args){
        Consulta formConsulta = new Consulta();
        formConsulta.setVisible(true);
        formConsulta.setBounds(0,0,350,400);
        formConsulta.setLocationRelativeTo(null);
        formConsulta.setResizable(false);
    }
    
    public int getSaldo(){
        return saldo;
    }
    
    public void setSaldo(int saldo){
        this.saldo = saldo;
    }
    
}
