package barbeariakins.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 👈 ESSENCIAL

            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/barbearia_kins",
                "root",
                "2207"
            );

        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return null;
        }
    }
}