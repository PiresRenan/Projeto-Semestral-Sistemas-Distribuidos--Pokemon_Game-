package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Battle;
import model.Server;
import model.Client;
import model.DataBaseMethods;
import model.Pokemon;
import model.Users;

public class ChangePokes implements Battle{

    private JFrame frame;
    Users user;
    private JTextField ipTextField;
    private JTextField portTextField;
    private JTextField messageTextField;
    private JTextField receivePort;
    JTextArea myPokemonsTextArea;
    JButton listenBtn;
    String[] array = new String[10];
    private JComboBox selectPokemonComboBox;
    
    Server server;
    
    @SuppressWarnings("unchecked")
    public void populateList() {
        for(int i = 1; i <= 3; i++) {
            Pokemon poke = null;
            DataBaseMethods n = new DataBaseMethods();
            try {
                poke = n.searchPokemonUser("comum");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (poke != null) {
                String pokeString = formatString(poke);
                array[i-1] = pokeString;
            }else {
                array[i-1] = "null";
            }
        }
        selectPokemonComboBox = new JComboBox(array);
    }
    
    public static String formatString(Pokemon s) {
        return s.getId() + " - " + s.getName() + " (att=" + s.getAtt() + " ,def=" + s.getDef() + " ,hp=" + s.getHp() + " , spc_att=" + s.getSpecial_att() + " , spc_def=" + s.getSpecial_def() + " , spd=" + s.getSpd() + ")";
    }
    
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
        populateList();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBounds(100, 100, 797, 650);
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
        connectBtn.setBounds(200, 44, 100, 40);
        frame.getContentPane().add(connectBtn);
        
        myPokemonsTextArea = new JTextArea();
        myPokemonsTextArea.setBounds(10, 168, 321, 321);
        frame.getContentPane().add(myPokemonsTextArea);
        
        selectPokemonComboBox.setBounds(10, 524, 761, 22);
        frame.getContentPane().add(selectPokemonComboBox);
        
        JButton changeBtn = new JButton("Trocar");
        changeBtn.setFont(new Font("Stencil", Font.ITALIC, 10));
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
        
        JButton addBtn = new JButton("Adicionar Pokemon a lista");
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        addBtn.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 15));
        addBtn.setBounds(108, 557, 541, 43);
        frame.getContentPane().add(addBtn);
        
        JLabel friendPokemonsLabel = new JLabel("Pokemons Amigo");
        friendPokemonsLabel.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 19));
        friendPokemonsLabel.setBounds(523, 124, 174, 33);
        frame.getContentPane().add(friendPokemonsLabel);
    }

    @Override
    public void pokemonBattle(String pokemon) {
        myPokemonsTextArea.append(pokemon + System.lineSeparator());
        
    }

}
