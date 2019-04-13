package Airlines;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

public class Airline_methods{
	
	// (Q9) Number of flights to Boston
	public HashMap<String,Double> To_Bos(String fileName) throws FileNotFoundException{
		HashMap<String, Double> result = new HashMap<String, Double>();
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		String line="";
		in.nextLine();
		while (in.hasNextLine()) {
			line=in.nextLine();
			String[] parts=line.split(",");
			String UniqueCarrier=parts[3];
			String Dest=parts[9];

			// Adding value to existing value and if not exist, create new key
			if(Dest.equals("BOS")) {
				if(result.containsKey(UniqueCarrier)) {
					result.put(UniqueCarrier, result.get(UniqueCarrier)+1);
				}
				else {
					result.put(UniqueCarrier, (double) 1);
				}
			}
		}
		return result;
	}
	
	// (Q8) Largest delay made up
	public ArrayList<String> delay_madeup(String fileName) throws FileNotFoundException{
		HashMap<String, ArrayList<Integer>> result = new HashMap<String, ArrayList<Integer>>();
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		String line="";
		in.nextLine();
		while (in.hasNextLine()) {
			line=in.nextLine();
			String[] parts=line.split(",");
			String DayofMonth=parts[0];
			String TailNum=parts[4];
			String DepDelay=parts[12];
			String ArrDelay=parts[16];
			if(DepDelay.isEmpty()){
				DepDelay="0";
				}
			if(ArrDelay.isEmpty()){
				ArrDelay="0";
				}
			int DayofMonth_d=Integer.parseInt(DayofMonth);
			int DepDelay_d=Integer.parseInt(DepDelay);
			int ArrDelay_d=Integer.parseInt(ArrDelay);
			ArrayList<Integer> list= new ArrayList<Integer>();
			
			// Adding value to existing value and if not exist, create new key
			if(DepDelay_d>0&&ArrDelay_d<=0) {
				list.add(DayofMonth_d);
				list.add(DepDelay_d);
				result.put(TailNum,list);
			}
		}
		Entry<String, ArrayList<Integer>> maxEntry = null;
		for (Entry<String, ArrayList<Integer>> entry : result.entrySet()){
		    if (maxEntry== null || entry.getValue().get(1).compareTo(maxEntry.getValue().get(1))>0){
		        maxEntry = entry;
		    }
		}
		ArrayList<String> list_f = new ArrayList<String>();
		list_f.add(String.valueOf(maxEntry.getValue().get(0)));
		list_f.add(String.valueOf(maxEntry.getValue().get(1)));
		list_f.add(maxEntry.getKey());
		return list_f;
	}
	
	
	// (Q7) Counting # of delayed flights
		public int AA_delayed(String fileName) throws FileNotFoundException{
			File file = new File(fileName);
			Scanner in = new Scanner(file);
			String line="";
			in.nextLine();
			int result=0;
			while (in.hasNextLine()) {
				line=in.nextLine();
				String[] parts=line.split(",");
				String UniqueCarrier=parts[3];
				String DepDelay=parts[12];
				String ArrDelay=parts[16];
				if(DepDelay.isEmpty()){
					DepDelay="0";
					}
				if(ArrDelay.isEmpty()){
					ArrDelay="0";
					}
				double DepDelay1=Double.parseDouble(DepDelay);
				double ArrDelay1=Double.parseDouble(ArrDelay);

				// Adding value to existing value and if not exist, create new key
				if(UniqueCarrier.equals("AA")&&(DepDelay1>=60||ArrDelay1>=60)) {
					result++;
				}
			}
			return result;
		}
		
	
	// (Q5,6) Calculating Source (Departure - Arrival) or Sink (Arrival-Departure) using two hashmaps
		public HashMap<String, Double> Source_Sink(List<HashMap<String, Double>> maps) {
			HashMap<String, Double> result = new HashMap<String, Double>();
		    for (HashMap<String, Double> map : maps) {
		        for (HashMap.Entry<String, Double> entry : map.entrySet()) {
		            Double newValue = entry.getValue();
		            Double existingValue = result.get(entry.getKey());
		            if (existingValue != null) {
		                 newValue = existingValue-newValue;
		            }
		            result.put(entry.getKey(),  newValue);
		        }
		    }
		    return result;
		}
	
