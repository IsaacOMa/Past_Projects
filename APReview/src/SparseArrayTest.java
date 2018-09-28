public class SparseArrayTest
{
  public static void main(String[] args)
  {
    SparseArray grid = new SparseArray(6, 5);
    SparseArrayEntry e1 = new SparseArrayEntry(1,4,4);
    SparseArrayEntry e2 = new SparseArrayEntry(2,0,1);
    SparseArrayEntry e3 = new SparseArrayEntry(3,1,-9);
    SparseArrayEntry e4 = new SparseArrayEntry(1,1,5);
    
    grid.entries().add(e1);
    grid.entries().add(e2);
    grid.entries().add(e3);
    grid.entries().add(e4);
    
    //testing getValueAt()
    System.out.println("The value for the object at row 3 and column 1 should be -9.");
    System.out.println("The value for the object at row 3 and column 1 is " + grid.getValueAt(3,1) + ".");
    System.out.println("The value for the object at row 3 and column 3 should be 0");
    System.out.println("The value for the object at row 3 and column 3 is " + grid.getValueAt(3,3) + ".");
    
    //testing removeColumn()
    grid.removeColumn(1);
    System.out.println();
    System.out.println("The value for the object at row 2 and column 0 should be 1");
    System.out.println("The value for the object at row 2 and column 0 is " + grid.getValueAt(2,0) + ".");
    System.out.println("The value for the object at row 1 and column 1 should be 0");
    System.out.println("The value for the object at row 1 and column 1 is " + grid.getValueAt(1,1) + ".");
    System.out.println("The value for the object at row 3 and column 1 should be 0");
    System.out.println("The value for the object at row 3 and column 1 is " + grid.getValueAt(3,1) + ".");
    System.out.println("The value for the object at row 1 and column 3 should be 4");
    System.out.println("The value for the object at row 1 and column 3 is " + grid.getValueAt(1,3) + ".");
    System.out.println();
    System.out.println("There are now " + grid.getNumCols() + " columns and there should be 4 columns.");
  }
}