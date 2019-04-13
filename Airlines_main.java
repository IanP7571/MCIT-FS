package Airlines;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Airlines_main {
	 public static void main(String[] args) throws IOException{
		 
		 // initialize the methods
		 Airline_methods am=new Airline_methods();
		 FormattedOutput fo=new FormattedOutput();
		 String filepath = "flights.csv";
		 
		 // Question 1
		 ArrayList list1 = new ArrayList(); 
		 list1.add(am.total_count(filepath)); 
		 list1.add(am.cancel_airline(filepath));
		 HashMap<String,Double> percent=am.Cancellation_rate(list1);
		 System.out.println("Which carrier has the highest percentage of cancelled flights?");
		 System.out.println(am.max_hash(percent)+"%");
		 System.out.println("");
		 String q1=am.max_hash(percent).getKey()+","+am.max_hash(percent).getValue();
		 fo.addAnswer(1,q1);
		 
		 // Question 2
		 System.out.println("What is the most common cause of cancellations?");
		 System.out.println(am.max_hash(am.cancel_code(filepath)));
		 String q2=am.max_hash(am.cancel_code(filepath)).getKey();
		 System.out.println("");
		 fo.addAnswer(2,q2);
		 
		// Question 3
		 System.out.println("Which plane (tail number) flew the furthest (most miles) - Excluding blank tail number?");
		 System.out.println(am.max_hash(am.miles_by_tail(filepath)));
		 String q3=am.max_hash(am.miles_by_tail(filepath)).getKey();
		 System.out.println("");
		 fo.addAnswer(3,q3);
		 
		// Question 4
		 ArrayList list4 = new ArrayList(); 
		 list4.add(am.origin_by_airport(filepath)); 
		 list4.add(am.dest_by_airport(filepath));
		 System.out.println("Which airport is the busiest by total number of flights in and out? Use the number OriginAirportID");
		 System.out.println(am.max_hash(am.total_inout(list4)));
		 String q4=(String) am.max_hash(am.total_inout(list4)).getKey();
		 System.out.println("");
		 fo.addAnswer(4,q4);
		 
		// Question 5
		 ArrayList list5 = new ArrayList(); 
		 list5.add(am.origin_by_airport(filepath)); 
		 list5.add(am.dest_by_airport(filepath));
		 System.out.println("You need planes to put people on! Which airport is the biggest source of airplanes?");
		 System.out.println(am.max_hash(am.Source_Sink(list5)));
		 String q5=(String) am.max_hash(am.Source_Sink(list5)).getKey();
		 System.out.println("");
		 fo.addAnswer(5,q5);
		 
			// Question 6
		 ArrayList list6 = new ArrayList(); 
		 list6.add(am.dest_by_airport(filepath));
		 list6.add(am.origin_by_airport(filepath)); 
		 System.out.println("Which airport is the biggest sink of airplanes? ");
		 System.out.println(am.max_hash(am.Source_Sink(list6)));
		 String q6=(String) am.max_hash(am.Source_Sink(list6)).getKey();
		 System.out.println("");
		 fo.addAnswer(6,q6);
		 
		// Question 7
		 System.out.println("How many American Airlines (Unique Carrier ID AA) flights were delayed by 60 minutes or more?");
		 System.out.println((am.AA_delayed(filepath)));
		 int q7=(am.AA_delayed(filepath));
		 System.out.println("");
		 fo.addAnswer(7,q7);
		 
		// Question 8
		 System.out.println("What was the largest delay that was made up (arrived early/on time)?");
		 System.out.println((am.delay_madeup(filepath)));
		 String q8=(am.delay_madeup(filepath)).get(0)+","+(am.delay_madeup(filepath)).get(1)+","+(am.delay_madeup(filepath)).get(2);
		 System.out.println("");
		 fo.addAnswer(8,q8);
				 
		// Question 9
		 System.out.println("Which airline has the most flight to Boston?");
		 System.out.println(am.max_hash(am.To_Bos(filepath)));
		 String q9="Which airline has the most flight to Boston?"+";"+am.max_hash(am.To_Bos(filepath)).getKey();
		 System.out.println("");
		 fo.addAnswer(9,q9);
		 
		 fo.writeAnswers();
	 }
}