	// (Q4) Adding two hashmap and total number of flights in and out
	public HashMap<String, Double> total_inout(List<HashMap<String, Double>> maps) {
		HashMap<String, Double> result = new HashMap<String, Double>();
	    for (HashMap<String, Double> map : maps) {
	        for (HashMap.Entry<String, Double> entry : map.entrySet()) {
	            Double newValue = entry.getValue();
	            Double existingValue = result.get(entry.getKey());
	            if (existingValue != null) {
	                 newValue = newValue+existingValue;
	            }
	            result.put(entry.getKey(), newValue);
	        }
	    }
	    return result;
	}
	
	// (Q4) Counting # of planes by airport
	public HashMap<String,Double> dest_by_airport(String fileName) throws FileNotFoundException{
		HashMap<String,Double> result=new HashMap<>();
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		String line="";
		in.nextLine();
		
		while (in.hasNextLine()) {
			line=in.nextLine();
			String[] parts=line.split(",");
			String DestAirportID=parts[8];
			
	// Adding value to existing value and if not exist, create new key
			if(result.containsKey(DestAirportID)) {
				result.put(DestAirportID, result.get(DestAirportID)+1);
			}
			else {
				result.put(DestAirportID, (double) 1);
			}
		}
		return result;
	}
	
	// (Q4) Counting # of planes by airport
	public HashMap<String,Double> origin_by_airport(String fileName) throws FileNotFoundException{
		HashMap<String,Double> result=new HashMap<>();
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		String line="";
		in.nextLine();
		
		while (in.hasNextLine()) {
			line=in.nextLine();
			String[] parts=line.split(",");
			String OriginAirportID=parts[5];
			
			// Adding value to existing value and if not exist, create new key
			if(result.containsKey(OriginAirportID)) {
				result.put(OriginAirportID, result.get(OriginAirportID)+1);
			}
			else {
				result.put(OriginAirportID, (double) 1);
			}
		}
		return result;
	}
	
	// (Q3) Calculating miles by tail number
	public HashMap<String,Double> miles_by_tail(String fileName) throws FileNotFoundException{
		HashMap<String,Double> result=new HashMap<>();
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		String line="";
		in.nextLine();
		
		while (in.hasNextLine()) {
			line=in.nextLine();
			String[] parts=line.split(",");
			String TailNum=parts[4];
			double Miles=Double.parseDouble(parts[21]);
			if(!TailNum.isEmpty()) {
			if(result.containsKey(TailNum)) {
				result.put(TailNum, result.get(TailNum)+Miles);
			}
			else {
				result.put(TailNum, Miles);
			}
			}
		}
		return result;
	}

	
	// (Q2) Counting cancellations by code
		public HashMap<String,Double> cancel_code(String fileName) throws FileNotFoundException{
			HashMap<String,Double> result=new HashMap<>();
			File file = new File(fileName);
			Scanner in = new Scanner(file);
			String line="";
			in.nextLine();
			
			while (in.hasNextLine()) {
				line=in.nextLine();
				String[] parts=line.split(",");
				String CancellationCode=parts[18];
				double Cancelled=Double.parseDouble(parts[17]);
				
				if(result.containsKey(CancellationCode)) {
					result.put(CancellationCode, result.get(CancellationCode)+Cancelled);
				}
				else {
					result.put(CancellationCode, Cancelled);
				}
			}
			return result;
		}
	
