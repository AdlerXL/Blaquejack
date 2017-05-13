import java.util.ArrayList;
import java.util.Random;
public class Missiva
{
	private Naipe naipe;
	private String nome;
	private int numero;

	public Missiva(Naipe naipe, int numero)
	{
		this.naipe = naipe;
		this.numero = numero;
		this.nome = determinaNome(numero);
	}

	public static String naipeParaString(Naipe naipe)
	{
		switch(naipe)
		{
			case PAULS:
				return 	"Paus";
			case OUROS:
				return "Ouros";
			case ESPADAS:
				return "Espadas";
			case COPAS:
				return "Copas";
			default:
				return "O SAPO ME TA TROLANO!!!!!!";
		}	
	}

	public int getNumero()
	{
		return numero;
	}

	public static int determinaValor(int numero, Boolean bomberman)
	{
		if(numero == 1)
		{
			if(bomberman)
			{
				return 1;
			}
			else
			{
				return 11;
			}
		}
		else if(numero >= 10)
		{
			return 10;
		}
		else
		{
			return numero;
		}
	}

	public static String determinaNome(int numero)
	{
		switch(numero)
		{
			case 1:
				return "A";
			case 11:
				return "Valete";
			case 12:
				return "Dama";
			case 13:
				return "Rei";
			default:
				return Integer.toString(numero);     	
		}
	}

	public String imprimeCarta()
	{
		return this.nome + " de " + naipeParaString(this.naipe);
	}
}