import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class Handjobs
{
	protected ArrayList<Missiva> mao; 
	private int valorMao;

	public Handjobs()
	{
		this.mao = new ArrayList<Missiva>();
	}	

	public Handjobs(Missiva cartaInicial)
	{
		this.mao = new ArrayList<Missiva>();
		this.mao.add(cartaInicial);
		this.calculaValorMao();
	}

	protected void calculaValorMao()
	{
		this.valorMao = 0;
		for(Missiva carta : mao)
		{
			this.valorMao += Missiva.determinaValor(carta.getNumero(),false);
		}			

		if(this.valorMao > 21)
		{
			this.valorMao = 0;
			for(Missiva carta: mao)
			{
				this.valorMao += Missiva.determinaValor(carta.getNumero(),true);
			}
		}
	}

	public void hit()
	{
		this.mao.add(Croupier.getCroupier().daMissiva());
		this.calculaValorMao();
	}	

	public void imprimeMao()
	{
		String maoStr = new String();
		for(Missiva carta : this.mao)
		{
			maoStr += carta.imprimeCarta();
			maoStr += ", ";
		}
		System.out.println(maoStr);
	}	

	public int getValorMao()
	{
		return this.valorMao;
	}

	public Missiva getMissiva(int index)
	{
		return this.mao.get(index);
	}

	public void limpaMao()
	{
		mao.clear();
	}

	public Boolean verificaBlackJack()
	{
		if(this.mao.size() == 2 && this.valorMao == 21)
		{
			return true;
		}
		return false;
	}
}