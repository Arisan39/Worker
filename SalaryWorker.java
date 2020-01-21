public class SalaryWorker extends Worker{
private double salary;
public SalaryWorker(String n, String c, double s){
  super( n, c);
  salary = s;
}
public double getPay(){
  return salary;
}

}