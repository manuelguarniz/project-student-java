package com.presentacion.escritorio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.entidades.seguridad.SEG_UsuarioEL;
import com.logica.seguridad.SEG_UsuarioBL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtPAssword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:     ");
		lblUsuario.setBounds(50, 58, 83, 14);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(142, 55, 111, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(50, 95, 83, 14);
		contentPane.add(lblPassword);
		
		txtPAssword = new JTextField();
		txtPAssword.setColumns(10);
		txtPAssword.setBounds(142, 92, 111, 20);
		contentPane.add(txtPAssword);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SEG_UsuarioEL u = SEG_UsuarioBL.Instancia().VerificarAcceso(
								txtUsuario.getText(), txtPAssword.getText());
					dispose();
					frmMenuPrincipal m = new frmMenuPrincipal();
					m.show();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), 
							"Sistema Comercial", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnIngresar.setBounds(74, 144, 89, 23);
		contentPane.add(btnIngresar);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.setBounds(194, 144, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
