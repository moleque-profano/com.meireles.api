import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.meireles.api.apicep.Controller;
import com.meireles.api.apicep.Model;
import com.meireles.api.apicep.View;
import java.awt.Cursor;

public class Consultar {

	private JFrame frmConsultarEndereo;
	private JTextField txtCep;
	private JTextField txtLogradouro;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtLocalidade;
	private JTextField txtUf;
	
	private Model model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultar window = new Consultar();
					window.frmConsultarEndereo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Consultar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void consulta(String cep, Model model) {
		this.model = model;
		new Controller(cep, model);
		
	}
	private void initialize() {
		frmConsultarEndereo = new JFrame();
		frmConsultarEndereo.setTitle("Consultar Endereço");
		frmConsultarEndereo.setBounds(100, 100, 571, 495);
		frmConsultarEndereo.setLocationRelativeTo(null);
		frmConsultarEndereo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultarEndereo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultar Endereço");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel.setBounds(152, 27, 235, 56);
		frmConsultarEndereo.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cep");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(25, 76, 46, 14);
		frmConsultarEndereo.getContentPane().add(lblNewLabel_1);
		
		txtCep = new JTextField();
		txtCep.setBounds(25, 97, 86, 29);
		frmConsultarEndereo.getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model model = new Model();
				View view = new View();
				consulta(txtCep.getText(), model);
				txtLogradouro.setText(view.pegarLogradouro(model));
				txtComplemento.setText(view.pegarComplemento(model));
				txtBairro.setText(view.pegarBairro(model));
				txtLocalidade.setText(view.pegarLocalidade(model));
				txtUf.setText(view.pegarUf(model));
								
			}
		});
		btnConsultar.setBounds(118, 96, 89, 23);
		frmConsultarEndereo.getContentPane().add(btnConsultar);
		
		JLabel lblNewLabel_2 = new JLabel("Logradouro");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(25, 132, 86, 14);
		frmConsultarEndereo.getContentPane().add(lblNewLabel_2);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(25, 150, 499, 29);
		frmConsultarEndereo.getContentPane().add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		JLabel txt = new JLabel("Complemento");
		txt.setFont(new Font("Arial", Font.BOLD, 13));
		txt.setBounds(25, 186, 115, 14);
		frmConsultarEndereo.getContentPane().add(txt);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(25, 205, 499, 29);
		frmConsultarEndereo.getContentPane().add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Bairro");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(25, 241, 46, 14);
		frmConsultarEndereo.getContentPane().add(lblNewLabel_3);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(25, 258, 499, 29);
		frmConsultarEndereo.getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Localidade");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(25, 294, 86, 14);
		frmConsultarEndereo.getContentPane().add(lblNewLabel_4);
		
		txtLocalidade = new JTextField();
		txtLocalidade.setBounds(25, 313, 499, 29);
		frmConsultarEndereo.getContentPane().add(txtLocalidade);
		txtLocalidade.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("UF");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_5.setBounds(25, 349, 46, 14);
		frmConsultarEndereo.getContentPane().add(lblNewLabel_5);
		
		txtUf = new JTextField();
		txtUf.setBounds(25, 367, 499, 29);
		frmConsultarEndereo.getContentPane().add(txtUf);
		txtUf.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCep.setText("");
				txtLogradouro.setText("");
				txtComplemento.setText("");
				txtBairro.setText("");
				txtLocalidade.setText("");
				txtUf.setText("");
			}
		});
		btnLimpar.setBounds(214, 96, 89, 23);
		frmConsultarEndereo.getContentPane().add(btnLimpar);
	}
}
