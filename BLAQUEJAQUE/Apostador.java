import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class Apostador extends Jogador
{
	private double granaPreta;
	private PaidHandjobs maoNormal;
	private PaidHandjobs maoSplit;
	private PaidHandjobs mao;


	public Apostador(double granaInicial, String nome)
	{
		super(nome);
		this.granaPreta = granaInicial;
		this.maoNormal = new PaidHandjobs();
		this.mao = maoNormal;
	}

	@Override
	public void iniciaTurno()
	{
		this.maoSplit = null;
		this.mao.limpaMao();
		decideAposta();
		this.mao.hit();
		this.mao.hit();
	}

	@Override
	public void decideJogada()
	{
		System.out.println("\n\n\n\n\n");
		this.imprimeInformacoes();
		if(this.mao.verificaBlackJack())
		{
			System.out.println("BlackJack!");
			return;
		}

		Scanner scan = new Scanner(System.in);
		char input;
		System.out.println("Eai?\n(H)it/(D)ouble/(s)tand" + 
						((this.verificaSplit())?"/(S)plit":""));

		input = scan.next().charAt(0);

 		switch (input)
 		{
 			case 'H':
 		 		this.numeroJogadas++;
 				this.mao.hit();
 				break;

 			case 'D':
 			 	this.numeroJogadas++;
 				this.doubleValor();
 				return;

 			case 'S':
 				if(this.verificaSplit())
 				{	
 					this.numeroJogadas++;
 					this.split();
 					return;
 				}

 				System.out.println("TEU CU E O JACK E MEU PAU É O BLACK");
 				break;

 			case 's':
 				this.imprimeInformacoes();
 				return;

 			default:
 				System.out.println("Mas ce é ninja mesmo em!");
 				break;
		}

		if(this.mao.getValorMao() < 21)
		{
			decideJogada();
		}
		else if(this.mao.getValorMao() == 21)
		{
			System.out.println("MANDO VER PARÇA YIPEEEEEEEEEE");
		}
		else
		{
			this.imprimeInformacoes();
			System.out.println("KKKKKK K SE FODEU MERMAO KKKKK");
		}
	}

	public void decideAposta()
	{
		System.out.println("Aposta de:" + this.nome);
		Scanner scan = new Scanner(System.in);
		System.out.println("Aposta ai, comedia:");	
		double aposta = scan.nextDouble();

		if(aposta > granaPreta || aposta <= 0)
		{
			System.out.println("KKKKKKKKKKKKJ SEU SHINJI");
			decideAposta();
		}
		else
		{
			this.mao.setAposta(aposta);
			this.granaPreta -= this.mao.getAposta();
		}
	}

	@Override
	protected void imprimeInformacoes()
	{
		System.out.println("Jogador: " + this.nome);
		System.out.println("Dinheiro: " + this.granaPreta);
		System.out.println("Aposta: " + this.mao.getAposta());
		this.mao.imprimeMao();
		System.out.println("Valor da mão: " + this.mao.getValorMao());
	}

	private void doubleValor()
	{
		if(granaPreta > this.mao.getAposta())
		{

			granaPreta -= this.mao.getAposta();
			this.mao.setAposta(2*this.mao.getAposta());
			this.mao.hit();
			this.imprimeInformacoes();
		}
		else
		{
			System.out.println("SEU DESGRACADOFDP VC NAO TEM GRANA SUE PUTO");
			this.decideJogada();
		}
	}

	private void split()
	{
		this.maoSplit = this.maoNormal.splitMao();
		this.mao = this.maoSplit;

		this.decideAposta();
		this.decideJogada();

		this.mao = this.maoNormal;
		this.decideJogada();	
	}

	private Boolean verificaSplit()
	{
		if(this.numeroJogadas == 0)
		{
			if(this.mao.getMissiva(0).getNumero() == this.mao.getMissiva(1).getNumero())
			{
				return true;
			}
		}
		return false;
	}

	public void verificaVitoria()
	{
		verificaVitoriaMao();
		if(this.maoSplit != null)
		{
			this.mao = this.maoSplit;
			verificaVitoriaMao();
		}
		

	}
	public void verificaVitoriaMao()
	{
		int valorMao = this.mao.getValorMao();
		int maoCroupier = Croupier.getCroupier().getMao().getValorMao();

		if(valorMao <= 21)
		{
			if(maoCroupier <= 21)
			{
				if(valorMao > maoCroupier)
				{
					this.vitoria();
					return;
				}
				else if(valorMao == maoCroupier)
				{
					this.granaPreta += this.mao.getAposta();
					return;
				}
			}
			else
			{
				this.vitoria();
				return;
			}
		}
		System.out.println("BANCA GANHOU SEU LIXO");
	}

	private void vitoria()
	{
		if(this.mao.verificaBlackJack())
		{
			System.out.print("BlackJack de " + this.nome + "!!!");
			System.out.println(" Ganhou $" + (this.mao.getAposta() + (1.5 * this.mao.getAposta())));
			this.granaPreta += this.mao.getAposta() + (1.5 * this.mao.getAposta());
		}
		else
		{
			System.out.print(this.nome + " venceu!");
			System.out.println(" Ganhou $" +  (2 * this.mao.getAposta()));
			this.granaPreta += 2 * this.mao.getAposta();
		}
	}
}