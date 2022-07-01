import java.util.Scanner;
public class OrdemDeServico{
	
	public static void main (String[] args) {
		Scanner leia = new Scanner(System.in);
		String desc, cli, dh, obs;
		
		
		System.out.println("Descricao: ");
		desc = leia.nextLine();
		
		System.out.println("Cliente: ");
		cli = leia.nextLine();
		
		System.out.println("Data/hora: ");
		dh = leia.nextLine();
		
		System.out.println("Observacao: ");
		obs = leia.nextLine();
		Equipamento equip = new Equipamento(desc,cli,dh,obs);
		System.out.println(equip);
		
		equip.gravaNoArquivo();
		
		System.out.println("\nLista de OS abertas: ");
		equip.leDoArquivo();
	}
}

