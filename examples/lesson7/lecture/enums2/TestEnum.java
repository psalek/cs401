package lesson7.lecture.enums2;

/** Shows instances of an enum are instances of a subclass of the enum */
public class TestEnum  {
	public static void main(String[] args) {
//		System.out.println("Instances do inherit from the enum type: " + (AnEnum.INST1 instanceof AnEnum));
//		System.out.println("Instances are of subclasses of the enum, not instances of the enum itself: " +
//		     (AnEnum.INST1.getClass() == AnEnum.class));
		AnEnum.INST1.modify();
		AnEnum.INST2.modify();
		System.out.println(AnEnum.INST1.val());
		System.out.println(AnEnum.INST2.val());
		Class<Enum> cl = Enum.class;
	}
}
