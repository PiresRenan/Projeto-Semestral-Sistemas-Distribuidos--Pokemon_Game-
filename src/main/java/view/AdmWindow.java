package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.DataBaseMethods;

public class AdmWindow {

	private JFrame frame;
	public JList<String> list;
	public JList<?> list_1;
	private JTextField senderTextField;
	private JTextField receiveTextField;
	private JTextField ipTextField;

	
	public AdmWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		
		JLabel admLabel = new JLabel("Painel de Administrador");
		JLabel ctrlPokemonLabel = new JLabel("Controle Pokemons");
		JLabel ctrlUsuariosLabel = new JLabel("Controle Usuarios");
		JLabel ctrlServidorLabel = new JLabel("Controle Servidor");
		
		JButton newPokemonBtn = new JButton("Novo Pokemon");
		JButton editPokemonBtn = new JButton("Editar Pokemon");
		JButton deletePokemonBtn = new JButton("Deletar Pokemon");
		JButton deleteUserBtn = new JButton("Deletar Usuario");
		JButton editUserBtn = new JButton("Editar Usuario");
		JButton newUserBtn = new JButton("Novo Usuario");
		JButton btnJogar = new JButton("Jogar");
		
		list = new JList<String>();
		list_1 = new JList<Object>();
		
		
		frame.setVisible(true);
		frame.setBounds(100, 100, 747, 668);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		admLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 30));
		admLabel.setBounds(169, 40, 392, 49);
		
		
		ctrlPokemonLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 22));
		ctrlPokemonLabel.setBounds(54, 131, 227, 43);
		
		
		ctrlUsuariosLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 22));
		ctrlUsuariosLabel.setBounds(467, 131, 211, 43);
		
		ctrlServidorLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 22));
		ctrlServidorLabel.setBounds(10, 466, 211, 43);
		
	
		newPokemonBtn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		newPokemonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    NewPokemon p = new NewPokemon();
			}
		});
		newPokemonBtn.setBounds(79, 185, 156, 35);
		
		editPokemonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String pokeName = JOptionPane.showInputDialog(null, "Digite o nome do Pokemon que deseja alterar:");
			    DataBaseMethods a = new DataBaseMethods();
			    try {
                    String pokemon = a.searchPokemon(pokeName);
                    JOptionPane.showMessageDialog(null,"O pokemon que deseja alterar:\n"+ pokemon);
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
			    String atribute = JOptionPane.showInputDialog(null, "Digite o atributo que deseja alterar:(id, name, type, abilities, hp, att, def, special_att, special_def, spd)");
			}
		});
		editPokemonBtn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		editPokemonBtn.setBounds(79, 231, 156, 35);
		
		deletePokemonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String pokeName = JOptionPane.showInputDialog(null, "Digite o nome do Pokemon que deseja alterar:");
                DataBaseMethods a = new DataBaseMethods();
                try {
                    String pokemon = a.searchPokemon(pokeName);
                    int i = JOptionPane.showConfirmDialog(null,"O pokemon que deseja excluir:\n"+ pokemon);
                    if(i != 0) {
                        JOptionPane.showMessageDialog(null, "Cancelado");
                    }else {
                        a.deletePokemon(pokeName);
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
			}
		});
		deletePokemonBtn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		deletePokemonBtn.setBounds(79, 277, 156, 35);
		
		deleteUserBtn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		deleteUserBtn.setBounds(495, 277, 142, 35);
		
		editUserBtn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		editUserBtn.setBounds(495, 231, 142, 35);
		
		newUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		newUserBtn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		newUserBtn.setBounds(495, 185, 142, 35);
		
		btnJogar.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 26));
		btnJogar.setBounds(495, 526, 156, 64);
	
		list.setBounds(10, 357, 337, 112);
		
		list_1.setBounds(387, 357, 337, 112);
		
		frame.getContentPane().add(list);
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
		frame.getContentPane().add(list_1);
		
		JLabel senderLabel = new JLabel("Sender");
		senderLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		senderLabel.setBounds(10, 526, 54, 14);
		frame.getContentPane().add(senderLabel);
		
		senderTextField = new JTextField();
		senderTextField.setFont(new Font("Anonymous Pro", Font.PLAIN, 12));
		senderTextField.setText("3000");
		senderTextField.setBounds(79, 524, 54, 20);
		frame.getContentPane().add(senderTextField);
		senderTextField.setColumns(10);
		
		JLabel receiveLabel = new JLabel("Receive");
		receiveLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		receiveLabel.setBounds(10, 586, 68, 14);
		frame.getContentPane().add(receiveLabel);
		
		receiveTextField = new JTextField();
		receiveTextField.setText("3001");
		receiveTextField.setFont(new Font("Anonymous Pro", Font.PLAIN, 12));
		receiveTextField.setColumns(10);
		receiveTextField.setBounds(79, 584, 54, 20);
		frame.getContentPane().add(receiveTextField);
		
		JLabel ipLabel = new JLabel("IP");
		ipLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		ipLabel.setBounds(10, 557, 54, 14);
		frame.getContentPane().add(ipLabel);
		
		ipTextField = new JTextField();
		ipTextField.setText("localhost");
		ipTextField.setFont(new Font("Anonymous Pro", Font.PLAIN, 12));
		ipTextField.setColumns(10);
		ipTextField.setBounds(79, 555, 156, 20);
		frame.getContentPane().add(ipTextField);
		
		JButton connectBtn = new JButton("Conectar");
		connectBtn.setFont(new Font("Arial Black", Font.BOLD, 12));
		connectBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    }
		});
		connectBtn.setBounds(245, 540, 102, 49);
		frame.getContentPane().add(connectBtn);
	}
}
