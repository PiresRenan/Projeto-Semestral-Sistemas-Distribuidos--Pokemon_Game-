package view;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;

import model.DataBaseMethods;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import presenter.LoginAuths;

public class LoginWindow {

    JFrame principalFrame;
    private JTextField usernameTxtField;
    private JPasswordField passwordField;

    public LoginWindow() {
        initialize();
    }

    private void initialize() {
        principalFrame = new JFrame();
        principalFrame.setVisible(true);
        
        JLabel titleLabel = new JLabel("Pokemon");
        JLabel userLabel = new JLabel("Usuario");
        JLabel passwordLabel = new JLabel("Senha");
        
        usernameTxtField = new JTextField();
        passwordField = new JPasswordField();
        
        JButton loginBtn = new JButton("ENTRAR");
        JButton cadastroBtn = new JButton("Cadastro");
        JButton newPasswordBtn = new JButton("Nova Senha");
        
        
        principalFrame.setTitle("Pokemon Distribuido");
        principalFrame.setResizable(false);
        principalFrame.setBounds(100, 100, 300, 439);
        principalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principalFrame.getContentPane().setLayout(null);
        
        
        loginBtn.setFont(new Font("Showcard Gothic", Font.ITALIC, 14));
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    if (LoginAuths.getAuth( usernameTxtField.getText(), passwordField.getText() )) {
                        principalFrame.dispose();
                    }else {
                       JOptionPane.showMessageDialog(null, "Usuario não encontrado", "Erro", JOptionPane.ERROR_MESSAGE );
                    }
                } catch (HeadlessException | SQLException error) {
                    error.printStackTrace();
                }
            }
        });
        loginBtn.setBounds(76, 230, 127, 43);

        
        userLabel.setFont(new Font("Showcard Gothic", Font.ITALIC, 16));
        userLabel.setBounds(10, 140, 83, 23);
        
        
        usernameTxtField.setBounds(90, 140, 170, 20);
        usernameTxtField.setColumns(10);
        
        
        passwordLabel.setFont(new Font("Showcard Gothic", Font.ITALIC, 16));
        passwordLabel.setBounds(10, 185, 83, 23);
       
        
        cadastroBtn.setFont(new Font("Showcard Gothic", Font.ITALIC, 14));
        cadastroBtn.setBounds(76, 284, 127, 43);
        cadastroBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroWindow a = new CadastroWindow();
                principalFrame.dispose();
            }
        });
        
        
        newPasswordBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Digite o email do usuario que deseja trocar a senha:");
                String senha = JOptionPane.showInputDialog("Digite nova senha:");
                DataBaseMethods a = new DataBaseMethods();
                try {
                    a.changePassword(nome, senha);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        newPasswordBtn.setFont(new Font("Showcard Gothic", Font.ITALIC, 12));
        newPasswordBtn.setBounds(76, 338, 127, 43);
        
        
        titleLabel.setFont(new Font("Showcard Gothic", Font.ITALIC, 28));
        titleLabel.setBounds(60, 44, 143, 43);
        
        
        passwordField.setBounds(90, 185, 170, 20);
        
        
        principalFrame.getContentPane().add(titleLabel);
        principalFrame.getContentPane().add(newPasswordBtn);
        principalFrame.getContentPane().add(cadastroBtn);
        principalFrame.getContentPane().add(passwordLabel);
        principalFrame.getContentPane().add(userLabel);
        principalFrame.getContentPane().add(loginBtn);
        principalFrame.getContentPane().add(usernameTxtField);
        principalFrame.getContentPane().add(passwordField);
    }
}
