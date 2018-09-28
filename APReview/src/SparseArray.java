import java.util.*;

public class SparseArray
{
  private int numRows;
  private int numCols;
  private List<SparseArrayEntry> entries;
  
  public SparseArray(int rows, int cols){
    entries = new ArrayList<SparseArrayEntry>();
    numRows = rows;
    numCols = cols;
  }
  
  public int getNumRows(){
    return numRows;
  }
  
  public int getNumCols(){
    return numCols;
  }
  
  public List<SparseArrayEntry> entries(){
    return entries;
  }
  
  public int getValueAt(int row, int col){
    for (int i = 0; i < entries.size(); i ++)
    {
    	if (entries.get(i).getRow() == row && col == entries.get(i).getCol()) {
    		return entries.get(i).getValue();
    	}
    }
    return 0;
  }
  
  public void removeColumn(int col){
	//  List<SparseArrayEntry> second = new ArrayList<SparseArrayEntry>();
    for (int i = 0; i < entries.size(); i++) {
    	SparseArrayEntry second = entries.get(i);
    	if (second.getCol() == col) {
    		entries.remove(i);
    		i--;
    	}
    	else if (second.getCol() > col) {
    		entries.set(i, new SparseArrayEntry(second.getRow(), second.getCol() - 1, second.getValue()));
    	}
    }
    numCols--;
  }
}