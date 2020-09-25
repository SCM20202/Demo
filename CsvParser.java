/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progresssoft;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author celin
 */
public class CsvParser implements TransactionParser{
 
    /**
     *
     * @param fileName
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void CsvParser(File fileName)  throws IOException, FileNotFoundException 
{
        BufferedReader br = new BufferedReader(new FileReader(fileName));  
        List<Transactions> translist = new ArrayList<>();
        String L= br.readLine();
        while ( L != null) {  
       // split on comma(',')  
       String[] TransCsv = L.split(",");  

       // create car object to store values  
       Transactions transObj = new Transactions();  

       // add values from csv to car object  
       transObj.setDescription(transObj[0]);  
       transObj.setDirection(transObj[1]);  
       transObj.setAmount(transObj[2]);  
       transObj.setCurrency(transObj[3]); 

       // adding car objects to a list  
       translist.add(transObj);         
       
} 
}
}
