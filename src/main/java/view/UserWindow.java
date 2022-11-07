package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import model.Server;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserWindow {

    private JFrame frame;
    private JTextField myPortTextField;
    private JTextField opponentPortTextField;
    private JTextField ipTextField;
    Server server;
    
    private void findBtn(ActionEvent e) {
        server = new Server();
        server.start();
    }

    public UserWindow() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBounds(100, 100, 513, 505);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JList pokemonUserList = new JList();
        pokemonUserList.setBounds(10, 95, 252, 227);
        frame.getContentPane().add(pokemonUserList);
        
        JLabel myPokemonsLabel = new JLabel("Meus Pokemons");
        myPokemonsLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
        myPokemonsLabel.setBounds(74, 70, 109, 26);
        frame.getContentPane().add(myPokemonsLabel);
        
        JLabel welcomeLabel = new JLabel("Bem vindo");
        welcomeLabel.setFont(new Font("Cooper Black", Font.PLAIN, 27));
        welcomeLabel.setBounds(172, 11, 152, 51);
        frame.getContentPane().add(welcomeLabel);
        
        JButton playBtn = new JButton("Jogar");
        playBtn.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        playBtn.setBounds(346, 382, 135, 58);
        frame.getContentPane().add(playBtn);
        
        JLabel findLabel = new JLabel("Encontre um adversário");
        findLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
        findLabel.setBounds(20, 333, 204, 26);
        frame.getContentPane().add(findLabel);
        
        JLabel myPortLabel = new JLabel("Minha porta");
        myPortLabel.setFont(new Font("SimSun", Font.PLAIN, 13));
        myPortLabel.setBounds(10, 367, 91, 26);
        frame.getContentPane().add(myPortLabel);
        
        JLabel myIpLabel = new JLabel("Endereço");
        myIpLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        myIpLabel.setFont(new Font("SimSun", Font.PLAIN, 13));
        myIpLabel.setBounds(10, 418, 56, 26);
        frame.getContentPane().add(myIpLabel);
        
        JLabel opponentPortLabel = new JLabel("Porta do oponente");
        opponentPortLabel.setFont(new Font("SimSun", Font.PLAIN, 13));
        opponentPortLabel.setBounds(111, 367, 126, 26);
        frame.getContentPane().add(opponentPortLabel);
        
        myPortTextField = new JTextField();
        myPortTextField.setFont(new Font("Anonymous Pro", Font.PLAIN, 12));
        myPortTextField.setText("3000");
        myPortTextField.setBounds(27, 395, 39, 20);
        frame.getContentPane().add(myPortTextField);
        myPortTextField.setColumns(10);
        
        opponentPortTextField = new JTextField();
        opponentPortTextField.setFont(new Font("Anonymous Pro", Font.PLAIN, 12));
        opponentPortTextField.setText("3001");
        opponentPortTextField.setColumns(10);
        opponentPortTextField.setBounds(144, 395, 39, 20);
        frame.getContentPane().add(opponentPortTextField);
        
        ipTextField = new JTextField();
        ipTextField.setFont(new Font("Anonymous Pro", Font.PLAIN, 12));
        ipTextField.setText("localhost");
        ipTextField.setBounds(76, 421, 161, 20);
        frame.getContentPane().add(ipTextField);
        ipTextField.setColumns(10);
        
        JButton findBtn = new JButton("Encontre");
        findBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        findBtn.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        findBtn.setBounds(247, 394, 89, 49);
        frame.getContentPane().add(findBtn);
        
        JButton trainingBtn = new JButton("Treinar Pokemon");
        trainingBtn.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
        trainingBtn.setBounds(311, 95, 176, 51);
        frame.getContentPane().add(trainingBtn);
        
        JButton changeBtn = new JButton("Trocar Pokemon");
        changeBtn.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
        changeBtn.setBounds(311, 157, 176, 51);
        frame.getContentPane().add(changeBtn);
        
        JButton deletePokemon = new JButton("Abandonar Pokemon");
        deletePokemon.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
        deletePokemon.setBounds(311, 219, 176, 51);
        frame.getContentPane().add(deletePokemon);
        
        JButton btnProcurarPokemon = new JButton("Procurar Pokemon");
        btnProcurarPokemon.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
        btnProcurarPokemon.setBounds(311, 281, 176, 51);
        frame.getContentPane().add(btnProcurarPokemon);
    }
}
