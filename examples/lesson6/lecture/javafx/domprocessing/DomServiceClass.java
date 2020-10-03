package lesson6.lecture.javafx.domprocessing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Useful for extracting info from an XML file that has a format like this:
 * <root>
 *   <entry>
 *      <leaf1>
 *         val1a
 *      </leaf1>
 *      <leaf2>
 *         val2a
 *      </leaf2>
 *      ...
 *   </entry>
 *   <entry>
 *      <leaf1>
 *         val1b
 *      </leaf1>
 *      <leaf2>
 *         val2b
 *      </leaf2>
 *      ...
 *   </entry>
 *      ...
 * </root>
 */
public class DomServiceClass implements DomInterface {
    private List<Properties> propertiesList = new ArrayList<>();
    List<String> tagNames;
    HashMap<String, Integer> tagTable = new HashMap<>();

    private String xmlFileName;
    private File file;
    private Document doc;

    /**
     * Builds the DOM tree from the XML input file; the tree is called
     * the Document and is stored in doc instance variable. Also stores
     * the tagnames of leaf nodes in this tree in the tagnames List,
     * and populates the tagTable, which matches each XML node to
     * its position in the tagnames List.
     * 
     * @param filename - fully qualified name of the XML document
     * @throws DomException - thrown if file pointed to by filename does not
     * exist or if XML file does not have legal XML structure (e.g. has no root)
     * 
     */
    public DomServiceClass(String filename) throws DomException {
        this.xmlFileName = filename;
        
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            file = new File(xmlFileName);
            doc = builder.parse(file);
            tagNames = extractLeafTagNames();
            populateTagTable();
        }
        //In Java 8 you can catch multiple Exception types in a single catch statement
        catch (IOException | ParserConfigurationException | SAXException e) {
            String msg = "Exception thrown in DomServiceClass constructor: ";
            msg += e.getMessage();
            throw new DomException(msg);
       }
    }
    
    /**
     * Returns a List of Properties found when searching for XML entries with tag name
     * <code>tagname</code> and corresponding value <code>value</code>. Each Properties
     * found consists of the name/value pairs found in a matching entry.
     */
    public List<Properties> lookupEntry(String tagname, String value) throws DomException {
		if(!tagNames.contains(tagname)) {
			throw new DomException("Tagname " + tagname + " not valid for this XML document");
		}
        NodeList list = doc.getElementsByTagName(tagname);
        lookupUsingNodeList(list, value);
        return propertiesList;
    }
    
    /**
     * Scans all entries having tagname <code>knownTagname</code> and corresponding
     * value <code>knownValue</code>. It examines the first match and returns
     * the value in that entry that corresponds to the tagname <code>desiredTagname</code>. 
     */
    public String lookupValueByName(String knownTagname, String knownValue, String desiredTagname) 
    		throws DomException {
    	List<Properties> props = lookupEntry(knownTagname,  knownValue);
    	if(props != null) {
    		Properties prop = props.get(0);
    		if(prop.containsKey(desiredTagname)) {
    			return prop.getProperty(desiredTagname);
    		}
    	}
    	throw new DomException("Value of " + desiredTagname + " where " + knownTagname 
    			+ " = " + knownValue + " not found");
    }
    
    /**
     *  Provides a list of leaf tag names (that is, 
     *  names of tags whose only children are of type Text). 
     *  Duplicates are removed.
     */
    public List<String> extractLeafTagNames() {
        //* is a wildcard -- gets all nodes in the doc               
    	NodeList nodeList = doc.getElementsByTagName("*");
        int listLen = nodeList.getLength();
        Node n = null;
        Set<String> s = new HashSet<>();
        
        for(int i =0; i<listLen; ++i) {
            n = nodeList.item(i);
            if(representsATagWithBodyContent(n)) {
                s.add(n.getNodeName());
            }
        }
        List<String> retval = new ArrayList<>();
        retval.addAll(s);
        return retval;   
    }
    
    ////////////// private methods //////////////////

    private void lookupUsingNodeList(NodeList list, String value) {

        if (list == null || list.getLength() == 0)
                return;
        int len = list.getLength();
        Node n = null;
        Node t = null; //text node
        String key = null;
        for (int i = 0; i < len; ++i) {
            n = list.item(i);
            if (n.hasChildNodes()) {
                t = n.getFirstChild();
                key = t.getNodeValue().trim();
                if (key.equals(value)) {
                        createProperties(n.getParentNode());
                }
            }
        }
    }
    
    /**
     *  This method returns a NodeList with just tagNames.length nodes
     *  corresponding to order in which tagNames occur
     */
    private NodeList order(NodeList list) {
        if(list == null) return null;
        OrderedNodeList retList = new OrderedNodeList(tagNames.size());
        Node n = null;
        String nodeName = null;
        int index = -1;
        for (int i = 0; i < list.getLength(); ++i) {
            n = list.item(i);
            nodeName = n.getNodeName();
        	if(tagTable.containsKey(nodeName)) {
                index = tagTable.get(nodeName);
                retList.setNode(index, n);
        	}     
        }
        return retList;
    }

    private void createProperties(Node entry) {
        if (entry == null || !(entry.hasChildNodes())) return;
        Node t = null;
        NodeList list = order(entry.getChildNodes());

        Node[] nms = new Node[tagNames.size()];
        String[] vals = new String[tagNames.size()];

        for (int i = 0; i < tagNames.size(); ++i) {
            nms[i] = list.item(i);
            if (nms[i].hasChildNodes()) {
                t = nms[i].getFirstChild();
                if (t.getNodeValue() != null) {
                    vals[i] = t.getNodeValue().trim();
                }
            }
        }

        Properties p = new Properties();
        for (int i = 0; i < nms.length; ++i) {
            p.put(nms[i].getNodeName(), vals[i]);
        }

        propertiesList.add(p);
    }

    private void populateTagTable() {
    	for(int i = 0; i < tagNames.size(); ++i) {
    		tagTable.put(tagNames.get(i), i);
    	}
    }
   
    /**
     *  Returns true if node represents a leaf tag having a nonempty body
     */
    private boolean representsATagWithBodyContent(Node n) {
        if(n == null) return false;
        NodeList contents = n.getChildNodes();
        if(contents == null || contents.getLength() != 1) {
            return false;
        }
        Node singleNode = contents.item(0);
        if(singleNode == null || singleNode.getNodeValue().trim().equals("")) {
            return false;
                
        }
        return true;
    }

    class OrderedNodeList implements NodeList {
        private Node[] nodes;
        private int len;

        public OrderedNodeList(int length) {
            len = length;
            nodes = new Node[length];
        }

        public void setNode(int pos, Node n) {
            if (pos >= len)
                return;

            nodes[pos] = n;
        }
        
        @Override
        public Node item(int i) {
        	if (i >= len)
                 return null;
            return nodes[i];
        }
        @Override
        public int getLength() {
            return len;
        }							
    }
    

    /**
     * Notice only the interface is necessary
     */
    public static void main(String[] args) {
        //for the test, we create a file that stores id, phonenum and email address
        String n = System.getProperty("line.separator");
        try {           
            DomInterface xml = new DomServiceClass("src/lesson6/lecture/javafx/domprocessing/test.xml");
            List<String> names = new ArrayList<>();
            names.addAll(xml.extractLeafTagNames());
            
            System.out.println(n + "Here is a list of the tag names:");
            System.out.println(names + n);  
            System.out.println("Looking up phone number of " + "tom_jones@yahoo.com");
            
            //find toms phone number
            String tomsEmail = xml.lookupValueByName("email", "tom_jones@yahoo.com", "phonenum");
            
            //find out all about tom
            List<Properties> propsList = xml.lookupEntry("email", "tom_jones@yahoo.com");
            
            if(tomsEmail != null) {
            	System.out.println("Tom's phone number is " + tomsEmail + n);
            } else {
            	System.out.println("Tom's phone number not found" + n);
            }
            if(propsList != null) {
            	System.out.println("All about Tom: " + n + propsList.get(0));
            } else {
            	System.out.println("Tom's entry was not found");
            }
            
        }
        catch(DomException e) {
            System.out.println(e.getMessage());
        } 
        
    }
}
