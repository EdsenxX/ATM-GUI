package interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener{
    
    private JButton consulta, deposito, retiro, salir;
    private JLabel logo, menu, copy;
    private String nombre;
    
    public Menu(){
        
        Inicio mensajeroInicio = new Inicio();
        nombre = mensajeroInicio.nombre;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bienvenido " + nombre);
        this.getContentPane().setBackground(Color.WHITE);
        ////////////////////
        menu = new JLabel("Menu De Opciones");
        menu.setBounds(100,5,150,30);
        menu.setFont(new Font("Andale Mono", 1, 17));
        add(menu);
        ////////////////////
        logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Facilita tu vida-min.png")));
        logo.setBounds(25,35,300,100);
        add(logo);
        /////////////////////
        consulta = new JButton();
        consulta.setBounds(16,150,100,100);
        consulta.setBackground(Color.white);
        consulta.setCursor(new Cursor(HAND_CURSOR));
        consulta.setIcon(new ImageIcon(getClass().getResource("/Imagenes/consulta.png")));
        consulta.addActionListener(this);
        add(consulta);
        //////////////////////
        retiro = new JButton();
        retiro.setBounds(122,150,100,100);
        retiro.setBackground(Color.white);
        retiro.setCursor(new Cursor(HAND_CURSOR));
        retiro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/retiro.png")));
        retiro.addActionListener(this);
        add(retiro);
        ///////////////////////
        deposito = new JButton();
        deposito.setBounds(230,150,100,100);
        deposito.setBackground(Color.white);
        deposito.setCursor(new Cursor(HAND_CURSOR));
        deposito.setIcon(new ImageIcon(getClass().getResource("/Imagenes/deposito.png")));
        deposito.addActionListener(this);
        add(deposito);
        ////////////////////////
        salir = new JButton("Salir");
        salir.setBounds(122,270,100,30);
        salir.setCursor(new Cursor(HAND_CURSOR));
        salir.setBackground(Color.WHITE);
        salir.addActionListener(this);
        add(salir);
        //////////////////////
        copy = new JLabel("© Copyright 2018 SerranoCorp");
        copy.setBounds(85,340,200,30);
        copy.setFont(new Font("Andale Mono", 1, 12));
        add(copy);
        //////////////////////
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == salir) {
            this.setVisible(false);
            Inicio formInicio = new Inicio();
            formInicio.setVisible(true);
            formInicio.setBounds(0,0,350,325);
            formInicio.setLocationRelativeTo(null);
            formInicio.setResizable(false); 
        }
        if (e.getSource() == consulta) {
            this.setVisible(false);
            Consulta formConsulta = new Consulta();
            formConsulta.setVisible(true);
            formConsulta.setBounds(0,0,350,400);
            formConsulta.setLocationRelativeTo(null);
            formConsulta.setResizable(false);
        }
        if (e.getSource() == deposito) {
            this.setVisible(false);
            Deposito formDeposito = new Deposito();
            formDeposito.setVisible(true);
            formDeposito.setBounds(0,0,350,375);
            formDeposito.setLocationRelativeTo(null);
            formDeposito.setResizable(false);
        }
        if (e.getSource() == retiro) {
            this.setVisible(false);
            Retiro formRetiro = new Retiro();
            formRetiro.setVisible(true);
            formRetiro.setBounds(0,0,350,375);
            formRetiro.setLocationRelativeTo(null);
            formRetiro.setResizable(false);
        }
    }
    
    public static void main(String[] args){
        Menu formMenu = new Menu();
        formMenu.setVisible(true);
        formMenu.setBounds(0,0,350,400);
        formMenu.setLocationRelativeTo(null);
        formMenu.setResizable(false);
        
    }
    
}
