package modelo;
import java.util.Date;

public class Documento {

	private String titulo;
	private int id;
	private String cod_verificacao;
	private String conteudo;
	private Date data_criacao;
	
	public Documento(String titulo, int id, String cod_verificacao, String conteudo, Date data_criacao) {
	
		this.titulo = titulo;
		this.id = id;
		this.cod_verificacao = cod_verificacao;
		this.conteudo = conteudo;
		this.data_criacao = data_criacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCod_verificacao() {
		return cod_verificacao;
	}

	public void setCod_verificacao(String cod_verificacao) {
		this.cod_verificacao = cod_verificacao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}
}
