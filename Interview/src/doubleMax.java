
public class doubleMax {
	public static void main(String[] args) {
		double p = 0.3;
		double Ip1 = Math.log10 (1/0.3) / Math.log10(2);
		double Ip2 = Math.log10 (1/0.7) / Math.log10(2);
		double ans4 = Math.log10(36/5) / Math.log10(2);
		double ans8 = HS((double)1/36) + HS((double)1/18) + HS((double)1/12) + HS((double)1/9) + HS((double)5/36);
		ans8 = 2*ans8 + HS((double)1/6);
		double ans10 = HS(0.175) + HS(0.525) + HS(0.3);
		
		double aa = HS(0.15/0.175) + HS(0.025/0.175);
		double bb = HS(0.025/0.525) + HS(0.3/0.525) + HS(0.2/0.525);
		double cc = HS(0.2/0.3) + HS(0.1/0.3);
		double ans11 = 0.175 * aa + 0.525 * bb + 0.3 * cc;
		
		double ans12 = HS(0.15) + 2 * HS(0.025) + HS(0.3) + 2 * HS(0.2) + HS(0.1);
		
		long start = 14l;
		String s = "sdkfa";
		String newS = start + "," + s;
		String[] mm = newS.split(",");

		System.out.println(mm[1].equals("sdkfa"));
	}
	
	public static double HS(double in) {
		return in * Math.log10(1/in) / Math.log10(2);
	}
}
