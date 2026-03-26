package AULA.DESAFIO_01;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class moldura extends JFrame {
	public moldura() {
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setTitle("Cap 07 - Detectores de Colisão");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		painel PN = new painel("Norte");
		painel PC = new painel("Centro");
		
		this.add(PN, BorderLayout.NORTH);
		this.add(PC, BorderLayout.CENTER);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		PC.addJogador();
		PC.addMuro();
	}
}
