package Tests;

import org.junit.Test;
import utilities.DataBaseConnector2;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Day05 {
    String query1;
    List<Map<String, String>> dataList;
    //--en yüksek satis yapan margeret Peacock--10. sorgu icin
    @Test
    public void us01(){
        query1="select count(suppliers.company_name) as satis_sayisi, \n" +
                "employees.first_name || ' ' || employees.last_name as ad_soyad \n" +
                "from suppliers \n" +
                "join products on suppliers.supplier_id=products.supplier_id\n" +
                "join order_details on products.product_id=order_details.product_id\n" +
                "join orders on order_details.order_id=orders.order_id\n" +
                "join employees on orders.employee_id=employees.employee_id\n" +
                "group by employees.first_name, employees.last_name order by count(suppliers.company_name) desc fetch FIRST ROW ONLY;";

        dataList= DataBaseConnector2.getQueryResultWithAListMap(query1);
       // System.out.println(dataList);
       // System.out.println(dataList.get(0).values().toString());
        assertEquals(dataList.get(0).values().toString(),"[420, Margaret Peacock]");
    }
    @Test
    public void us02(){
        query1="select city from customers where city like '%u';";
        dataList = DataBaseConnector2.getQueryResultWithAListMap(query1);
        System.out.println(dataList);
    }

    @Test
    public void sum(){
        String str = "a";
        str.concat("b");
        System.out.println(str);
    }

}
