package Tests;

import org.junit.Assert;
import org.junit.Test;
import utilities.DataBaseConnector2;

import java.util.List;
import java.util.Map;

public class Day06 {
    String query1;
    List<Map<String, String>> dataList;

    @Test
    public void us01_01(){

        query1="select * from suppliers where company_name like 'L%';";
        dataList= DataBaseConnector2.getQueryResultWithAListMap(query1);
        Assert.assertEquals(dataList.size(),2);
    }
    @Test
    public void us01_02(){
        query1="select * from suppliers where company_name like '%a%';";
        dataList= DataBaseConnector2.getQueryResultWithAListMap(query1);
        Assert.assertEquals(dataList.size(),23);

    }
    @Test
    public void us01_03(){
        query1="select * from suppliers where company_name like 'a%';";
        dataList= DataBaseConnector2.getQueryResultWithAListMap(query1);
        Assert.assertEquals(dataList.size(),0);

    }
    @Test
    public void us01_04(){

        query1="select supplier_id from suppliers where company_name like '%a%e';";
        dataList= DataBaseConnector2.getQueryResultWithAListMap(query1);
        System.out.println(dataList);
        Assert.assertEquals(dataList.get(0).get("supplier_id"),"24");
        Assert.assertEquals(dataList.get(1).get("supplier_id"),"28");
    }
    @Test
    public void us01_05(){

        query1="select * from suppliers where company_name like '%u%e%';";
        dataList= DataBaseConnector2.getQueryResultWithAListMap(query1);
        Assert.assertEquals(dataList.size(),6);
    }
    @Test
    public void us01_06(){

        query1="select * from suppliers where company_name like '%e%u%';";
        dataList= DataBaseConnector2.getQueryResultWithAListMap(query1);
        Assert.assertEquals(dataList.size(),5);
    }

    @Test
    public void us05(){

        query1="select * from products where product_name not like '____' and quantity_per_unit  like '3%'";
        dataList= DataBaseConnector2.getQueryResultWithAListMap(query1);
        int count =0;
        for (int i=0; i<dataList.size();i++) {
            System.out.println(dataList.get(i).get("supplier_id"));
            if(dataList.get(i).get("supplier_id").equals("2")){
                count++;
            }
        }
        System.out.println(count);
        Assert.assertEquals(count,2);
    }

}
