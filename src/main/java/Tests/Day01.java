package Tests;
import org.junit.Test;
import utilities.DataBaseConnector1;
import utilities.DataBaseConnector2;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class Day01 {
    String query1;

    List<Map<String,String>> dataList = new ArrayList<>();


    @Test
    public void us01() throws SQLException {


        query1= "select product_name,category_name \n" +
                "from products join categories on products.category_id=categories.category_id\n" +
                "where category_name='Seafood'";

        dataList  = DataBaseConnector2.getQueryResultWithAListMap(query1);
        System.out.println(dataList );

    }

    @Test
    public void US04(){
        query1 ="select product_name \n" +
                "from products \n" +
                "join suppliers on products.supplier_id=suppliers.supplier_id \n" +
                "where country='Germany'";

        dataList = DataBaseConnector2.getQueryResultWithAListMap(query1);
        //System.out.println(dataList.size());
        assertTrue("urunler'in sayisi 9 degil",dataList.size()==9);
    }


}
