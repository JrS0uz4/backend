package hash;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GerarHash {

	private long cpf;
	private long timestamp;
	private long hash;
	private long hash2; // calculo do hash em cima do timestamp
	private long soma_hashs;
	Scanner sc = new Scanner(System.in);

	public GerarHash() {}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public long getHash() {
		return hash;
	}

	public void setHash(long hash) {
		this.hash = hash;
	}

	public long getHash2() {
		return hash2;
	}

	public void setHash2(long hash2) {
		this.hash2 = hash2;
	}

	public long getSoma_hashs() {
		return soma_hashs;
	}

	public void setSoma_hashs(long soma_hashs) {
		this.soma_hashs = soma_hashs;
	}
	
	public void calcularHash() {
		
		// pega data e hora do sistema
		LocalDateTime agora = LocalDateTime.now();
		
		// coverção da string data/hora atual para o formato de 13 digitos
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("ddMMuuuuHHmmss");
		String dataFormatada = formatterData.format(agora);
		
		System.out.println(dataFormatada);
		timestamp = Long.parseLong(dataFormatada);
		
		System.out.println("Informe o CPF: ");
		cpf = sc.nextLong();
		
		// calculos para gerar o hash
		hash = cpf + (7*89);
		hash = (long) Math.cbrt(hash);
		
		hash2 = timestamp + (7*89);
		hash2 = (long) Math.cbrt(hash2);
		
		soma_hashs = hash + hash2;
		// converção para hexadecimal
	    String str2 = Long.toHexString(soma_hashs);
		
		System.out.println("\nHash: "+ hash + " \nHash Do Timestamp: " + hash2 + "\nSoma total do Hash: " + str2);
		
	}

	public static void main(String[] args) {
		
		new GerarHash().calcularHash();
				
	}

}

