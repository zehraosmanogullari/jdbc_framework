package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.DataBaseConnector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Day02 {

    String query1;
    String query2;
    List<Map<String,String>> dataList1 = new ArrayList<>();
    List<Map<String,String>> dataList2 = new ArrayList<>();
    List<Map<String,String>> dataList3 = new ArrayList<>();
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void us01(){
        //--customer tablosunda sehri berlin olan en az bir musteri vardir
        query1="select city from customers where city='Berlin'";
        dataList1  = DataBaseConnector2.getQueryResultWithAListMap(query1);
        Assert.assertNotEquals(dataList1.size(),0);
        //customers tablosunda sehri london olan musteri sayisi sehri Berlin olan musteri sayisindan fazladir
        query2="select city from customers where city='London'";
        dataList2= DataBaseConnector2.getQueryResultWithAListMap(query2);
        Assert.assertTrue(dataList2.size()>dataList1.size());
    }
    @Test
    public void us02(){
        query1 ="select distinct city,count(*) from customers group by city";
        dataList1 = DataBaseConnector2.getQueryResultWithAListMap(query1);
        Assert.assertTrue(dataList1.size()==69);
    }
    @Test
    public void us03(){
        query1="select products.category_id,count (*) from products group by category_id order by category_id asc";
        dataList1= DataBaseConnector2.getQueryResultWithAListMap(query1);

        String arr[] ={"12","12","13","10","7","6","5","12"};
        int j =0;
        for(int i =0;i<dataList1.size();i++) {
            softAssert.assertEquals(dataList1.get(i).get("count"), ""+arr[j]+"");
            j++;
        }
        softAssert.assertAll();
    }
    @Test
    public void us04(){
        query1= "select count (products.category_id) from products group by category_id order by category_id asc";
        dataList3= DataBaseConnector2.getQueryResultWithAListMap(query1);
        System.out.println(dataList3);
        int sum = 0;
        for (int i=0;i<dataList3.size();i++){
            String count = dataList3.get(i).get("count");
            //System.out.println(count);
            int a =Integer.parseInt(count);
            sum = sum+a;
           // System.out.println(sum);
        }
        System.out.println(sum/8);
        Assert.assertTrue((sum/8)==9);
    }
}
