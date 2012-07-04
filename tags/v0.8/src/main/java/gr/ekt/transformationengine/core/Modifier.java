/**
 * 
 */
package gr.ekt.transformationengine.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import gr.ekt.transformationengine.exceptions.UnimplementedAbstractMethod;
import gr.ekt.transformationengine.exceptions.UnsupportedComparatorMode;
import gr.ekt.transformationengine.exceptions.UnsupportedCriterion;

/**
 * @author kstamatis
 *
 */
public abstract class Modifier extends ProcessingStep{

	/**
	 * 
	 */
	public Modifier() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see gr.ekt.transformationengine.core.ProcessingStep#initialize()
	 */
	@Override
	public void initialize() {
	}

	/* (non-Javadoc)
	 * @see gr.ekt.transformationengine.core.ProcessingStep#process(gr.ekt.transformationengine.core.Record)
	 */
	@Override
	public boolean process(Record record) throws UnimplementedAbstractMethod,
			UnsupportedComparatorMode, UnsupportedCriterion {

		this.modify(record);
		
		return true;
		
	}

	/* (non-Javadoc)
	 * @see gr.ekt.transformationengine.core.ProcessingStep#process(gr.ekt.transformationengine.core.RecordSet)
	 */
	@Override
	public RecordSet process(RecordSet recordSet)
			throws UnimplementedAbstractMethod, UnsupportedComparatorMode,
			UnsupportedCriterion {

		RecordSet resultRecordSet = new RecordSet();

		Iterator<Record> it = recordSet.getRecords().iterator();
		while (it.hasNext()) {
			Record record = (Record) it.next();

			if(process(record)) {
				resultRecordSet.getRecords().add(record);
			}
		}
		
		return resultRecordSet;
	}

	/**
	 * 
	 * @param record
	 * @return
	 * @throws UnimplementedAbstractMethod
	 */
    //public abstract Map<String, ArrayList<String>> modify(Record record)throws UnimplementedAbstractMethod;

    public abstract void modify(Record record)throws UnimplementedAbstractMethod;
    
}
