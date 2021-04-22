package Tests;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import utilities.DataBaseConnector2;

import java.util.List;
import java.util.Map;

public class Day07 {
    List<Map<String, String>> dataList1;
    List<Map<String, String>> dataList2;

    @Test
    public void Q1(){
        String query1 = "select * from customers;";
        dataList1 = DataBaseConnector2.getQueryResultWithAListMap(query1);
        System.out.println(dataList1.size());


        String query2 = "insert into customers(company_name,customer_id) \n" +
                        "select company_name,supplier_id \n" +
                        "from suppliers ORDER BY random() LIMIT 1 ;";
        DataBaseConnector2.executeInsertQuery(query2);

        String query3 = "select * from customers;";
        dataList2 = DataBaseConnector2.getQueryResultWithAListMap(query3);
        System.out.println(dataList2.size());
        Assert.assertTrue(dataList1.size()+1==dataList2.size());
    }

    @Test
    public void Q2(){
        String query1 = "select * from customers;";
        dataList1 = DataBaseConnector2.getQueryResultWithAListMap(query1);
        System.out.println(dataList1.size());


        String query2 = "insert into customers(company_name,customer_id) \n" +
                "select company_name,supplier_id \n" +
                "from suppliers ORDER BY random() LIMIT 1 ;";
        DataBaseConnector2.executeInsertQuery(query2);


        String query3 = "select * from customers;";
        dataList2 = DataBaseConnector2.getQueryResultWithAListMap(query3);
        System.out.println(dataList2.size());
        Assert.assertTrue(dataList1.size()+1==dataList2.size());

    }
}
