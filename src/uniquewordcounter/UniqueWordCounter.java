/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uniquewordcounter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author yousufkhan
 */
public class UniqueWordCounter {
    
    public static String foldername ="corpus";
    public static File file = new File("uniqueWord/unique.txt");
    //public static File file =new File("uniqueWord/unique.txt");
    
    
    public static void sortList (List<String> myList){
        int total = myList.size();
        
        System.out.printf("\nCorpus Size - : %s%n", total);
        
                UniqueWordCounter.write_data("Total Word Count: "+total,file);
                
        Set<String> treesetList = new TreeSet<String>(myList);
        int unique = treesetList.size();
        System.out.printf("\nUnique values using TreeSet - Sorted order: %s%n",unique);
        UniqueWordCounter.write_data("Total Unique Word: "+unique,file);
        
          Iterator iterator;
          iterator = treesetList.iterator();
          while (iterator.hasNext()) {
              String word = (String)iterator.next();
                System.out.println(word);
                UniqueWordCounter.write_data(word,file);
           }
    }
    
    public static void write_data(String result,File file){
        
        try{
                if (!file.exists()) {
                    file.createNewFile();
                }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(result);
            bw.newLine();
            bw.close();
            
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String path = "corpus/copy.txt";
        String path =foldername+"/data.txt";
        ReadFile.read(path);
        
        
    }
    
}
