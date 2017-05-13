import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class Monte
{
	private final int numeroBaralhos = 6;
	private final int numeroDeCartasInicial = 52;
	private int numeroDeCartas;
	private ArrayList<Missiva> baralho;

	public Monte()
	{
		this.baralho = new ArrayList<Missiva>();
		this.numeroDeCartas = numeroDeCartasInicial;

		for(int i = 0; i < numeroBaralhos;i++)
		{
			for(int numero = 1; numero <= 13; numero++)
			{
				for(Naipe naipe : Naipe.values())
				{
					baralho.add(new Missiva(naipe,numero));
				}
			}
		}

		Collections.shuffle(baralho);
	}

	public Missiva distribuirMissiva()
	{
		if(numeroDeCartas == 0)
		{
			return null;
		}

		int cartaAleatoria = (int)(Math.random() * numeroDeCartas);
		Missiva carta = baralho.get(cartaAleatoria);
		baralho.remove(cartaAleatoria);
		return carta;
	}

}