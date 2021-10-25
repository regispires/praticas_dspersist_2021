import java.sql.*;

public class Principal {
    public static void main(String[] args) {
        try {
            Connection conn = ConnectionFactory.getConnection();
            System.out.println("Conexão OK!!!");

            String sql = "select * from teste3 where id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, 6);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                System.out.println(id + " - " + nome);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
