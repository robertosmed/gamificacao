import java.util.List;


public interface Placar {
	
	public void registrarTipoDePontoUmUsuario(String usuario, int ponto, String tipoDePonto);
	public String[]getTodosPontosDoUsuario();
	public List<String>getRankingPontos(String tipoDePonto);
}
