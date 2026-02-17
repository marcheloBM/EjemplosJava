/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 *
 * @author march
 */
public class Solution {
        public static void main(String[] args) {
        String path= "ruta";
        File file = new File(path);
        String[] directories = file.list(new FilenameFilter() {
          @Override
          public boolean accept(File current, String name) {
            return new File(current,name).isFile();
          }
        });
        System.out.println(Arrays.toString(directories));
//        File var,newvar;int i=1;
//        for (String directory : directories) {
//            var = new File(path+directory);
//            newvar= new File(path+"newName -"+i);
//            var.renameTo(newvar);
//            
//        }
    }

}
