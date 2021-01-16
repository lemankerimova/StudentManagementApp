package model1;

public class Subject {

	private Long id;
	private boolean active;
	private String subjectname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getSubject_name() {
		return subjectname;
	}

	public void setSubject_name(String subject_name) {
		this.subjectname = subject_name;
	}

}
