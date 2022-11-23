package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import model.DataBaseMethods;
import model.Pokemon;
import model.Users;
import presenter.AdmUser;
import javax.swing.JComboBox;

public class AdmWindow {

	private JFrame frame;
	private JTextField senderTextField;
	private JTextField receiveTextField;
	private JTextField ipTextField;
	String[] array = new String[10];
	private JComboBox pokemonComboBox;
	Users user;
	
	
	@SuppressWarnings("unchecked")
    public void populateList() {
	    for(int i = 1; i <= 10; i++) {
	        Pokemon poke = null;
	        DataBaseMethods n = new DataBaseMethods();
	        try {
                poke = n.searchPokemonID(i);
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
	    pokemonComboBox = new JComboBox(array);
	}

	public static String formatString(Pokemon s) {
        return s.getId() + " - " + s.getName() + " (att=" + s.getAtt() + " ,def=" + s.getDef() + " ,hp=" + s.getHp() + " , spc_att=" + s.getSpecial_att() + " , spc_def=" + s.getSpecial_def() + " , spd=" + s.getSpd() + ")";
    }
	
	public AdmWindow(Users userlogin) {
		initialize();
		user = userlogin;
	}
	public AdmWindow() {
	    initialize();
	}

	private void initialize() {
		frame = new JFrame();
		populateList();
		
		JLabel admLabel = new JLabel("Painel de Administrador");
		JLabel ctrlPokemonLabel = new JLabel("Controle Pokemons");
		JLabel ctrlUsuariosLabel = new JLabel("Controle Usuarios");
		JLabel ctrlServidorLabel = new JLabel("Controle Servidor");
		
		JButton newPokemonBtn = new JButton("Novo Pokemon");
		JButton editPokemonBtn = new JButton("Editar Pokemon");
		JButton deletePokemonBtn = new JButton("Deletar Pokemon");
		JButton deleteUserBtn = new JButton("Deletar Usuario");
		deleteUserBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        AdmUser.deleteUser();
		    }
		});
		JButton editUserBtn = new JButton("Editar Usuario");
		editUserBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
                AdmUser.editUser();
		    }
		});
		JButton newUserBtn = new JButton("Novo Usuario");
		JButton btnJogar = new JButton("Jogar");
		btnJogar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		    }
		});
		
		
		frame.setVisible(true);
		frame.setBounds(100, 100, 747, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		admLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 30));
		admLabel.setBounds(169, 40, 392, 49);
		
		
		ctrlPokemonLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 22));
		ctrlPokemonLabel.setBounds(103, 131, 227, 43);
		
		
		ctrlUsuariosLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 22));
		ctrlUsuariosLabel.setBounds(467, 131, 211, 43);
		
		ctrlServidorLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 22));
		ctrlServidorLabel.setBounds(10, 377, 211, 43);
		
	
		newPokemonBtn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		newPokemonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    NewPokemon p = new NewPokemon();
			    frame.dispose();
			}
		});
		newPokemonBtn.setBounds(46, 185, 156, 35);
		
		editPokemonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   AdmUser.editPokemon();  
			}
		});
		editPokemonBtn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		editPokemonBtn.setBounds(46, 231, 156, 35);
		
		deletePokemonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    AdmUser.deletePokemon();
			}
		});
		deletePokemonBtn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		deletePokemonBtn.setBounds(46, 277, 156, 35);
		
		deleteUserBtn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		deleteUserBtn.setBounds(495, 277, 142, 35);
		
		editUserBtn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		editUserBtn.setBounds(495, 231, 142, 35);
		
		newUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    CadastroWindow a = new CadastroWindow();
			}
		});
		newUserBtn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		newUserBtn.setBounds(495, 185, 142, 35);
		
		btnJogar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 26));
		btnJogar.setBounds(495, 437, 156, 64);
		frame.getContentPane().add(btnJogar);
		frame.getContentPane().add(newUserBtn);
		frame.getContentPane().add(editUserBtn);
		frame.getContentPane().add(deleteUserBtn);
		frame.getContentPane().add(deletePokemonBtn);
		frame.getContentPane().add(editPokemonBtn);
		frame.getContentPane().add(newPokemonBtn);
		frame.getContentPane().add(ctrlServidorLabel);
		frame.getContentPane().add(ctrlUsuariosLabel);
		frame.getContentPane().add(ctrlPokemonLabel);
		frame.getContentPane().add(admLabel);
		
		JLabel senderLabel = new JLabel("Sender");
		senderLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		senderLabel.setBounds(10, 437, 54, 14);
		frame.getContentPane().add(senderLabel);
		
		senderTextField = new JTextField();
		senderTextField.setFont(new Font("Anonymous Pro", Font.PLAIN, 12));
		senderTextField.setText("3000");
		senderTextField.setBounds(79, 435, 54, 20);
		frame.getContentPane().add(senderTextField);
		senderTextField.setColumns(10);
		
		JLabel receiveLabel = new JLabel("Receive");
		receiveLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		receiveLabel.setBounds(10, 497, 68, 14);
		frame.getContentPane().add(receiveLabel);
		
		receiveTextField = new JTextField();
		receiveTextField.setText("3001");
		receiveTextField.setFont(new Font("Anonymous Pro", Font.PLAIN, 12));
		receiveTextField.setColumns(10);
		receiveTextField.setBounds(79, 495, 54, 20);
		frame.getContentPane().add(receiveTextField);
		
		JLabel ipLabel = new JLabel("IP");
		ipLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		ipLabel.setBounds(10, 468, 54, 14);
		frame.getContentPane().add(ipLabel);
		
		ipTextField = new JTextField();
		ipTextField.setText("localhost");
		ipTextField.setFont(new Font("Anonymous Pro", Font.PLAIN, 12));
		ipTextField.setColumns(10);
		ipTextField.setBounds(79, 466, 156, 20);
		frame.getContentPane().add(ipTextField);
		
		JButton connectBtn = new JButton("Conectar");
		connectBtn.setFont(new Font("Arial Black", Font.BOLD, 12));
		connectBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    }
		});
		connectBtn.setBounds(245, 451, 102, 49);
		frame.getContentPane().add(connectBtn);
		
		pokemonComboBox.setBounds(10, 346, 450, 20);
		frame.getContentPane().add(pokemonComboBox);
		
		JComboBox userComboBox = new JComboBox();
		userComboBox.setBounds(470, 346, 208, 21);
		frame.getContentPane().add(userComboBox);
		
		JButton upgradeBtn = new JButton("Treinar Pokemon");
		upgradeBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		    }
		});
		upgradeBtn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		upgradeBtn.setBounds(245, 185, 156, 35);
		frame.getContentPane().add(upgradeBtn);
		
		JButton changeBtn = new JButton("Trocar Pokemon");
		changeBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        ChangePokes p = new ChangePokes();
		        p.initialize();
		    }
		});
		changeBtn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		changeBtn.setBounds(245, 231, 156, 35);
		frame.getContentPane().add(changeBtn);
		
		JButton btnCapturar = new JButton("Capturar Pokemon");
		btnCapturar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
                    DataBaseMethods.findPokemonsUsers("aaaa");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
		    }
		});
		btnCapturar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		btnCapturar.setBounds(245, 277, 156, 35);
		frame.getContentPane().add(btnCapturar);
	}
}
