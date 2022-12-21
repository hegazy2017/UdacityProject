/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ahegazy
 */ 
public class test {
    public static void main(String[]args){
       File f = new File("InvoiceHeader.csv");
       
       String fileName = "InvoiceHeader.csv";
       while(!fileName.contains("csv")){
            
        
      
        FileOperations fo = new FileOperations();
        InvoiceLine il = new InvoiceLine("item1Name",300,2);
        InvoiceLine i2 = new InvoiceLine("item2Name",400,3);
        InvoiceLine i3 = new InvoiceLine("item1Name",500,4);
        InvoiceLine i4 = new InvoiceLine("item2Name",600,5);
        InvoiceLine i5 = new InvoiceLine("item3Name",700,6);
        List<InvoiceLine> ilist = new ArrayList<>();
        List<InvoiceLine> ilist2 = new ArrayList<>();
        ilist.add(il);
        ilist.add(i2);
        ilist2.add(i3);
        ilist2.add(i4);
        ilist2.add(i5);
   
        
        InvoiceHeader ih  = new InvoiceHeader(1, fo.getCurrentDate(), "customerName", ilist);
        InvoiceHeader ih2 = new InvoiceHeader(2, fo.getCurrentDate(), "customerName2", ilist2);
        List<InvoiceHeader> invoiceHeader = new ArrayList<>();
        invoiceHeader.add(ih);
        invoiceHeader.add(ih2);

        fo.writeFile(invoiceHeader,f);
        
       List<InvoiceHeader> listInvoicesList = fo.readFile(f);
       for(InvoiceHeader inread : listInvoicesList){
           System.out.println("Read"+inread.getCustomerName());
       }
        
       }

    }
}