	// (General) Finding max value from the hashmap
	public Entry<String, Double> max_hash(HashMap<String,Double> map_name){
		Entry<String, Double> maxEntry = null;
		for (Entry<String, Double> entry : map_name.entrySet()){
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue())>0){
		        maxEntry = entry;
		    }
		}
		return maxEntry;
	}
	
	// Loops over Hashmap and prints
	public void print_hash(HashMap<String,Double> map_name){
	 for (Entry<String, Double> entry : map_name.entrySet()) {
		    System.out.println(entry.getKey() + ":" + entry.getValue().toString()); 
		}
	 System.out.println("");
	}
	
	// (Q1) Combine two hashmap and get percentage - used for cancellation percentage
	// Create a list of hashmap and put denominator first
	public HashMap<String, Double> Cancellation_rate(List<HashMap<String, Double>> maps) {
		HashMap<String, Double> result = new HashMap<String, Double>();
	    for (HashMap<String, Double> map : maps) {
	        for (HashMap.Entry<String, Double> entry : map.entrySet()) {
	            Double newValue = entry.getValue();
	            Double existingValue = result.get(entry.getKey());
	            if (existingValue != null) {
	                 newValue = newValue/existingValue*100;
	            }
	            result.put(entry.getKey(),  newValue);
	        }
	    }
	    return result;
	}
	
	// (Q1) Counting cancellations by Airline
	public HashMap<String,Double> cancel_airline(String fileName) throws FileNotFoundException{
		HashMap<String,Double> result=new HashMap<>();
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		String line="";
		in.nextLine();
		
		while (in.hasNextLine()) {
			line=in.nextLine();
			String[] parts=line.split(",");
			String UniqueCarrier=parts[3];
			double Cancelled=Double.parseDouble(parts[17]);
			String total;
			
			if(result.containsKey(UniqueCarrier)) {
				result.put(UniqueCarrier, result.get(UniqueCarrier)+Cancelled);
			}
			else {
				result.put(UniqueCarrier, Cancelled);
			}
			
		}
		return result;
	}
	
	// (Q1) Counting total number of flights
	public HashMap<String,Double> total_count(String fileName) throws FileNotFoundException{
		HashMap<String,Double> result=new HashMap<>();
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		String line="";
		in.nextLine();
		
		while (in.hasNextLine()) {
			line=in.nextLine();
			String[] parts=line.split(",");
			String UniqueCarrier=parts[3];
			double Cancelled=Double.parseDouble(parts[17]);
			
			// Adding value to existing value and if not exist, create new key
			if(result.containsKey(UniqueCarrier)) {
				result.put(UniqueCarrier, result.get(UniqueCarrier)+1);
			}
			else {
				result.put(UniqueCarrier, (double) 1);
			}
			
		}
		return result;
	}
	
	// Reading entire CSV file - left all variable at String and will adjust if needed
	public ArrayList<Flights> readFile(String fileName) throws FileNotFoundException{
		ArrayList<Flights> result=new ArrayList<>();
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		String line="";
		in.nextLine();
		
		while (in.hasNextLine()) {
			line=in.nextLine();
			String[] parts=line.split(",");
			String DayofMonth=parts[0];
			String DayOfWeek=parts[1];
			String FlightDate=parts[2];
			String UniqueCarrier=parts[3];
			String TailNum=parts[4];
			String OriginAirportID=parts[5];
			String Origin=parts[6];
			String OriginStateName=parts[7];
			String DestAirportID=parts[8];
			String Dest=parts[9];
			String DestStateName=parts[10];	
			String DepTime=parts[11];
			String DepDelay=parts[12];
			String WheelsOff=parts[13];
			String WheelsOn=parts[14];
			String ArrTime=parts[15];
			String ArrDelay=parts[16];	
			String Cancelled=parts[17];
			String CancellationCode=parts[18];
			String Diverted=parts[19];
			String AirTime=parts[20];
			String Distance=parts[21];
			
			Flights data=new Flights(DayofMonth,DayOfWeek,FlightDate,UniqueCarrier,TailNum,OriginAirportID,Origin,OriginStateName,DestAirportID,Dest,DestStateName,DepTime,DepDelay,WheelsOff,WheelsOn,ArrTime,ArrDelay,Cancelled,CancellationCode,Diverted,AirTime,Distance);
			result.add(data);
		}
		return result;
	}
}
