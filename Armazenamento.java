import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class Armazenamento {
	
	public void criarArquivos(String nomeDoArquivo) throws IOException{
		FileWriter fw = new FileWriter(nomeDoArquivo);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println("Pontuações:\r\n");
		
		pw.printf("\t Usuario \t Tipo \t Pontos\r\n");
		
		pw.println("=====================================");
			for(Usuario usuario: usuariosDoBanco){
				getUsuarioTipoPonto(pw, usuario);
			}
		pw.println("======================================");
		fw.close();
	}
	
	public String leituraDoArquivo(String nomeDoArquivo)throws IOException{
		FileReader fr = new FileReader(nomeDoArquivo);
		BufferedReader br = new BufferedReader(fr);
		
		String texto;
		texto = br.readLine();
		br.close();
		return texto;
	}

	private void getUsuarioTipoPonto(PrintWriter pw, Usuario usuario) {
		String us = usuario.getTipos();
		String[]nomes = us.split(";");
		for(String n: nomes){
			pw.printf(usuario.getNome(),n, usuario.getPontos(n));
		}
	}		

	private List<Usuario> usuariosDoBanco;
	
	public Armazenamento(List<Usuario> usuariosDoBanco) {
	this.usuariosDoBanco = usuariosDoBanco;
	}

	public Usuario pesquisaUsuario(String nome) {
		for(Usuario usuario: usuariosDoBanco){
			if(usuario.getNome() == nome)
				return usuario;
		}
		return null;
	}

	public Usuario adicionarPonto(String nome, int ponto, String tipoDePonto){
		Usuario usuario = getUsuario(nome);
		usuario.adicionaTipo(ponto, tipoDePonto);
		return usuario;
	}

	public int getQuantidadeTipo(String user, String tipoDePonto) {
		Usuario usuario = getUsuario(user);
		return usuario.getPontos(tipoDePonto);
	}

	private Usuario getUsuario(String nome) {
		for(Usuario usuario: usuariosDoBanco){
			if(usuario.getNome() == nome)
				return usuario;
		}
		return null;
	}

	public String usuariosQueReceberamPontos() {
		String nomes = "";
		for(Usuario usuario: usuariosDoBanco)
			if(usuario.isTipo()){
				nomes = nomes + usuario.getNome() + ";";
			}
		return nomes;
	}

	public String pontosRegistrados(String nome) {
		Usuario usuario = getUsuario(nome);
		return usuario.getTipos();
	}

	public void limpa() {
		this.usuariosDoBanco.clear();	
	}

}
