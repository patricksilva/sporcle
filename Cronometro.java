import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
class Cronometro {
	@Getter @Setter(AccessLevel.PRIVATE) private long clockStart = 0L;
	@Getter @Setter(AccessLevel.PRIVATE) private long clockNow = 0L;
	@Getter @Setter(AccessLevel.PUBLIC) private	long timeLimit = 300000L;

	public double getEleapsedTime(){
		return (this.clockNow - this.clockStart) * .001;
	}
	
	public void startChronometer(){
		this.setClockStart(System.currentTimeMillis());
	}
	
	public boolean ringingAlarm(){
		return (this.clockNow - this.clockStart > this.timeLimit)?true:false;
	}
	
	public void checkPoint(){
		this.setClockNow(System.currentTimeMillis());
	}
	
	public double minutesLeft(){
		return (this.timeLimit/60.) * .001;
	}
}