
/**
 * The Airlines Class is for making a Flight object.
 * @author IanPark
 * Comments: Peter Brice
 */
package Airlines;

public class Flights {
	String DayofMonth;
	String DayOfWeek;
	String FlightDate;
	String UniqueCarrier;
	String TailNum;
	String OriginAirportID;
	String Origin;
	String OriginStateName;
	String DestAirportID;
	String Dest;	
	String DestStateName;	
	String DepTime;
	String DepDelay;	
	String WheelsOff;	
	String WheelsOn;
	String ArrTime;
	String ArrDelay;	
	String Cancelled;	
	String CancellationCode;	
	String Diverted;
	String AirTime;
	String Distance;
	
	public Flights(String dayofMonth, String dayOfWeek, String flightDate, String uniqueCarrier, String tailNum,
			String originAirportID, String origin, String originStateName, String destAirportID, String dest,
			String destStateName, String depTime, String depDelay, String wheelsOff, String wheelsOn, String arrTime,
			String arrDelay, String cancelled, String cancellationCode, String diverted, String airTime,
			String distance) {
		DayofMonth = dayofMonth;
		DayOfWeek = dayOfWeek;
		FlightDate = flightDate;
		UniqueCarrier = uniqueCarrier;
		TailNum = tailNum;
		OriginAirportID = originAirportID;
		Origin = origin;
		OriginStateName = originStateName;
		DestAirportID = destAirportID;
		Dest = dest;
		DestStateName = destStateName;
		DepTime = depTime;
		DepDelay = depDelay;
		WheelsOff = wheelsOff;
		WheelsOn = wheelsOn;
		ArrTime = arrTime;
		ArrDelay = arrDelay;
		Cancelled = cancelled;
		CancellationCode = cancellationCode;
		Diverted = diverted;
		AirTime = airTime;
		Distance = distance;
	}

	public String getDayofMonth() {
		return DayofMonth;
	}

	public void setDayofMonth(String dayofMonth) {
		DayofMonth = dayofMonth;
	}

	public String getDayOfWeek() {
		return DayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		DayOfWeek = dayOfWeek;
	}

	public String getFlightDate() {
		return FlightDate;
	}

	public void setFlightDate(String flightDate) {
		FlightDate = flightDate;
	}

	public String getUniqueCarrier() {
		return UniqueCarrier;
	}

	public void setUniqueCarrier(String uniqueCarrier) {
		UniqueCarrier = uniqueCarrier;
	}

	public String getTailNum() {
		return TailNum;
	}

	public void setTailNum(String tailNum) {
		TailNum = tailNum;
	}

	public String getOriginAirportID() {
		return OriginAirportID;
	}

	public void setOriginAirportID(String originAirportID) {
		OriginAirportID = originAirportID;
	}

	public String getOrigin() {
		return Origin;
	}

	public void setOrigin(String origin) {
		Origin = origin;
	}

	public String getOriginStateName() {
		return OriginStateName;
	}

	public void setOriginStateName(String originStateName) {
		OriginStateName = originStateName;
	}

	public String getDestAirportID() {
		return DestAirportID;
	}

	public void setDestAirportID(String destAirportID) {
		DestAirportID = destAirportID;
	}

	public String getDest() {
		return Dest;
	}

	public void setDest(String dest) {
		Dest = dest;
	}

	public String getDestStateName() {
		return DestStateName;
	}

	public void setDestStateName(String destStateName) {
		DestStateName = destStateName;
	}

	public String getDepTime() {
		return DepTime;
	}

	public void setDepTime(String depTime) {
		DepTime = depTime;
	}

	public String getDepDelay() {
		return DepDelay;
	}

	public void setDepDelay(String depDelay) {
		DepDelay = depDelay;
	}

	public String getWheelsOff() {
		return WheelsOff;
	}

	public void setWheelsOff(String wheelsOff) {
		WheelsOff = wheelsOff;
	}

	public String getWheelsOn() {
		return WheelsOn;
	}

	public void setWheelsOn(String wheelsOn) {
		WheelsOn = wheelsOn;
	}

	public String getArrTime() {
		return ArrTime;
	}

	public void setArrTime(String arrTime) {
		ArrTime = arrTime;
	}

	public String getArrDelay() {
		return ArrDelay;
	}

	public void setArrDelay(String arrDelay) {
		ArrDelay = arrDelay;
	}

	public String getCancelled() {
		return Cancelled;
	}

	public void setCancelled(String cancelled) {
		Cancelled = cancelled;
	}

	public String getCancellationCode() {
		return CancellationCode;
	}

	public void setCancellationCode(String cancellationCode) {
		CancellationCode = cancellationCode;
	}

	public String getDiverted() {
		return Diverted;
	}

	public void setDiverted(String diverted) {
		Diverted = diverted;
	}

	public String getAirTime() {
		return AirTime;
	}

	public void setAirTime(String airTime) {
		AirTime = airTime;
	}

	public String getDistance() {
		return Distance;
	}

	public void setDistance(String distance) {
		Distance = distance;
	}

	

}
