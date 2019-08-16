
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Usuario {
	
	private String nome;
	private Map<String, Integer> tipos = new HashMap<String, Integer>();
	private List<Usuario> usuariosDoBanco;
	
	public Usuario(List<Usuario> usuariosDoBanco){
		this.usuariosDoBanco = usuariosDoBanco;
	}

	public Usuario(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
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

	int getPontos(String tipoDePonto) {
		if(tipos.containsKey(tipoDePonto)){
		return tipos.get(tipoDePonto);
		}
		return 0;
	}

	public void adicionaTipo(int ponto, String tipoDePonto) {
		tipos.put(tipoDePonto, this.getPontos(tipoDePonto) + ponto);
		
	}

	public boolean isTipo() {
		if(tipos.isEmpty()){
			return false;
		}
		return true;
	}

	public String getTipos() {
		String user = "";
		Set<String> chaves = tipos.keySet();
		for(String chave: chaves){
			if(chave != null)
				user += chave + ";"; 
		}
		return user;
	}

}


