package AULA.DESAFIO_01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class painel extends JPanel implements MouseListener, KeyListener {
	private String posicao;
	ArrayList<player> jogadores = new ArrayList<player>();
	ArrayList<obstaculos> muros = new ArrayList<obstaculos>();
	public painel(String posicao) {
		this.posicao = posicao;
		switch (this.posicao) {
		case "Norte":
			this.setPreferredSize(new Dimension(800,100));
			this.setBackground(new Color(210,105,30));
			System.out.println("Painel Norte");
			break;
		case "Centro":
			this.setPreferredSize(new Dimension(800,500));
			this.setBackground(new Color(245,222,179));
			System.out.println("Painel Centro");
			this.addMouseListener(this);
			this.addKeyListener(this);
			this.setFocusable(true);
			break;
		}
	}
	
	public void paintComponent(Graphics d) {
		Graphics2D d2 = (Graphics2D) d;
		d2.setColor(this.getBackground());
		d2.fillRect( 0, 0, this.getWidth(), this.getHeight());
		
		if(this.posicao == "Norte") {
			
		} else {
			for(player j : jogadores) {
				j.mostrarPlayer(d2);
			}
			for(obstaculos m : muros) {
				m.desenharObstaculos(d2);
			}
		}
	}
	public void addJogador() {
		jogadores.add(new player("Amendoim", 'O', this.getWidth(),this.getHeight()));
		jogadores.add(new player("Batatinha", 'R', this.getWidth(), this.getHeight()));
		
	}
	public void addMuro() {
		muros.add(new obstaculos(80,80,70,140));
		muros.add(new obstaculos(350,200,120,120));
		muros.add(new obstaculos(630,400,100,50));
		
	}
// =============================================================================================================
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			for(player j : jogadores) {
				boolean ativado = j.veriAtivPlauyer(e.getX(), e.getY());
				if(ativado) {
					j.ativarplayer(true);
				} else {
					j.ativarplayer(false);
				}
			}
		}
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	// =============================================================================================================

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char direcao = 'A';
		if(e.getKeyCode() == 87) {
			direcao = 'C';
		}else if(e.getKeyCode() == 65) {
			direcao = 'E';
		}else if(e.getKeyCode() == 83) {
			direcao = 'B';
		}else if(e.getKeyCode() == 68) {
			direcao = 'D';
		} else if(e.getKeyCode() == 27) {
			System.exit(0);
		}
		for(player j : jogadores) {
			if(direcao != 'A' && j.estaAtivo()) {
				boolean colidiu = j.verifColisoesMuro(direcao, 5, muros);
				if(!colidiu){
					this.repaint();					
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	// =============================================================================================================
}
