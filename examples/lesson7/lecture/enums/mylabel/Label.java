//improved version using an enum
package lesson7.lecture.enums.mylabel;

public class Label  {

    String text;
    Alignment alignment;
   
    public Label(String text, Alignment alignment)  {
			this.text = text;
			setAlignment(alignment);
    }

    public Alignment getAlignment() {
			return alignment;
    }

    public synchronized void setAlignment(Alignment alignment) {
    	this.alignment = alignment;

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
