import java.io.*;
public class Equipamento{
	private String descricao, cliente, dataHora, observacao;
	private String arquivo = "dados.txt";
	private String separador = ";";
	public Equipamento(){
		this.descricao = "";
		this.cliente = "";
		this.dataHora = "";
		this.observacao = "";
	}
	public Equipamento(String descricao, String cliente, String dataHora, String observacao){
		
		this.descricao = descricao;
		this.cliente = cliente;
		this.dataHora = dataHora;
		this.observacao = observacao;	
	}
	public void setDescricao(String descricao){
		
		this.descricao = descricao;
	}
	public void setCliente(String cliente){
		
		this.cliente = cliente;
	}
	public void setDataHora(String dataHora){
		
		this.dataHora = dataHora;
	}
	public void setObservacao(String observacao){
		
		this.observacao = observacao;	
	}
	public String toString(){
		
		return "Descricao:  " + this.descricao + 
				" Cliente: " + this.cliente + 
				" Data/Hora: " + this.dataHora +
				" Observacao: " + this.observacao;
	}
	public boolean gravaNoArquivo(){
		
		try{
			
			FileWriter fw = new FileWriter(arquivo, true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(descricao);
				bw.write(separador);
				bw.write(cliente);
				bw.write(separador);
				bw.write(dataHora);
				bw.write(separador);
				bw.write(observacao);
				bw.write(separador);
				bw.newLine();
				bw.close();
			fw.close();
			return true;
		}catch (IOException e){
			
			e.printStackTrace();
			return false;
		}
	}
	public boolean leDoArquivo(){
		
		try{
			FileReader fr = new FileReader(arquivo);
				BufferedReader br = new BufferedReader(fr);
					while(br.ready()){
						
						String linha = br.readLine();
						System.out.println(linha);
					}
				br.close();
			fr.close();
			return true;
		}catch(IOException e){
			
		return false;
		}	
		
	}
}

