public class Croupier extends Jogador
{
	private static Croupier instancia = null;
	private Monte baralho;	
	private Handjobs mao;

	private Croupier()
	{
		super("Croupier");
		this.mao = new Handjobs();
	}
	@Override
	public void iniciaTurno()
	{
		baralho = new Monte();
		this.mao.limpaMao();
		this.mao.hit();
		this.mao.hit();
		this.numeroJogadas = 0;
	}

	@Override
	public void decideJogada()
	{
		while(this.mao.getValorMao() < 17)
		{
			this.numeroJogadas++;
			imprimeInformacoes();
			this.mao.hit();
		}
		
		this.numeroJogadas++;
		imprimeInformacoes();
	}


	@Override
	public void imprimeInformacoes()
	{
		System.out.println("Jogador: Banca");
		if(this.numeroJogadas == 0)
		{
			System.out.println(this.mao.getMissiva(0).imprimeCarta() + ", ???");
		}
		else
		{
			this.mao.imprimeMao();
		}

	}

	public Missiva daMissiva()
	{
		return baralho.distribuirMissiva();
	}

	public static Croupier getCroupier()
	{
		if(instancia == null)
		{
			instancia = new Croupier();
		}
		return instancia;
	}

	public Handjobs getMao()
	{
		return this.mao;
	} 
}