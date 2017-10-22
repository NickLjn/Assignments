package ATM;

public class User {
	private String name;
	private int age;
	private String address;
	private String phoneNumber;
	private String bankAccountNumber;
	
	
	public User(){
	}
	
	public User(String name, int age, String address, String phoneNumber, String bankAccountNumber){
		this.name = name ;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.bankAccountNumber = bankAccountNumber;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public void setBankAccountNumber(String bankAccountNumber){
		this.bankAccountNumber = bankAccountNumber;
	}
	public String getBankAccountNumber(){
		return bankAccountNumber;
	}
}
