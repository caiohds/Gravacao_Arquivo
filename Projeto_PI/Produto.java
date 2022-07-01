import java.io.*;
public class Produto{
	private String nome;
	private int quantidade;
	private String codigo;
	private double preco;
	private String arquivo = "produtos.txt";
	private String separador = ";";
	private String preco1;
	public Produto(String nome, int quantidade, String codigo, double preco){
		
		this.nome = nome;
		this.quantidade = quantidade;
		this.codigo = codigo;
		this.preco = preco;
	}
	public Produto(){
		
		this.nome = "";
		this.quantidade = 0;
		this.codigo = "";
		this.preco = 0;
	}
	public void setNome(String nome){
	
		this.nome = nome;
	}
	public void setQuantidade(int quantidade){
	
		this.quantidade = quantidade;
	}
	public void setCodigo(String codigo){
		
		this.codigo = codigo;
	}
	public void setPreco(double preco){
		
		this.preco = preco;	
	}
	public String getNome(){
	
		return this.nome;
	}
	public int getQuantidade(){
		
		return this.quantidade;
	}
	public String getCodigo(){
	
		return this.codigo;
	}
	public double getPreco(){
		
		return this.preco;
	}
	public String toString(){
		
		return "Nome: " + getNome() + " Quantidade: " + getQuantidade() + " Codigo do Produto: " + getCodigo() + " Preco: " + getPreco();
	}
	
	public String getArquivo(){
	
		return this.arquivo;
	}
	public String getSeparador(){
		
		return this.separador;	
	}
	public double valor_total(){
		try{
			double valor_total = 0;
			FileReader fr = new FileReader(getArquivo());
				BufferedReader br = new BufferedReader(fr);
					while(br.ready()){
						
						String linha = br.readLine();
						
						
						String campos[] = linha.split(getSeparador());
						valor_total += Integer.parseInt(campos[1]) * Double.parseDouble(campos[3]);
						
					}
				br.close();
			fr.close();
			return valor_total;
		}catch(IOException e){
			
		return 0;
		}
	}
}

