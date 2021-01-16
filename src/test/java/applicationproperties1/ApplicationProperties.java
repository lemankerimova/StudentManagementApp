package applicationproperties1;

public class ApplicationProperties {

	 private static final String GENERAL_MENU = 
	 		"1.STUDENT CONTROLLER\n"
	 		+ "2.TEACHER CONTROLLER\n"
	 		+ "3.GROUP CONTROLLER\n"
	 		+ "4.SUBJECT CONTROLLER\n";
			 

	    public static void printGeneralMenu() {
	        System.out.println(GENERAL_MENU);
	    }

	    private static final String STUDENT_MENU =   "1.ADD STUDENT\n"
	            + "2.GET STUDENT\n"
	            + "3.SOFT Delete STUDENT\n"
	            + "4.HARD Delete STUDENT\n"
	            + "5.UPDATE STUDENT By Id\n";
	    public static void printStudentMenu() {
	        System.out.println(STUDENT_MENU);
	    }
	    

	    public static final String TEACHER_MENU = "1.ADD TEACHER\n"
	    		+ "2.GET Teacher\n"
	    		+ "3.SOFT Delete Teacher\n"
	    		+ "4.HARD DELETE TEACHER\n"
	    		+ "5.UPDATE TEACHER BY ID\n";
	    public static void printTeacherMenu() {
	    	System.out.println(TEACHER_MENU);
	    }
	    public static final String GROUP_MENU = "1ADD SUBJECT\n"
	    		+ "2.GET GROUP\n"
	    		+ "3.SOFT DELETE GROUP BY ID\n"
	    		+ "4.HARD DELETE GROUP BY ID\n"
	    		+ "5.HARD DELETE GROUP BY ID\n";
	    public static void printGroupMenu() {
	    	System.out.println(GROUP_MENU);
	    }
	    public static final String SUBJECT_MENU = "1.ADD SUBJECT\n"
	    		+ "2.GET SUBJECT\n"
	    		+ "3.SOFT DELETE SUBJECT BY ID\n"
	    		+ "4.HARD DELETE SUBJECT BY ID\n"
	    		+ "5.UPDATE SUBJECT BY ID\n";
	    public static void printSubjectMenu() {
	    	System.out.println(SUBJECT_MENU);
	    }
	    		
	     	 
}

 