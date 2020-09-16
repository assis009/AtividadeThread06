package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Thread01;
import controller.Thread02;
import controller.Thread03;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JTextField tfNum3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfNum1 = new JTextField();
		tfNum1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfNum1.setBounds(32, 32, 86, 68);
		contentPane.add(tfNum1);
		tfNum1.setColumns(10);
		
		tfNum2 = new JTextField();
		tfNum2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfNum2.setColumns(10);
		tfNum2.setBounds(128, 32, 86, 68);
		contentPane.add(tfNum2);
		
		tfNum3 = new JTextField();
		tfNum3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfNum3.setColumns(10);
		tfNum3.setBounds(224, 32, 86, 68);
		contentPane.add(tfNum3);
		
		JButton btnJogar = new JButton("Jogar ");
		btnJogar.setBounds(283, 189, 89, 23);
		contentPane.add(btnJogar);
		
		JLabel lblCa = new JLabel("Ca\u00E7a-niquel ");
		lblCa.setForeground(Color.DARK_GRAY);
		lblCa.setFont(new Font("Arial", Font.BOLD, 16));
		lblCa.setBounds(10, -2, 182, 23);
		contentPane.add(lblCa);
		
		ActionListener jogar = new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				int limite =0;
				
				Random geradorVezes = new Random();//gera o tanto de vezes que o numero vai rodar
				limite = geradorVezes.nextInt(151);//definindo quantas vezes que os numeros iram gerar
				
				Thread thread01 = new Thread01(tfNum1,limite);
				Thread thread02 = new Thread02(tfNum2,limite);
				Thread thread03 = new Thread03(tfNum3,limite);
				
				thread01.start();
				thread02.start();
				thread03.start();
				
				
			}
			
		};
		
		btnJogar.addActionListener(jogar);
	}
}
