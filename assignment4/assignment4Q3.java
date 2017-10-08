package assignment4;

public class assignment4Q3 {
	//solution3 
	
	public static void main(String args[]){
		IpAddress ip = new IpAddress("192.168.0.1");
		System.out.println(ip.getDottedDecimal());
		System.out.println(ip.getOctet(4));
		System.out.println(ip.getOctet(1));
		System.out.println(ip.getOctet(3));
		System.out.println(ip.getOctet(2));
		}
	
	public static class IpAddress{
		protected String dottedDecimal;
		protected int firstOctet;
		protected int secondOctet;
		protected int thirdOctet;
		protected int fourthOctet;
		
		public IpAddress(String dottedDecimal){
			this.dottedDecimal= dottedDecimal;
			String[]octets = dottedDecimal.split("\\.");
			firstOctet = Integer.parseInt(octets[0]);
			secondOctet = Integer.parseInt(octets[1]);
			thirdOctet = Integer.parseInt(octets[2]);
			fourthOctet = Integer.parseInt(octets[3]);
		}
		public static String[] splitDottle(String dd){
			String[] octets = new String[4];
			int firstdot = dd.indexOf('.');
			octets[0] = dd.substring(0,firstdot);
			int seconddot = dd.indexOf('.',firstdot+1);
			octets[1] = dd.substring(firstdot+1, seconddot);
			int thirddot = dd.indexOf('.',seconddot+1);
			octets[2] = dd.substring(seconddot+1, thirddot);
			int fourthdot = dd.indexOf('.',thirddot+1);
			octets[3] = dd.substring(thirddot+1, fourthdot);
			return octets;
		}
		
		public String getDottedDecimal(){
			return dottedDecimal;
		}
		
		public int getOctet(int i){
			if (i==1){
				return firstOctet;
			}
			if (i==2){
				return secondOctet;
			}
			if (i==3){
				return thirdOctet;
			}
			else return fourthOctet;
			
		}
		
		
	}
}
