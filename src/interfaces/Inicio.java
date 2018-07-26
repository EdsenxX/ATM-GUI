package interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Inicio extends JFrame implements ActionListener{
    
    private JLabel logo, instruccion, copy;
    private JTextField cadena;
    private JButton continuar;
    public static String nombre;
            
    public Inicio(){
        setLayout(null);
        setTitle("Serrano´s ATM");
        this.getContentPane().setBackground(new Color(255,255,255));
        /////////////////
        logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Facilita tu vida-min.png")));
        logo.setBounds(25,5,300,100);
        add(logo);
        /////////////////
        instruccion = new JLabel("Ingresa Tu Nombre");
        instruccion.setBounds(100,115,200,30);
        instruccion.setFont(new Font("Andale Mono", 1, 17));
        add(instruccion);
        /////////////////
        cadena = new JTextField();
        cadena.setBounds(25,145,300,30);
        cadena.setBackground(Color.WHITE);
        add(cadena);
        /////////////////
        continuar = new JButton("Continuar");
        continuar.setBounds(125,200,100,30);
        continuar.setBackground(new Color(255,255,255));
        continuar.setCursor(new Cursor(HAND_CURSOR));
        continuar.addActionListener(this);
        add(continuar);
        //////////////////
        copy = new JLabel("© Copyright 2018 SerranoCorp");
        copy.setBounds(85,270,200,30);
        copy.setFont(new Font("Andale Mono", 1, 12));
        add(copy);
        //////////////////
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == continuar) {
            nombre = cadena.getText().toString();
            if (nombre.length() > 100 || nombre.length() < 3 && nombre.length() > 0 ) {
                JOptionPane.showMessageDialog(null, "Nombre Invalido");
            }else{
                this.setVisible(false);
                Menu formMenu = new Menu();
                formMenu.setVisible(true);
                formMenu.setBounds(0,0,350,400);
                formMenu.setLocationRelativeTo(null);
                formMenu.setResizable(false);
            }
        }
    }
    
    public static void main(String[] args){
        Inicio formInicio = new Inicio();
        formInicio.setVisible(true);
        formInicio.setBounds(0,0,350,325);
        formInicio.setLocationRelativeTo(null);
        formInicio.setResizable(false);
    }
    
}