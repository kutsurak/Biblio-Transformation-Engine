package gr.ekt.transformationengine.core;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/** 
 * RecordSet represents the knowledge about a set of End Note Records
 *
 * Version: 1
 *
 * Date: $Date: 2007-9-21 (Fri, 21 Sep 2007) $
 *
 */

public class RecordSet 
	implements Serializable, Iterable<Record>  {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1629197241860199501L;

	private List<Record> records;
    
    // Define a static logger variable 
    static Logger logger = Logger.getLogger(RecordSet.class);
    
    /**
     * Constructor
     */
    public RecordSet() {
        
        records = new ArrayList<Record>();   
    }
    
    public void addRecord(Record record){
        
        records.add(record);
    }
    
    public List<Record> getRecords() {
	
        return records;

    }

    public void setRecords(List<Record> records) {

        this.records = records;

    }
	
    /**
     * Returns the number of records in the RecordSet.
     * 
     * @return Number of records in the RecordSet.
     */
	public int getSize() {
		return getRecords().size();
	}

	/**
     * Prints information about the RecordSet.
     */
    public void printInfo(){
        
        Iterator<Record> it = records.iterator();
        
        while(it.hasNext()){
            
            Record currentRecord = (Record)it.next();
           
            logger.debug("---- New Record ---");
            currentRecord.printByName("title");
            currentRecord.printByName("authors");
        }
        
    } 
 
    public Iterator<Record> iterator() {
    	return records.iterator();
    }
    
    /**
     * Serializes the result set using an ObjectOutputStream
     * 
     * @param out the ObjectOutputStream to output the serialized object
     * @throws IOException In case the output file does not exist
     */
    private void writeObject(ObjectOutputStream out) throws IOException{
    	out.defaultWriteObject();
    }
    
    /**
     * Restoring a serialized item
     * @param in The ObjectInputStream from which the serialized object will be read
     * @throws IOException In case the imput file does not exist
     * @throws ClassNotFoundException In case the input object is of different Class
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
    	in.defaultReadObject();
    }
    
    
}
