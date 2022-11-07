package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;

import model.DataBaseMethods;
import model.Users;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroWindow {

    private JFrame frame;
    private JTextField confirmPasswordTextField;
    private JTextField passwordTextField;
    private JLabel passwordLabel;
    private JTextField emailTextField;
    private JLabel emailLabel;
    private JTextField nameTextField;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JTextField ageTextField;
    private JButton startBtn;

    public CadastroWindow() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setBounds(100, 100, 209, 399);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel welcomeLabel = new JLabel("Novo Usuario");
        welcomeLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
        welcomeLabel.setBounds(55, 11, 86, 32);
        frame.getContentPane().add(welcomeLabel);
        
        JLabel confirmPasswordLabel = new JLabel("Confirme senha");
        confirmPasswordLabel.setBounds(10, 185, 102, 14);
        frame.getContentPane().add(confirmPasswordLabel);
        
        confirmPasswordTextField = new JTextField();
        confirmPasswordTextField.setColumns(10);
        confirmPasswordTextField.setBounds(10, 203, 172, 20);
        frame.getContentPane().add(confirmPasswordTextField);
        
        passwordTextField = new JTextField();
        passwordTextField.setColumns(10);
        passwordTextField.setBounds(10, 161, 172, 20);
        frame.getContentPane().add(passwordTextField);
        
        passwordLabel = new JLabel("Senha");
        passwordLabel.setBounds(10, 143, 80, 14);
        frame.getContentPane().add(passwordLabel);
        
        emailTextField = new JTextField();
        emailTextField.setColumns(10);
        emailTextField.setBounds(10, 118, 172, 20);
        frame.getContentPane().add(emailTextField);
        
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 100, 80, 14);
        frame.getContentPane().add(emailLabel);
        
        nameTextField = new JTextField();
        nameTextField.setColumns(10);
        nameTextField.setBounds(10, 72, 172, 20);
        frame.getContentPane().add(nameTextField);
        
        nameLabel = new JLabel("Nome");
        nameLabel.setBounds(10, 54, 80, 14);
        frame.getContentPane().add(nameLabel);
        
        ageLabel = new JLabel("Idade");
        ageLabel.setBounds(10, 234, 80, 14);
        frame.getContentPane().add(ageLabel);
        
        ageTextField = new JTextField();
        ageTextField.setColumns(10);
        ageTextField.setBounds(10, 252, 172, 20);
        frame.getContentPane().add(ageTextField);
        
        startBtn = new JButton("Começar a jornada");
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nameTextField.getText();
                String email = emailTextField.getText();
                int age = Integer.parseInt(ageTextField.getText());
                String senha1 = passwordTextField.getText();
                String senha2 = confirmPasswordTextField.getText();
                if ((nome != null) && (email != null) && (senha1 != null) &&(senha2 != null)) {
                    if(senha1 != senha2) {
                        Users newUser = new Users(nome, email, senha1, age, 0);
                        DataBaseMethods a = new DataBaseMethods();
                        try {
                            a.newUser(newUser);
                            LoginWindow b = new LoginWindow();
                        } catch (Exception e1){
                            e1.printStackTrace();
                        }
                        
                    }else {
                        System.out.println(senha1);
                        System.out.println(senha2);
                        JOptionPane.showMessageDialog(null, "Confirme sua senha, as duas estão diferentes.");
                    }
                    
                }else {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                }
                
            }
        });
        startBtn.setBounds(10, 304, 172, 45);
        frame.getContentPane().add(startBtn);
    }

}
