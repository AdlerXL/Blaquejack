import java.util.ArrayList;
import java.util.*;
import javax.swing.*;
/////TODO:
///CONSERTA A PORRA DOS IMPORTS
///BOTA THIS NAS COISAS
///COLOCA INTERFACE BONITA
///BEIJOS
public class BlaqueJaque
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Quantos filhos da puta vao jogar essa merda??(1 a 928434)");	
		int jogadores = scan.nextInt();
		while(jogadores > 928434)
		{
			System.out.println("AH NAO VEI AH NAO VEI AH NAO VEI AH NAO VEI");
			System.out.println("VOU PERGUNTAR DE NOVO, QUANTOS FILHOS DA PUTA??(1 a 928434)");	
			jogadores = scan.nextInt();			
		}
		new Mesa(jogadores);
	}	
}