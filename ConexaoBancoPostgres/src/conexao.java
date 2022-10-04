import java.sql.Connection;
import java.sql.DriverManager;

public class conexao {

	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	
	public conexao() {

		url = "jdbc:postgressql:/"127.0.0.1:5433"/LocalJava";
		usuario = "postgres";
		senha = "Think#06";
		
		try {
			
			Class.forName("org.postgressql.Driver");/*baixamos do site do Postgresql*/
			con = DriverManager.getConnection(url,usuario,senha);
			
			System.out.println("Conexão realizada com sucesso!");
			
		} catch (Exception e) {
			System.out.println("FALHA NA CONEXÃO!");
			e.printStackTrace();
		}
	}
}
