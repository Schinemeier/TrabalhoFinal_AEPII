package gestaotransporte;
import java.io.Serializable;


public class Pessoa implements Serializable{
	protected Integer id = 1000;
	protected String nome;
	protected String cpf;
	protected String cidade;
	
	
	
	public Pessoa(String nome, String cpf, String cidade) {
		//geraId();
		this.nome = nome;
		this.cpf = cpf;
		this.cidade = cidade;
	}
	
	public void geraId(){
		this.id += 1;
	}

}
