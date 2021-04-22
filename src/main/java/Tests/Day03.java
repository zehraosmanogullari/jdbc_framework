package Tests;
import org.junit.Assert;
import org.junit.Test;
import utilities.DataBaseConnector2;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertTrue;

public class Day03 {
    String query1;
    List<Map<String,String>> dataList = new ArrayList<>();

    @Test
    public void us01() throws SQLException {

        //--suppliers region.u 'OR' olan product name.leri nedir?
        // suppliers ve products tabloları kullanılacak, 3 adet ürün listelendigini dogrulayiniz.
        query1= "select product_name \n" +
                "from products join suppliers on products.supplier_id=suppliers.supplier_id \n" +
                "where region='OR'";

        dataList  = DataBaseConnector2.getQueryResultWithAListMap(query1);
        System.out.println(dataList.size());
        assertTrue(dataList.size()==3);

    }
    @Test
    public void us02(){
        query1="select contact_title,region from suppliers where contact_title='Owner';";

        dataList = DataBaseConnector2.getQueryResultWithAListMap(query1);
        System.out.println(dataList);
        Assert.assertEquals(dataList.get(0).get("contact_title"),"Owner");
        Assert.assertEquals(dataList.get(0).get("region"),null);

    }

    @Test
    public void us03(){
        query1="select distinct city from customers";
        dataList = DataBaseConnector2.getQueryResultWithAListMap(query1);
        System.out.println(dataList);
        Assert.assertEquals(dataList.size(),69);


    }
    @Test
    public void us04(){
        query1= "select distinct suppliers.company_name, employees.first_name from suppliers \n" +
                "inner  join products on suppliers.supplier_id=products.supplier_id\n" +
                "inner  join order_details on products.product_id=order_details.product_id\n" +
                "inner  join orders on order_details.order_id=orders.order_id\n" +
                "inner  join employees on orders.employee_id=employees.employee_id\n" +
                "where employees.first_name='Nancy';";


        dataList = DataBaseConnector2.getQueryResultWithAListMap(query1);
        System.out.println(dataList.size());
        assertTrue(dataList.size()==29);
    }
}
