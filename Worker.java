public abstract class Worker implements Payable, Taxable{
 
  private String name;
  private String company;
  
  public Worker(String n, String c){
   name = n;
   company = c;
  }
  
  public String getName(){ return name;}
  public String getCompany(){ return company;}

  public String toString(){
     return "Worker's name : "+ getName() +"/n Company :" + getCompany() +"/n His/her pay" + getPay()+ "/n His/her tax" + getTax();
   }

  //You need to add more behavior (Methods) here
  //getPay() and getTax() are abstract here because you implemented Payable and Taxable
  //but the Worker class remains abstract because you won't implement one of those methods
  //here.  Also, don't forget the toString().  It is the same for ALL Workers

public double getTax(){
  if( getPay() >= 0 && getPay() <= 40000)
   return getPay() * .10;
  else 
   return getPay() * .25;
}
  
}