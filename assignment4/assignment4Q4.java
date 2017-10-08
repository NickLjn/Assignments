package assignment4;

public class assignment4Q4 {

	public static void main(String[] args) {

	}
	
    class Student{
		private String name;
		private int id;
		
		public Student(String name, int id){
			this.name=name;
			this.id=id;
		}
		public String getName(){
			return name;
		}
		public int getId(){
			return id;
		}
	}
    
    class Course{
    	private String name;
    	private int numberOfStudent;
    	private Student[] student;
    	public Course(String name){
    		this.name = name;
    		numberOfStudent = 0;
    		student = new Student[10];
    	}
    	public Student[] getStudents(){
    		return student;
    	}
    	
    	public boolean isFull(){
    		if(numberOfStudent==10){
    			return true;
    		}
    		return false;
    	}
    	
    	public boolean registerStudent(Student student){
    		if(this.isFull()){
    			System.out.println("Sorry, this course is full.");
    			return false;
    		}
    		else this.student[numberOfStudent]= student;
    		this.numberOfStudent++;
    		return true;
    	}
    	
    	public void setName(String name){
    		this.name = name;
    	}
    	public String getName(){
    		return this.name;
    	}
    	
    	public void setNumberOfStudent(int numberOfStudent){
    		this.numberOfStudent= numberOfStudent;  		
    	}
    	public int getNumberOfStudent(){
    		return this.numberOfStudent;
    	}
    }
}
