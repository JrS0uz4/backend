package view;

import java.awt.EventQueue;

import DAO.UsuarioDAO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Label;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField email;
	private JTextField senha;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Login frame = new Login();
					frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("LOGIN");
		lblNewJgoodiesTitle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		lblNewJgoodiesTitle.setBounds(176, 11, 94, 27);
		contentPane.add(lblNewJgoodiesTitle);
		
		Label label = new Label("E-MAIL :");
		label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		label.setBounds(90, 76, 62, 22);
		contentPane.add(label);
		
		Label SENHA = new Label("SENHA :");
		SENHA.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		SENHA.setBounds(90, 104, 62, 22);
		contentPane.add(SENHA);
		
		email = new JTextField();
		email.setBounds(158, 76, 161, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		senha = new JTextField();
		senha.setBounds(158, 104, 161, 20);
		contentPane.add(senha);
		senha.setColumns(10);
		
		Button login = new Button("LOGIN");
		login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				UsuarioDAO dao = new UsuarioDAO();
				
				// fazendo a validação dos dados
				if ( (email.getText().isEmpty()) || (senha.getText().isEmpty())) {
				   
					JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
				
				} else
					try {
						if (dao.buscarUsuario(email.getText(), senha.getText())) {
							
							JOptionPane.showMessageDialog(null, "Login Efetuado com Sucesso! Bem vindo ");
							
						} else {

							JOptionPane.showMessageDialog(null, "Erro!! Tente novamente ");
								
						}
					} catch (HeadlessException | SQLException e1) {
						e1.printStackTrace();
					}
				
				// apaga os dados preenchidos nos campos de texto
				email.setText("");
				senha.setText("");
			}
		});
		
		login.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		login.setBounds(119, 155, 88, 22);
		contentPane.add(login);
		
		Button limpar = new Button("LIMPAR");
		limpar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				email.setText("");
				senha.setText("");
			}
		});
		
		limpar.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		limpar.setBounds(223, 155, 96, 22);
		contentPane.add(limpar);
		
		JButton cancelar = new JButton("CANCELAR");
		cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		cancelar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		cancelar.setBounds(158, 199, 103, 39);
		contentPane.add(cancelar);
	}
}
