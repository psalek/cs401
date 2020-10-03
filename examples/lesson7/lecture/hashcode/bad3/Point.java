package lesson7.lecture.hashcode.bad3;

import java.util.HashSet;
import java.util.Set;

/**
 * Illustrates importance of using immutable objects
 * as keys in a hashtable
 * 
 * @author pcorazza
 *
 */
public class Point {
	
		  private int x;
		  private int y;
		  
		  public Point(int x, int y) {
		    this.x = x;
		    this.y = y;
		  }

		  public int getX() {
		    return x;
		  }

		  public void setX(int x) {
		    this.x = x;
		  }

		  public int getY() {
		    return y;
		  }

		  public void setY(int y) {
		    this.y = y;
		  }
		  
		  public boolean equals(Object obj) {
		    if(obj == null) {
		      return false;
		    }
		    if(obj.getClass() != this.getClass()) {
		      return false;
		    }
		    Point other = (Point) obj;
		    return (other.x == this.x) && (other.y == this.y);
		  }
		  
		  @Override
		  public String toString() {
			  return "[" + x + ", " + y + "]";
		  }
		  
		  public int hashCode() {
			  return 2;
//		    int hash = 7;
//		    hash = 31 * hash + this.x;
//		    hash = 31 * hash + this.y;
//		    //or could simply write:  return Objects.hash(x,y)
		    //return hash;
		  }
		  public static void main(String[] args) {
			    Point a = new Point(5,5);
			    Set<Point> set = new HashSet<>();
			    
			    set.add(a);
			    System.out.println(set.contains(a));
			    a.setX(8);
			    System.out.println(set.contains(a));
			    System.out.println(set);
//		    
			    set.add(a);
			    System.out.println(set);
			    System.out.println(set.size());
			    
			    
			    set.remove(a);
			    System.out.println(set.size());
//			    
			    set.remove(a);
			    System.out.println(set.size());
			    System.out.println(set.contains(a));
//			    
//			    
			    System.out.println(set);
	  }
}
