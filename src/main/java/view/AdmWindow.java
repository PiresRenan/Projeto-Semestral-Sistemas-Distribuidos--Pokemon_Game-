package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class AdmWindow {

	private JFrame frame;
	public JList<String> list;
	public JList<?> list_1;

	
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
			}
		});
		newPokemonBtn.setBounds(79, 185, 156, 35);
		
		editPokemonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editPokemonBtn.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		editPokemonBtn.setBounds(79, 231, 156, 35);
		
		deletePokemonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
	}
}
