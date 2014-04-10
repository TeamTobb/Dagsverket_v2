package backend;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import static javax.swing.JOptionPane.showMessageDialog;

// URL generator for google maps.
public class URLGenerator {
    public static void generateMapURL(String address, int postalCode, String postPlace){
        try{
            String[] addressArray = address.split(" ");
            String addressURL = "http://www.google.no/maps/dir/Hornebergveien+5,+7038+Trondheim/";
            for(int i = 0; i<addressArray.length; i++){
                if(i<addressArray.length-1){
                    addressURL+= addressArray[i] + "+";
                }
                else{
                    addressURL += addressArray[i];
                }
            }
            addressURL += ",";
            String postalCodeString = "+" + postalCode;
            addressURL += postalCodeString;
            addressURL += "+";
            addressURL += postPlace;
            addressURL+="/";
            addressURL = addressURL.replaceAll("æ", "ae");
            addressURL = addressURL.replaceAll("ø", "ae");
            addressURL = addressURL.replaceAll("å", "ae");
            addressURL = addressURL.replaceAll("Æ", "AE");
            addressURL = addressURL.replaceAll("Ø", "O");
            addressURL = addressURL.replaceAll("Å", "AA");
            try {
                Desktop d = Desktop.getDesktop();
                d.browse(new URI(addressURL));
            } catch(IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        }catch(ArrayIndexOutOfBoundsException e){
            showMessageDialog(null, "Vennligst velg et oppdrag");
        }
    }         
}
