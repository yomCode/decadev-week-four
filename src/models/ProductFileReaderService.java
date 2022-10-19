package models;

import Interfaces.ProductFileReaderInterface;
import enums.Category;

import java.io.*;
import java.util.*;
import java.lang.*;
public class ProductFileReaderService implements ProductFileReaderInterface {
   public List<Products> productList() {

       List<Products> productsListArray = new ArrayList<>();

       // READING FROM THE PRODUCT FILE

       String line;
       try{
           FileReader file = new FileReader("src/resources/ProductList.csv");
           BufferedReader read = new BufferedReader(file);

           while((line = read.readLine()) != null){
               String[] value = line.split(",");

               Long productId = Long.parseLong(value[0]);
               String productName = value[1];
               Category category = Category.valueOf(value[2]);
               Double ratePerUnit = Double.parseDouble(value[3]);
               Integer quantity = Integer.parseInt(value[4]);
               StringBuilder status = new StringBuilder(value[5]);

               productsListArray.add(new Products(productId, productName, category, ratePerUnit, quantity, status));

           }
       }catch (FileNotFoundException e){
           e.printStackTrace();
       }catch (IOException ex){
           ex.printStackTrace();
       }


       return productsListArray;

   }
}
