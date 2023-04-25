import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Orders_history {

    public static String insertOrdersHistory() {
        String message = null;
        int val = 0;

        //connect to DB with driver

        try {
            Connection connection = DBconnect.ConexiuneDB();
            Scanner sc = new Scanner(System.in);
            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders_history (prodid, orderid, prodgroup, prodname, prodprice, prodquantity,billid,deliveraddress,f_name,l_name,id_card,exp_card_date,card_cvv) " +
                    "SELECT prodid, orderid, prodgroup, prodname, prodprice, prodquantity, billid, deliveraddress, f_name, l_name, id_card, exp_card_date, card_cvv FROM cart,payments ");


            val = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            String m = e.getMessage();
            if (m.contains("authentication failed for"))
                message = "connection problem";
            else if (m.contains("ERROR: value too long"))
                message = " username or password too long";
            else message = "error";
        }


        System.out.println(" Order   successfully created ");

        return message;
    }


}