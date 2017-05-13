import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Mesa
{
	private Croupier banca;
	private int numeroDeJogadores;
	private ArrayList<Jogador> jogadores;
	private int apostaTotalRodada;
	private int saldoInicial = 100;
	
	public Mesa(int numeroDeJogadores)
	{
		jogadores = new ArrayList<Jogador>();
		this.banca = Croupier.getCroupier();

		Scanner in = new Scanner(System.in);

		for(int i = 1; i <= numeroDeJogadores; i++)
		{
			System.out.println("Nome do " + i + "º jogador:");
			jogadores.add(new Apostador(saldoInicial,in.nextLine())); 
		}
		Joga();

	}

	public void Joga()
	{
		System.out.println("Hora do duelo: dududududueeeeeel!");

		banca.iniciaTurno();
		for(Jogador jogador : jogadores)
		{
			banca.imprimeInformacoes();
			jogador.iniciaTurno();
		}

		for(Jogador jogador : jogadores)
		{
			banca.imprimeInformacoes();
			jogador.decideJogada();
			//RIP
			//HIAGO BURRO O CERTO EH PIR ATT: ADLER
		}
		
		banca.decideJogada();
		
		for(Jogador jogador : jogadores)
		{
			jogador.verificaVitoria();
		}
	}
}