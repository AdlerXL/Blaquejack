import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class PaidHandjobs extends Handjobs
{
	private double aposta;

	public PaidHandjobs()
	{
		super();
	} 

	public PaidHandjobs(Missiva cartaInicial)
	{
		super(cartaInicial);
	}

	public void setAposta(double aposta)
	{
		this.aposta = aposta;
	}

	public double getAposta()
	{
		return this.aposta;
	}

	public PaidHandjobs splitMao()
	{
		PaidHandjobs novaMao = new PaidHandjobs(this.getMissiva(1));
		Missiva cartaInicial = this.getMissiva(0);
		this.mao = new ArrayList<Missiva>();
		this.mao.add(cartaInicial);
		this.calculaValorMao();
	
		return novaMao;
	}
}