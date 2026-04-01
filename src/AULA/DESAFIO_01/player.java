package AULA.DESAFIO_01;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class player extends Rectangle{
	private String nome;
	private char forma;
	private Color CorFundo,CorFundoAtv,CorFundoAt;
	private Color CorBorda,CorBordaAtv,CorBordaAt;
	private boolean ativado;
	
	public player(String nome, char forma,int larg_painel, int alt_painel, ArrayList<obstaculos> muros) {
		this.forma = forma;
		this.width = 50; this.height = 50;
		if(this.forma == 'P') {
			this.width = 70;
		}
		gerarPosicaoValida(larg_painel, alt_painel, muros);
		this.CorFundo = Color.BLACK; 
		this.CorFundoAtv = Color.YELLOW;
		this.CorBorda = Color.YELLOW;
		this.CorBordaAtv= Color.BLACK;
		this.CorFundoAt = this.CorFundo;
		this.CorBordaAt = this.CorBorda;
		this.ativado = false;
		
	}
	public void mostrarPlayer(Graphics2D d2) {
		if(this.forma == 'R') {
			//System.out.println(this.CorFundoAt);
			d2.setColor(this.CorFundoAt);
			d2.fillRect(this.x, this.y, this.width, this.height);
			d2.setColor(this.CorBordaAt);
			d2.drawRect(this.x, this.y, this.width, this.height);
		} else if(this.forma == 'O') {
			d2.setColor(this.CorFundoAt);
			//System.out.println(this.CorFundoAt);
			d2.fillOval(this.x, this.y, this.width, this.height);
			d2.setColor(this.CorBordaAt);
			d2.drawOval(this.x, this.y, this.width, this.height);
		} else if(this.forma == 'P'){
			d2.setColor(this.CorFundoAt);
			d2.fillRect(this.x, this.y, this.width, this.height);
			d2.setColor(this.CorBordaAt);
			d2.drawRect(this.x, this.y, this.width, this.height);
		}
	}
	public boolean estaAtivo() {
		return this.ativado;
	}
	public boolean verifColisaoCenario(char direcao, int passo) {
		boolean colidiu = false;
		switch(direcao) {
		case 'C':
			if((this.y - passo) <= 0) {
				colidiu = true;
			}
			break;
		case 'E':
			if((this.x - passo) <= 0) {
				colidiu = true;
			}
		break;
		case 'B':
			if((this.y + passo) >= (500 - this.width)) {
				colidiu = true;
			}
		break;
		case 'D':
			if((this.x + passo) >= (800 - this.height)) {
				colidiu = true;
			}
		break;
		}
		return colidiu;
	}
	public void moverPlayer(char direcao,int passo) {
		if(!verifColisaoCenario(direcao, passo)) {
			if(direcao == 'C') {
				this.y -= passo;
			} else if(direcao == 'E') {
				this.x -= passo;
			} else if(direcao == 'B') {
				this.y += passo;
			} else if(direcao == 'D') {
			this.x += passo;
			}
		}
	}
	public boolean veriAtivPlayer(int px, int py) {
		this.ativado = false;
		if(px >= this.x && px <= (this.x + this.width)) {
			if(py >= this.y && py <= (this.y + this.height)) {
				this.ativado = true;
			}
		}
		return this.ativado;
	}
	public void ativarplayer(boolean ativar) {
		if(ativar) {
			System.out.println("Ativado");
			this.CorBordaAt = this.CorBordaAtv;
			this.CorFundoAt = this.CorFundoAtv;
		} else {
			this.CorBordaAt = this.CorBorda;
			this.CorFundoAt = this.CorFundo;
		}
	}
	public boolean verifColisoes(char D,int P, ArrayList<obstaculos> muros, ArrayList<player> players) {
		int oldX = this.x;
		int oldY = this.y;
		
		moverPlayer(D, P);
		
		for(obstaculos M : muros) {
			if(this.intersects(M)) {
				
				this.x = oldX;
				this.y = oldY;
				System.out.println("Colidiu com muro");
				return true;
			}
			
		}
		for (player p : players) {
	        if (p != this && this.intersects(p)) {
	            this.x = oldX;
	            this.y = oldY;
	            System.out.println("Colidiu com player");
	            return true;
	        }
	    }

	    return false;
		
	}
	
	private void gerarPosicaoValida(int larg_painel, int alt_painel, ArrayList<obstaculos> muros) {
	    boolean posicaoValida = false;

	    while (!posicaoValida) {
	        this.x = (int) Math.floor(Math.random() * (larg_painel - this.width));
	        this.y = (int) Math.floor(Math.random() * (alt_painel - this.height));

	        posicaoValida = true;

	        for (obstaculos m : muros) {
	            if (this.intersects(m)) {
	                posicaoValida = false;
	                break;
	            }
	        }
	    }
	}
}
