package inf01120.player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Arquivos {
	private static final String NL = "\n";
	private static final String ERRO_1 = "Erro 1 nao foi possivel ler o arquivo";
	private static final String ERRO_0 = "Erro 0 arquivo nao encontrado";
	private String nome;
	
	Arquivos(String umNome){
		this.nome = umNome;
	}
	
	public String lerTXT(){
		String resultado = "";
		
		try{
			FileReader arquivo = new FileReader(this.nome);
			
			resultado = Arquivos.lerArquivo(arquivo);
		}
		catch(FileNotFoundException e){
			resultado = ERRO_0;
		}
		
		return resultado;
	}
	
	public static String lerTXT(FileReader arquivo){	
		return lerArquivo(arquivo);
	}
	
	private static String lerArquivo(FileReader arquivo){
		String resultado = "";
		
		try{
			BufferedReader buffer = new BufferedReader(arquivo);
			
			String linhaDoArquivo = buffer.readLine();
			
			 while(linhaDoArquivo != null){
				 resultado += linhaDoArquivo + Arquivos.NL;
				 linhaDoArquivo = buffer.readLine();
			 }
			
			arquivo.close();
		}
		catch(FileNotFoundException e){
			resultado = ERRO_0;
		}
		catch(IOException e){
			resultado = ERRO_1;
		}
		
		return resultado;
	}
	
	public void salvaMIDI(String texto){
		
	}
}