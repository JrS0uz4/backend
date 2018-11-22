package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import DAO.UsuarioDAO;
import modelo.Usuario;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField cpf;
	private JTextField email;
	private JTextField senha;
	private JTextField celular;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JLabel lblCelular;
	private JLabel lblCpf;
	private JLabel lblNome;
	private JButton cancelar;


	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cadastro() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCadastrar = DefaultComponentFactory.getInstance().createTitle("CADASTRAR");
		lblCadastrar.setBounds(128, 11, 206, 28);
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		
		nome = new JTextField();
		nome.setBounds(152, 70, 191, 20);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setBounds(152, 101, 191, 20);
		cpf.setColumns(10);
		
		email = new JTextField();
		email.setBounds(152, 132, 191, 20);
		email.setColumns(10);
		
		senha = new JTextField();
		senha.setBounds(152, 163, 191, 20);
		senha.setColumns(10);
		
		celular = new JTextField();
		celular.setBounds(152, 194, 191, 20);
		celular.setColumns(10);
		
		lblNome = new JLabel("NOME :");
		lblNome.setBounds(71, 71, 62, 17);
		lblNome.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		
		lblCpf = new JLabel("CPF :");
		lblCpf.setBounds(71, 102, 62, 17);
		lblCpf.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		
		lblEmail = new JLabel("E-MAIL :");
		lblEmail.setBounds(71, 133, 62, 17);
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		
		lblSenha = new JLabel("SENHA :");
		lblSenha.setBounds(71, 166, 71, 17);
		lblSenha.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		
		lblCelular = new JLabel("CELULAR :");
		lblCelular.setBounds(71, 195, 71, 17);
		lblCelular.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		
		Button cadastrar = new Button("CADASTRAR");
		cadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Usuario usuarios = new Usuario();
				usuarios.setNome(nome.getText());
				
				long x = Long.parseLong(cpf.getText());
				usuarios.setCpf(x);
				
				usuarios.setEmail(email.getText());
				usuarios.setSenha(senha.getText());
				
				x = Long.parseLong(celular.getText());
				usuarios.setCelular(x);

				// fazendo a validação dos dados
				if ((nome.getText().isEmpty()) || (cpf.getText().isEmpty()) || (email.getText().isEmpty()) || 
						(senha.getText().isEmpty()) || (celular.getText().isEmpty())) {
				   
					JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
				}
				
				else {

				    // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
				    UsuarioDAO dao = new UsuarioDAO();
				    dao.adicionaUsuario(usuarios);
				    JOptionPane.showMessageDialog(null, "Usuário "+ nome.getText() +" inserido com sucesso! ");
				}

				// apaga os dados preenchidos nos campos de texto
				nome.setText("");
				cpf.setText("");
				email.setText("");
				senha.setText("");
				celular.setText("");
			}
		});
		
		cadastrar.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		cadastrar.setBounds(128, 245, 88, 22);
		contentPane.setLayout(null);
		contentPane.add(lblCadastrar);
		contentPane.add(lblNome);
		contentPane.add(nome);
		contentPane.add(lblCpf);
		contentPane.add(cpf);
		contentPane.add(lblEmail);
		contentPane.add(email);
		contentPane.add(lblSenha);
		contentPane.add(senha);
		contentPane.add(lblCelular);
		contentPane.add(celular);
		contentPane.add(cadastrar);
		
		Button limpar = new Button("LIMPAR");
		limpar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				nome.setText("");
				cpf.setText("");
				email.setText("");
				senha.setText("");
				celular.setText("");
			}
		});
		
		limpar.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		limpar.setBounds(232, 245, 96, 22);
		contentPane.add(limpar);
		
		cancelar = new JButton("CANCELAR");
		cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0); 
			}
		});
		
		cancelar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		cancelar.setBounds(184, 292, 103, 39);
		contentPane.add(cancelar);
	}
}
