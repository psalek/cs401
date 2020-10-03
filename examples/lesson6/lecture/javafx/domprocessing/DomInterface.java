package lesson6.lecture.javafx.domprocessing;

import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

public interface DomInterface {
          
        /**
         *  Generic lookup is done for all entries
         *  indicated by passed in name and value
         * 
         *  Return value is an array of Properties;
         *  each list item is a Properties matching each
         *  of the tag names with corresponding value --
         *  return value is all discovered in the search
         */
        public List<Properties> lookupEntry(String name, String value) throws DomException;
        
        /**
         * Uses lookupEntry to return a specific field value from an Entry that has been
         * lookedUp
         */
        public String lookupValueByName(String knownTagname, String knownValue, String desiredTagname) 
        		throws DomException;
   
        
        /**
         * Returns the tag names from each leaf node in the DOM tree
         */
        public List<String> extractLeafTagNames();
                
        
        

}
