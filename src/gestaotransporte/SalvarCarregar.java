package gestaotransporte;

//import java.io.DataOutputStream;
//import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.OutputStream;

public class SalvarCarregar implements Serializable {
	
	/*class Pessoa implements Serializable {
		private static final long serialVersionUID = 1L;
		private String nome;
		private int idade;
	}*/
	
	public static void salvar(Pessoa[] pessoa) {
		String arquivo = "database.dat";
			try(FileOutputStream fos = new FileOutputStream(arquivo,true);
			AppendingObjectOutputStream oos = new AppendingObjectOutputStream(fos)){
				oos.writeObject(pessoa);//salvar objeto no arquivo
				oos.newLine();
				System.out.println("Salvo com sucesso!");
			}catch(IOException e) {
				//System.err.println("Erro ao salvar: "+ e.getMessage());
				e.printStackTrace();
			}
			carregar();
	}
		
	public static void carregar() {
		String arquivo = "database.dat";
		
		  try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
			  Pessoa[] pessoasLidas = (Pessoa[]) ois.readObject();//ler objeto do arquivo 
			for(Pessoa pessoa : pessoasLidas){
				System.out.println(pessoa.nome + " " + pessoa.cpf + " " + pessoa.cidade);	
			} 
			  
		  }catch (IOException | ClassNotFoundException e) {
				//System.err.println("Erro ao ler o arquivo: " + e.getMessage());
				e.printStackTrace();
		  }
		
	}
	
}
