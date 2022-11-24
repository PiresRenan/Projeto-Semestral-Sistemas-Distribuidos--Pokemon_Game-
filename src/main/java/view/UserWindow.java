package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import model.DataBaseMethods;
import model.Pokemon;
import model.Server;
import model.Users;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;

public class UserWindow {

    JTextArea pokemonUserList;
    private JFrame frame;
    private JTextField myPortTextField;
    private JTextField opponentPortTextField;
    private JTextField ipTextField;
    Server server;
    private Users user;
    
    private void findBtn(ActionEvent e) {
        server = new Server(null, 0);
        server.start();
    }

    public UserWindow(Users userLogado) throws SQLException {
        initialize();
        user = userLogado;
    }

    private void initialize() throws SQLException {
        frame = new JFrame();
        populateList();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBounds(100, 100, 513, 505);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
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
                try {
					Random a = new Random();
					 int aleatorio_n = a.nextInt(14) + 1;
                    Pokemon p = DataBaseMethods.searchPokemonID(aleatorio_n);
					DataBaseMethods.capturarPokemon(p, user.getName());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        findBtn.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        findBtn.setBounds(247, 394, 89, 49);
        frame.getContentPane().add(findBtn);
        
        JButton trainingBtn = new JButton("Treinar Pokemon");
        trainingBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
					Pokemon pokemon = DataBaseMethods.searchPokemonUser(user.getName());
					String a = JOptionPane.showInputDialog(null, "Escolha o atributo que quer trocar");
					Random random = new Random();
					int rand_n = random.nextInt(10);
					DataBaseMethods.upgradePokemon(pokemon, a, rand_n);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }
        });
        trainingBtn.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
        trainingBtn.setBounds(311, 95, 176, 51);
        frame.getContentPane().add(trainingBtn);
        
        JButton changeBtn = new JButton("Trocar Pokemon");
        changeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePokes p = new ChangePokes();
                p.initialize();
            }
        });
        changeBtn.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
        changeBtn.setBounds(311, 157, 176, 51);
        frame.getContentPane().add(changeBtn);
        
        JButton deletePokemon = new JButton("Abandonar Pokemon");
        deletePokemon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome_p = JOptionPane.showInputDialog(null, "Escreva o nome do Pokemon que deseja excluir");
                try {
                    DataBaseMethods.deletePokemon(nome_p, user.getName());
                    JOptionPane.showMessageDialog(null, "Pokemon abandonado com sucesso.");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        deletePokemon.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
        deletePokemon.setBounds(311, 219, 176, 51);
        frame.getContentPane().add(deletePokemon);
        
        JButton btnProcurarPokemon = new JButton("Procurar Pokemon");
        btnProcurarPokemon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
					Random a = new Random();
					int aleatorio_n = a.nextInt(14) + 1;
                    Pokemon p = DataBaseMethods.searchPokemonID(aleatorio_n);
					DataBaseMethods.capturarPokemon(p, user.getName());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnProcurarPokemon.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
        btnProcurarPokemon.setBounds(311, 281, 176, 51);
        frame.getContentPane().add(btnProcurarPokemon);
    }

    private void populateList() throws SQLException {
        pokemonUserList = new JTextArea();
        Pokemon p = DataBaseMethods.searchPokemonUser(user.getName());
        pokemonUserList.append(p.toString());
    }
}
