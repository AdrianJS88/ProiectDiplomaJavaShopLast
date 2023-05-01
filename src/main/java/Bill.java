import java.sql.*;
import java.util.Scanner;

public class Bill {

    public static String generateBill() {

        int sum = 0;
        String message = null;
        int val = 0;
        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL

            Main.dbaccessCartList.readCartListOfAnUser();
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT SUM(prodprice * cart.prodquantity )    FROM cart  ");
            while (res.next()) {
                int c = res.getInt(1);
                sum = sum + c;
            }
            System.out.println("Total sum of your products is : " + sum + "$");
            System.out.println("             ");

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return message;
    }

}






