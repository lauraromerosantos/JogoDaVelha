
public class JogoDaVelha {


	private char tabuleiro[][];
	
	public JogoDaVelha(int tamanho) {
		tabuleiro = new char[tamanho][tamanho];
		for(int linha = 0; linha < tabuleiro.length; linha++){
			for(int col = 0; col < tabuleiro[0].length; col++){
				tabuleiro[linha][col] = ' ';
			
			}
		}
		
	}
	
	
	public boolean realizaJogada(int lin, int col, char jogada) {
		if(tabuleiro[lin][col] != 'X' && tabuleiro[lin][col] != 'O') {
			tabuleiro[lin][col] = jogada;
			return true;
		}
		else {return false;
		}
	}
	
	public boolean verificaGanhador() {
		char aux = ' ';
		int cont = 0;
		
		
		//verificação de linhas
		for(int linha = 0; linha < tabuleiro.length; linha++){
			for(int col = 0; col < tabuleiro[0].length; col++){
				
				if(col == 0) {
					
					if(tabuleiro[linha][col] != 'X' && tabuleiro[linha][col] != 'O') {
						break;
					}
					
					aux = tabuleiro[linha][col];
					cont = 0;
					}
				
				
				if(tabuleiro[linha][col] == aux) {
					cont++;
				}
			
				if(cont == tabuleiro.length) {
					return true;
				}
				
					}
						}
		
		cont = 0;
		
		//verificação de colunas
		for(int col = 0; col < tabuleiro[0].length; col++){
			for(int linha = 0; linha < tabuleiro.length; linha++){
			
				
				if(linha == 0) {
					
					if(tabuleiro[linha][col] != 'X' && tabuleiro[linha][col] != 'O') {
						break;
					}
					
					aux = tabuleiro[linha][col];
					cont = 0;
					}
				
				
				if(tabuleiro[linha][col] == aux) {
					cont++;
				}
			
				if(cont == tabuleiro.length) {
					return true;
				}
				
					}
						}
		
		cont = 0;
		
		//verificação diagonal principal
		for(int linha = 0; linha < tabuleiro.length; linha++){
			for(int col = 0; col < tabuleiro[0].length; col++){
				if(linha != col) {continue;}
				if(linha == 0){
					if(tabuleiro[linha][col] != 'X' && tabuleiro[linha][col] != 'O') {
						break;
					}
					
					aux = tabuleiro[linha][col];
					cont = 0;
				}
				
				//if(linha == col) {
				if(tabuleiro[linha][col] == aux) {
					cont++;
					}
				//}
				
				if(cont == tabuleiro.length) {
					return true;
				}
			}
		}
		
		cont = 0;
		//diagonal secundária
		for(int linha = 0; linha < tabuleiro.length; linha++){
			for(int col = 0; col < tabuleiro[0].length; col++){
				if((linha+col+1) != tabuleiro.length) {continue;}
				if(linha == 0 && col == tabuleiro.length-1){
					if(tabuleiro[linha][col] != 'X' && tabuleiro[linha][col] != 'O') {
						break;
					}
					
					aux = tabuleiro[linha][col];
					cont = 0;
				}
				
				
				//if((linha+col+1) == tabuleiro.length) {
				if(tabuleiro[linha][col] == aux) {
					cont++;
				}
					//}
				
				if(cont == tabuleiro.length) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public String toString() {
		String estadoJogo = "";
		for(int linha = 0; linha < tabuleiro.length; linha++){
			for(int col = 0; col < tabuleiro[0].length; col++){
				estadoJogo += " " + tabuleiro[linha][col] + " |";
				}
			estadoJogo += "\n";
		}
		return estadoJogo;
	}
	
}