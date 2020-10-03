//source code from the jdk
package lesson7.lecture.enums.javalabel;

public class Label  {
    public static final int LEFT 	= 0;
    public static final int CENTER 	= 1;
    public static final int RIGHT 	= 2;

    String text;
    int alignment = LEFT;
    public Label(String text, int alignment)  {
			this.text = text;
			setAlignment(alignment);
    }

    public int getAlignment() {
			return alignment;
    }

    public synchronized void setAlignment(int alignment) {
			switch (alignment) {
	  			case LEFT:
	  			case CENTER:
	  			case RIGHT:
	    			this.alignment = alignment;
 	    			return;
			}
			throw new IllegalArgumentException("improper alignment: " +
                                               alignment);
    }
    public String getText() {
			return text;
    }
    public void setText(String text) {
	  		synchronized (this) {
	    	if (text != this.text && (this.text == null ||
				      !this.text.equals(text))) {

	        		this.text = text;
	    }
	  }
    }    
}
