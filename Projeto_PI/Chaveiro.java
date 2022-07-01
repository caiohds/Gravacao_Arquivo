import java.io.*;
public class Chaveiro extends Produto {
	String descricao;
	public Chaveiro(){
		super();
		this.descricao = "";		
	}
	public Chaveiro(String nome, int quantidade, String codigo, double preco, String descricao){
		super(nome,quantidade,codigo,preco);
		this.descricao = descricao;
	}
	public void setDescricao(){
	
		this.descricao = descricao;
	}
	public boolean gravaNoArquivo(){
		
		try{
			
			FileWriter fw = new FileWriter(getArquivo(), true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(getNome());
				bw.write(getSeparador());
				bw.write(Integer.toString(getQuantidade()));
				bw.write(getSeparador());
				bw.write(getCodigo());
				bw.write(getSeparador());
				bw.write(Double.toString(getPreco()));
				bw.write(getSeparador());
				bw.write(descricao);
				bw.newLine();
				bw.close();
			fw.close();
			return true;
		}catch (IOException e){
			
			e.printStackTrace();
			return false;
		}
	}
	public Chaveiro[] leDoArquivo(){
		Chaveiro[] chaveiros = new Chaveiro[100];
		int contador = 0;
		try{
			FileReader fr = new FileReader(getArquivo());
				BufferedReader br = new BufferedReader(fr);
					while(br.ready() && contador <chaveiros.length){
						
						String linha = br.readLine();
						
						//System.out.println(linha);
						String campos[] = linha.split(getSeparador());
						//System.out.println(campos.length);
						if(campos.length == 5){
							
							chaveiros[contador] = new Chaveiro(campos[0],Integer.parseInt(campos[1]),campos[2],Double.parseDouble(campos[3]),campos[4]);
							contador++;
						}
						
					}
				br.close();
			fr.close();
			return chaveiros;
		}catch(IOException e){
			
		return null;
		}	
		
	}
}

