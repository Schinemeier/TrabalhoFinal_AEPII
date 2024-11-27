package gestaotransporte;
import java.io.Serializable;

//import java.util.Scanner;

public class Cliente implements Serializable{
	protected Pessoa id;
	protected Pessoa nome;
	protected Pessoa cpf;
	protected Pessoa cidade;
	
	public Cliente(String nome, String cpf, String cidade){
		//gerarId();
	/* 	this.nome = (Pessoa) nome; 
		this.cpf = cpf; 
		this.cidade = cidade;*/
	}

	public static void gerarId(){
		//Pessoa.geraId();
	}
}
