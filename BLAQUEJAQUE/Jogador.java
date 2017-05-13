import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public abstract class Jogador
{
	protected String nome;
	protected int numeroJogadas;

	public Jogador(String nome)
	{
		this.nome = nome;
	}

	public abstract void iniciaTurno();
	public abstract void decideJogada();
	protected abstract void imprimeInformacoes();
	
	public void verificaVitoria()
	{
		return;
	}
}