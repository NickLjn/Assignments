package assignment8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class MyJson {
	private static ArrayList<Vehicle> readAndGetVehicles(File file) throws IOException{
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		FileReader fileReader = new FileReader(file);
		Scanner sc = new Scanner(fileReader);
		String record[];
		
		sc.nextLine();
		while(sc.hasNextLine()) {
			record = sc.nextLine().split("~");
			Vehicle vehicle = new Vehicle(record);
			vehicles.add(vehicle);
		}
		
		fileReader.close();
		sc.close();
		
		return vehicles;
	}
	
	
	public static String getJsonString(ArrayList<Vehicle> vehicles) {
		String Json = "{\n\""+ vehicles.get(0).webId+ "\" : [\n{";
		for(Vehicle vehicle : vehicles) {
			Json += "{\n";
			Json += "\"id\" : \"" + vehicle.id + "\",\n";
			Json += "\"category\" : \"" + vehicle.category + "\",\n";
			Json += "\"make\" : \"" + vehicle.make + "\",\n";
			Json += "\"model\" : \"" + vehicle.model + "\",\n";
			Json += "\"trim\" : \"" + vehicle.trim + "\",\n";
			Json += "\"type\" : \"" + vehicle.type + "\",\n";
			Json += "\"price\" : \"" + vehicle.price + "\",\n";
			Json += "\"photo\" : \"" + vehicle.photo + "\",\n";
			Json += "},\n";
		}
		Json += "]\n}";
		
		return Json;
	}
	
	public static void writeToFile(String inputToWrite, String filePath) throws IOException {
		File f = new File(filePath + "/Json_output.txt");
		f.createNewFile();
		FileWriter fw = new FileWriter(f);
		fw.write(inputToWrite);
		fw.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\ljn\\Desktop\\assignment8\\Q3.txt");
	    ArrayList<Vehicle> vehicles = readAndGetVehicles(file);
	    String s = getJsonString(vehicles);
	    writeToFile(s, file.getParent());
	}

}

class Vehicle{

    String id;
    String webId;
    Category category;
    Year year;
    String make;
    String model;
    String trim;
    String type;
    double price;
    URL photo;

    Vehicle(String[] arr){
        this.id = arr[0];
        this.webId = arr[1];
        this.category = Category.getCategory(arr[2].toLowerCase());
        this.year = Year.parse(arr[3]);
        this.make = arr[4];
        this.model = arr[5];
        this.trim = arr[6];
        this.type = arr[7];
        this.price = Double.parseDouble(arr[8]);
        try {
            this.photo = new URL(arr[9]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}

enum Category{
    NEW , USED, CERTIFIED;

    public static Category getCategory(String cat){
       switch (cat){
           case "used": return USED;
           case "new": return NEW;
           case "certified": return CERTIFIED;
           default: throw new IllegalArgumentException();
       }
    }

    @Override
    public String toString() {
        switch (this){
            case NEW: return "NEW";
            case USED: return "USED";
            case CERTIFIED: return "CERTIFIED";
            default: throw new IllegalArgumentException();
        }
    }
}