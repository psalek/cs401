package lesson10.labs.prob1.javapackage;

import java.util.ArrayList;
import java.util.List;

import lesson10.labsolns.prob1.bugreporter.BugReport;

@BugReport(assignedTo="Joe Smith", severity=1, reportedBy="Corazza", description="Should use Logger")
public class DataMiner {
	List<ClosedCurve> objects = new ArrayList<>();
	public static void main(String[] args) {
		DataMiner dm = new DataMiner();
		dm.objects.add(new Rectangle(5,7));
		dm.objects.add(new Rectangle(2,9));
		dm.objects.add(new Circle(6));
		System.out.println(dm.computeAveragePerimeter());
	}
	
	//OO (good) way of performing computation
	public double computeAveragePerimeter() {
		if(objects == null || objects.isEmpty()) return 0.0;
		double sum = 0.0;
		for(int i = 0; i < objects.size(); ++i) {
			sum += objects.get(i).computePerimeter();
		}
		return sum/objects.size();
	}

}
