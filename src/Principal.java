import java.util.Scanner;

public class Principal {
	static int tamanho;
	static int nroJogadas;
	
	public static void main(String[] args) {

		int verifica;
		Jogador jogadorUm, jogadorDois;
		int continuar = 1;
		
		
		
		Scanner teclado = new Scanner(System.in);

		System.out.println("=================-Jogo da Velha-================");
		System.out.println("Digite o nome do primeiro jogador: ");
		String nomeUm = teclado.nextLine();
		jogadorUm = new Jogador(nomeUm);
		System.out.println("Digite o nome do segundo jogador: ");
		String nomeDois = teclado.nextLine();
		jogadorDois = new Jogador(nomeDois);
		
		do {
		do {
			System.out.println("Qual o tamanho do tabuleiro? (escolha um tamanho maior que 2)");
			tamanho = teclado.nextInt();
			if (tamanho <= 1) {
				System.out.println("Tamanho não permitido.");
			}
		} while (tamanho <= 1);

		JogoDaVelha game = new JogoDaVelha(tamanho);
		System.out.println(game.toString());
		nroJogadas = 0;
		
		do{
		verifica = jogada(jogadorUm, 'X', game);
		if(verifica == 2) {System.out.println("Houve um empate no jogo"); break;}
		if(verifica == 1) {break;}
		verifica = jogada(jogadorDois, 'O', game);
		}while(verifica == 0);
	
		
		System.out.println("Deseja jogar novamente? Digite 1 para continuar");
		continuar = teclado.nextInt();
		}while(continuar == 1);
		
		//verifica ganhador
		if(jogadorUm.getPontos() > jogadorDois.getPontos()) {
		System.out.println("O vencedor é o jogador " + jogadorUm.getNome() + " com " + jogadorUm.getPontos() + " pontos.");
		}
		else if(jogadorDois.getPontos() > jogadorUm.getPontos()) {
			System.out.println("O vencedor é o jogador " + jogadorDois.getNome() + " com " + jogadorDois.getPontos() + " pontos.");
		}
		else {System.out.println("Houve um empate");
		System.out.println(jogadorUm.toString());
		System.out.println(jogadorDois.toString());
		}
		

	}
	
	public static int jogada(Jogador j, char simbolo, JogoDaVelha game) {
		
		
		int linha, coluna; 
		Scanner teclado = new Scanner(System.in);
		 
		boolean continua;
		do {
			System.out.println("Jogador " + j.getNome() + " escolha em que linha deseja marcar o " + simbolo + " :");
			linha = teclado.nextInt();
			System.out.println("Jogador " + j.getNome() + " escolha em que linha deseja marcar o " + simbolo + " :");
			coluna = teclado.nextInt();
			continua = game.realizaJogada(linha, coluna, simbolo);

			if (!continua) {
				System.out.println("Jogada inválida. Jogue novamente.");
			}

		}while (!continua);
		System.out.println(game.toString());
		if(game.verificaGanhador()) {
			System.out.println(j.getNome() + " venceu!");
			j.setPontos(1);
			return 1;
			
		}
		nroJogadas++;
		if(nroJogadas == tamanho*tamanho) {return 2;}
		
		return 0;
		
	}
	
}
