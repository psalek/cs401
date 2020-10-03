package lesson6.lecture.javafx.tables;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Catalog {
	private final SimpleStringProperty name;
    private SimpleIntegerProperty id; 
	public Catalog(String name) {
		this.name = new SimpleStringProperty(name);
	}
	public String getName() {
		return name.get();
	}
	public void setName(String n) {
		name.set(n);
	}
	
	public int getId() {
		return id.get();
	}
	public void setId(int id) {
		this.id.set(id);
	}
	
	public boolean equals(Object ob) {
		if(this == ob) return true;
		if(getClass() != ob.getClass()) return false;
		Catalog c = (Catalog)ob;
		return name.equals(c.name);
	}
}
