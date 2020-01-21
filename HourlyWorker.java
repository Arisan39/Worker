public class HourlyWorker extends Worker{
  private int hours;
  private double rate;
  public HourlyWorker(String n, String c, int h, double r){
    super(n, c);
    hours = h;
    rate = r;
  }
  public double getPay(){
    if( hours > 0 && hours < 40 )
      return hours * rate;
    else
      return hours * rate * 1.5;
  }


}