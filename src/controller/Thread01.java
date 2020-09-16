package controller;

import java.util.Random;

import javax.swing.JTextField;

import view.Tela;
public class Thread01 extends Thread {
	
	JTextField tfNum1;
	int limite=0;
	
	public Thread01(JTextField tfNum1, int limite) {
		this.tfNum1 = tfNum1;
		this.limite = limite;
		
	}
	
	
	public void run() {
		
		int i = 0 ;
		int num =0;
		
		
		Random geradorNum = new Random();// gera os numeros aleatorios até em um 
		
		while(i<limite){
			
			num = geradorNum.nextInt(8);
			tfNum1.setText(Integer.toString(num));
			
			try {
				Thread.sleep(50);//colocar a thread para dormir por 50 milisegundos permitindo enxergar os numeros rodando
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			i++;
		}
	}
}
