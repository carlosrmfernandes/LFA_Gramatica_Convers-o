/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Polo UAB
 */
public class GramaticaMatrix {

    void gamaticamatri(String prod, String naotermi, String Termi, String in, String p) {
        HashSet hs = new HashSet();
      

        for (int j = 0; j < prod.length(); j++) {
            hs.add(prod.charAt(j));
        }
       
        System.out.println(hs);
       

        System.out.println(p);
        System.out.println(prod);
    }

}
