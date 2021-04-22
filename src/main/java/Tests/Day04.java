package Tests;
import org.junit.Test;
import utilities.DataBaseConnector2;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertTrue;

public class Day04 {
    String query1;
    List<Map<String, String>> dataList;

    @Test
    public void us01(){

        query1="select * from Empl_satisMiktari where satis_sayisi < (select AVG(satis_sayisi) as ortalama from Empl_satisMiktari) ;";
        dataList= DataBaseConnector2.getQueryResultWithAListMap(query1);
        System.out.println(dataList);
        assertTrue(dataList.size()==4);


    }
    /*create view Empl_satisMiktari
as
select count(suppliers.company_name) as satis_sayisi,
employees.first_name || ' ' || employees.last_name as ad_soyad
from suppliers
join products on suppliers.supplier_id=products.supplier_id
join order_details on products.product_id=order_details.product_id
join orders on order_details.order_id=orders.order_id
join employees on orders.employee_id=employees.employee_id
group by employees.first_name, employees.last_name order by count(suppliers.company_name) desc;

select AVG(satis_sayisi) as ortalama from Empl_satisMiktari;


select * from Empl_satisMiktari where satis_sayisi < (select AVG(satis_sayisi) as ortalama from Empl_satisMiktari) ;*/

}
