package lesson10.labs.prob1.bugreporter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BugReport {
	String assignedTo() default "<unassigned>";
	int severity() default 0;
	String description() default "";
	String reportedBy() default "<unnamed>";
	
}


