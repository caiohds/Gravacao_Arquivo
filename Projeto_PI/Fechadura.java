import java.io.*;
public class Fechadura extends Produto{
	String marca,tipo,modeloPorta;
	
	public Fechadura(){
		
		super();
		this.marca = "";
		this.tipo = "";
		this.modeloPorta = "";
	}
	public Fechadura(String nome, int quantidade, String codigo, double preco, String marca, String tipo, String modeloPorta){
		super(nome,quantidade,codigo,preco);
		this.marca = marca;
		this.tipo = tipo;
		this.modeloPorta = modeloPorta;
	}
	public void setModeloPorta(String modeloPorta){
		
		this.modeloPorta = modeloPorta;
	}
	public void setMarca(String marca){
		
		this.marca = marca;
	}
	public void setTipo(String tipo){
	
		this.tipo = tipo;
	}
	public String getMarca(){
	
		return this.marca;
	}
	public String getTipo(){
		return this.tipo;
	}
	public String getModeloPorta(){
		
		return this.modeloPorta;
	}
	public String toString(){
		
		return "Nome: " + getNome() + " Quantidade: " + getQuantidade() + " Codigo do Produto: " + getCodigo() + " Preco: " + getPreco() + " Marca: " + this.marca + " Tipo: " + this.tipo + " Modelo da Porta: " + this.modeloPorta;
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
				bw.write(marca);
				bw.write(getSeparador());
				bw.write(tipo);
				bw.write(getSeparador());
				bw.write(modeloPorta);
				bw.newLine();
				bw.close();
			fw.close();
			return true;
		}catch (IOException e){
			
			e.printStackTrace();
			return false;
		}
	}
	public Fechadura[] leDoArquivo(){
		Fechadura[] fechaduras = new Fechadura[100];
		int contador = 0;
		try{
			FileReader fr = new FileReader(getArquivo());
				BufferedReader br = new BufferedReader(fr);
					while(br.ready() && contador <fechaduras.length){
						
						String linha = br.readLine();
						
						//System.out.println(linha);
						String campos[] = linha.split(getSeparador());
						//System.out.println(campos.length);
						if(campos.length == 7){
							
							fechaduras[contador] = new Fechadura(campos[0],Integer.parseInt(campos[1]),campos[2],Double.parseDouble(campos[3]),campos[4],campos[5],campos[6]);
							contador++;
						}
						
					}
				br.close();
			fr.close();
			return fechaduras;
		}catch(IOException e){
			
		return null;
		}	
		
	}
}

