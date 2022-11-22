package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Battle;
import model.Server;
import model.Client;

public class ChangePokes implements Battle{

    private JFrame frame;
    
    private JTextField ipTextField;
    private JTextField portTextField;
    private JTextField messageTextField;
    private JTextField receivePort;
    JButton listenBtn;
    JTextArea chat;
    
    Server server;
    
    private void listenBtn(ActionEvent e) {
        server = new Server(this, Integer.parseInt(receivePort.getText()));
        server.start();
    }
   
    private void sendBtn(ActionEvent e) {
        Client client = new Client(messageTextField.getText(), ipTextField.getText(), Integer.parseInt(portTextField.getText()));
        client.start();
    }
    
    public void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 797, 609);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel principalLabel = new JLabel("Troca de Pokemons");
        principalLabel.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 30));
        principalLabel.setBounds(318, 49, 331, 42);
        frame.getContentPane().add(principalLabel);
        
        portTextField = new JTextField();
        portTextField.setBounds(10, 36, 76, 20);
        frame.getContentPane().add(portTextField);
        portTextField.setColumns(10);
        
        JLabel receivePortLabel = new JLabel("Porta Receber");
        receivePortLabel.setBounds(10, 11, 76, 14);
        frame.getContentPane().add(receivePortLabel);
        
        ipTextField = new JTextField();
        ipTextField.setColumns(10);
        ipTextField.setBounds(10, 88, 174, 20);
        frame.getContentPane().add(ipTextField);
        
        JLabel IPLabel = new JLabel("Endereço de IP");
        IPLabel.setBounds(10, 66, 76, 14);
        frame.getContentPane().add(IPLabel);
        
        JLabel sendPortLabel = new JLabel("Porta Enviar");
        sendPortLabel.setBounds(108, 11, 76, 14);
        frame.getContentPane().add(sendPortLabel);
        
        receivePort = new JTextField();
        receivePort.setColumns(10);
        receivePort.setBounds(108, 36, 76, 20);
        frame.getContentPane().add(receivePort);
        
        JButton connectBtn = new JButton("Conectar");
        connectBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listenBtn(e);
            }
        });
        connectBtn.setBounds(194, 44, 76, 36);
        frame.getContentPane().add(connectBtn);
        
        JTextArea myPokemonsTextArea = new JTextArea();
        myPokemonsTextArea.setBounds(10, 168, 321, 321);
        frame.getContentPane().add(myPokemonsTextArea);
        
        JComboBox selectPokemonComboBox = new JComboBox();
        selectPokemonComboBox.setBounds(10, 524, 761, 22);
        frame.getContentPane().add(selectPokemonComboBox);
        
        JButton changeBtn = new JButton("Trocar");
        changeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendBtn(e);
            }
        });
        changeBtn.setBounds(354, 296, 72, 42);
        frame.getContentPane().add(changeBtn);
        
        JLabel myPokemonsLabel = new JLabel("Meus Pokemons");
        myPokemonsLabel.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 19));
        myPokemonsLabel.setBounds(63, 124, 174, 33);
        frame.getContentPane().add(myPokemonsLabel);
        
        JTextArea friendPokemonsTextArea = new JTextArea();
        friendPokemonsTextArea.setBounds(450, 168, 321, 321);
        frame.getContentPane().add(friendPokemonsTextArea);
        
        JLabel friendPokemonsLabel = new JLabel("Pokemons Amigo");
        friendPokemonsLabel.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 19));
        friendPokemonsLabel.setBounds(523, 124, 174, 33);
        frame.getContentPane().add(friendPokemonsLabel);
    }

    @Override
    public void pokemonBattle(String pokemon) {
        chat.append(pokemon + System.lineSeparator());
        
    }

}
