package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import model.DataBaseMethods;
import model.Pokemon;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NewPokemon {

    private JFrame frame;
    private JTextField nameTextField;
    private JTextField typeTextField;
    private JTextField abilitiesTextField;
    private JTextField hpTextField;
    private JTextField attTextField;
    private JLabel defLabel;
    private JTextField defTextField;
    private JLabel spcAttLabel;
    private JTextField spcAttTextField;
    private JTextField spcDefTextField;
    private JLabel spcDefLabel;
    private JLabel spdLabel;
    private JTextField spdTextField;
    private JButton addBtn;
    
    public NewPokemon() {
        initialize();
    }
    
    private void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBounds(100, 100, 450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel welcomeLabel = new JLabel("Novo Pokemon");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        welcomeLabel.setBounds(166, 28, 113, 29);
        frame.getContentPane().add(welcomeLabel);
        
        JLabel nameLabel = new JLabel("Nome");
        nameLabel.setBounds(10, 71, 33, 14);
        frame.getContentPane().add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(79, 68, 345, 20);
        frame.getContentPane().add(nameTextField);
        nameTextField.setColumns(10);
        
        JLabel typeLabel = new JLabel("Tipo");
        typeLabel.setBounds(10, 96, 33, 14);
        frame.getContentPane().add(typeLabel);
        
        typeTextField = new JTextField();
        typeTextField.setColumns(10);
        typeTextField.setBounds(79, 93, 345, 20);
        frame.getContentPane().add(typeTextField);
        
        abilitiesTextField = new JTextField();
        abilitiesTextField.setColumns(10);
        abilitiesTextField.setBounds(79, 122, 345, 20);
        frame.getContentPane().add(abilitiesTextField);
        
        JLabel abilitiesLabel = new JLabel("Habilidades");
        abilitiesLabel.setBounds(10, 125, 72, 14);
        frame.getContentPane().add(abilitiesLabel);
        
        JLabel hpLabel = new JLabel("Vida");
        hpLabel.setBounds(10, 164, 33, 14);
        frame.getContentPane().add(hpLabel);
        
        hpTextField = new JTextField();
        hpTextField.setBounds(53, 161, 86, 20);
        frame.getContentPane().add(hpTextField);
        hpTextField.setColumns(10);
        
        JLabel attLabel = new JLabel("Ataque");
        attLabel.setBounds(149, 164, 48, 14);
        frame.getContentPane().add(attLabel);
        
        attTextField = new JTextField();
        attTextField.setColumns(10);
        attTextField.setBounds(192, 161, 86, 20);
        frame.getContentPane().add(attTextField);
        
        defLabel = new JLabel("Defesa");
        defLabel.setBounds(293, 164, 46, 14);
        frame.getContentPane().add(defLabel);
        
        defTextField = new JTextField();
        defTextField.setBounds(338, 161, 86, 20);
        frame.getContentPane().add(defTextField);
        defTextField.setColumns(10);
        
        spcAttLabel = new JLabel("Especial Ataque");
        spcAttLabel.setBounds(10, 192, 79, 14);
        frame.getContentPane().add(spcAttLabel);
        
        spcAttTextField = new JTextField();
        spcAttTextField.setColumns(10);
        spcAttTextField.setBounds(53, 209, 86, 20);
        frame.getContentPane().add(spcAttTextField);
        
        spcDefTextField = new JTextField();
        spcDefTextField.setColumns(10);
        spcDefTextField.setBounds(193, 209, 86, 20);
        frame.getContentPane().add(spcDefTextField);
        
        spcDefLabel = new JLabel("Especial Defesa");
        spcDefLabel.setBounds(149, 192, 86, 14);
        frame.getContentPane().add(spcDefLabel);
        
        spdLabel = new JLabel("Velocidade");
        spdLabel.setBounds(293, 192, 64, 14);
        frame.getContentPane().add(spdLabel);
        
        spdTextField = new JTextField();
        spdTextField.setColumns(10);
        spdTextField.setBounds(338, 209, 86, 20);
        frame.getContentPane().add(spdTextField);
        
        addBtn = new JButton("Adicionar");
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pokemon p = new Pokemon(
                        nameTextField.getText(),
                        typeTextField.getText(),
                        abilitiesTextField.getText(),
                        Integer.parseInt(hpTextField.getText()),
                        Integer.parseInt(attTextField.getText()),
                        Integer.parseInt(defTextField.getText()),
                        Integer.parseInt(spcAttTextField.getText()),
                        Integer.parseInt(spcDefTextField.getText()),
                        Integer.parseInt(spdTextField.getText())
                        );
                DataBaseMethods a = new DataBaseMethods();
                try {
                    a.insertPokemon(p);
                    JOptionPane.showMessageDialog(null, "Pokemon inserido");
                    frame.dispose();
                    AdmWindow aa = new AdmWindow();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        addBtn.setBounds(132, 261, 170, 39);
        frame.getContentPane().add(addBtn);
    }

}
