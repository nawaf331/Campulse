/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Misc;

import java.io.File;

/**
 *
 * @author user
 */

 
public class MyImageFilter extends javax.swing.filechooser.FileFilter 
{
    @Override
    public boolean accept(File file) {
       String filename = file.getName();
       if (file.isDirectory())
            return true;
       if( filename.endsWith(".jpg"))
           return true;
       if( filename.endsWith(".png"))
           return true;
       
       return false;
       
    }
    @Override
    public String getDescription() {
        return "*.jpg,*.png";
    }
}


