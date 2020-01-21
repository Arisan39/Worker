public class CommissionedWorker extends Worker{
  private double commission;
  private double sale;
  public CommissionedWorker( String n, String c, double com, double s){
    super(n, c);
    commission = com;
    sale = s;
  }
  public double getPay(){
    return commission * sale;
  }

  
  
}