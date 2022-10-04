import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoPostgreSQL {

	public static void main(String[] args) {

		String jdbcURL = "jdbc:postgresql://localhost:5433/postgres";
		String username = "postgres";
		String password = "Think#06";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("CONEXÃO COM SUCESSO!");
			
			/*Inserir dados na tabela*/
			String sql = "insert into contacts (first_name, last_name, email)"
					+ " values(?,?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,"Marcio");
			statement.setString(2,"Juvenal");
			statement.setString(3,"pedro.juvenal@gmail.com");
			
			
			/*int rows = statement.executeUpdate(sql);*/
			int rows = statement.executeUpdate();
			
			if(rows > 0) {
				System.out.println("Um novo contato foi adicionado com SUCESSO!");
			}else {
				System.out.println("Novo contato NÃO FOI ADICIONADO!");
			}
			
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("Erro de CONEXÃO AO BANCO!");
			/*e.printStackTrace();*/
		}
		
		
	}

}
