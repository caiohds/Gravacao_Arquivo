import java.util.Scanner;
public class Loja{
	
	public static void main (String[] args) {
		Scanner leia = new Scanner(System.in);
		Scanner leia2 = new Scanner(System.in);
		int opcao;
	
		String nome,codigo,marca,tipo,modelo, descricao;
						int quantidade;
						double preco;
		Chave chaves = new Chave();
		Fechadura fechaduras  = new Fechadura();
		Chaveiro chaveiros = new Chaveiro();
		do{
			System.out.println("1-Cadastrar novo produto" + "\n2-Visualizar chaves cadastradas" + "\n3-Visualizar fechaduras cadastradas" +"\n4-Visualizar chaveiros cadastrados"+"\n5-Valor total no estoque"+ "\n0-Finalizar");
			opcao = leia.nextInt();
			switch(opcao){
				case 1:
					System.out.println("1-Cadastrar nova Chave" + "\n2-Cadastrar nova fechadura" + "\n3-Cadastrar novo Chaveiro");
					int opcao2 = leia.nextInt();
					switch(opcao2){
						
						case 1:
						System.out.println("Digite o nome: ");
						nome = leia.next();
						do{
							
							System.out.println("Quantidade: " );
							quantidade = leia2.nextInt();
							if(quantidade <= 0){
								
								System.out.println("Digite um valor maior que 0!");
							}
						}while(quantidade<= 0);
						System.out.println("Digite o codigo: ");
						codigo = leia.next();
						do{
							
							System.out.println("Digite o preco: ");
							preco = leia2.nextDouble();
							if(preco<=0){
								
								System.out.println("Digite um valor maior que 0!");
							}
						}while(preco <=0);
						System.out.println("Digite a marca: ");
						marca = leia.next();
						System.out.println("Digite o tipo: ");
						tipo = leia2.next();
						chaves = new Chave(nome,quantidade,codigo,preco,marca,tipo);
						chaves.gravaNoArquivo();
						break;
						case 2:
						System.out.println("Digite o nome: ");
						nome = leia2.next();
						do{
							
							System.out.println("Quantidade: " );
							quantidade = leia.nextInt();
							if(quantidade<=0){
								
								System.out.println("Digite um valor maior que 0!");
							}
						}while(quantidade<= 0);
						System.out.println("Digite o codigo: ");
						codigo = leia2.next();
						do{
							
							System.out.println("Digite o preco: ");
							preco = leia.nextDouble();
							if(preco <=0){
								System.out.println("Digite um valor maior que 0!");
							}
						}while(preco <=0);
						System.out.println("Digite a marca: ");
						marca = leia2.next();
						System.out.println("Digite o tipo: ");
						tipo = leia.next();
						System.out.println("Digite o modelo da porta: ");
						modelo = leia2.next();
						fechaduras= new Fechadura(nome,quantidade,codigo,preco,marca,tipo,modelo);
						fechaduras.gravaNoArquivo();
						break;
						case 3:
						System.out.println("Digite o nome: ");
						nome = leia2.next();
						do{
							
							System.out.println("Quantidade: " );
							quantidade = leia.nextInt();
							if(quantidade<=0){
								System.out.println("Digite um valor maior que 0!");
							}
						}while(quantidade<=0);
						System.out.println("Digite o codigo: ");
						codigo = leia2.next();
						do{
							
							System.out.println("Digite o preco: ");
							preco = leia.nextDouble();
							if(preco<=0 ){
								
								System.out.println("Digite um valor maior que o!");
							}
						}while(preco <=0);
						System.out.println("Digite a descricao: ");
						descricao = leia2.next();
						chaveiros = new Chaveiro(nome,quantidade,codigo,preco,descricao);
						chaveiros.gravaNoArquivo();
						break;
					}
					break;
					case 2:
					Chave chaveLeitor[] = chaves.leDoArquivo();
					for(int indice = 0; indice<chaveLeitor.length;indice++){
						
						if(chaveLeitor[indice] != null){
							
							System.out.println(chaveLeitor[indice]);
						}
					}
					break;
					case 3:
					Fechadura fechaduraLeitor[] = fechaduras.leDoArquivo();
					for(int indice = 0; indice<fechaduraLeitor.length;indice++){
						
						if(fechaduraLeitor[indice] != null){
							
							System.out.println(fechaduraLeitor[indice]);
						}
					}
					break;
					case 4:
					Chaveiro chaveiroLeitor[] = chaveiros.leDoArquivo();
					for(int indice = 0; indice<chaveiroLeitor.length;indice++){
						
						if(chaveiroLeitor[indice] != null){
							
							System.out.println(chaveiroLeitor[indice]);
						}
					}
					break;
					case 5:
					Produto produto = new Produto();
					System.out.println("Valor total no estoque: " + produto.valor_total());
					break;
					case 0:
					System.out.println("Sistema Finalizado!");
					break;
					default:
					System.out.println("Opcao invalida!");
					break;
				
			}
			
		}while(opcao != 0);
		
		
	}
}

