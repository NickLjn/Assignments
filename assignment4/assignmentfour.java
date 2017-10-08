package assignment4;

import java.util.*;

public class assignment4 {
	public static void main(String args[]){
		//solution 5'
		int num = 3500;
		System.out.println("roman numeral of "+num+" is -> "+solution5.IntToRoman(num));
		System.out.println();
		//Extra problem
		int[] nums1 = {1,2,3};
		int[] nums2 = {1,2,3};
		System.out.println(solution6.findMedianSortedArrays(nums1,nums2));
		System.out.println();
		//solution1
		System.out.println(format("2-4A0r7-4k",3));
		System.out.println(format("12j-----0h43n-j2n1-asd",4));
		System.out.println();
	}
	
	
	//solution 5
	static class solution5{
		public static String IntToRoman(int num) {
			String[] q = {"","M","MM","MMM"};
			String[] b = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
			String[] s = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
			String[] g = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
			String roman;
			int bonly = num - num/1000*1000;
			int sonly = bonly - bonly/100*100;
			roman = q[num/1000]+b[bonly/100]+s[sonly/10]+g[num%10];
			return roman;
		}
	}
	
	//Extra problem
	static class solution6{
		
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		if(n > m){
			return findMedianSortedArrays(nums2, nums1);
		}
		int L1 = 0,L2 = 0,R1 = 0,R2 = 0, c1, c2, low = 0, high = 2*n;
		while(low < high){
			c1 = (low + high)/2;
			c2 = m + n - c1;
			L1 = (c1 == 0)?Integer.MIN_VALUE:nums1[(c1-1)/2];
			R2 = (c1 == 2*n)?Integer.MAX_VALUE:nums1[c1/2];
			L2 = (c2 == 0)?Integer.MIN_VALUE:nums2[(c2-1)/2];
			R2 = (c2 == 2*n)?Integer.MAX_VALUE:nums2[c2/2];		
			if(L1 > R2){
				high = c1-1;
			}
			else if (L2 > R1){
				low = c1+1;
			}
			else break;
		}
		return (L1+L2+R1+R2)/2;
	    }

    }
	
	//Solution1
	public static String format(String s, int k){
		
		if(s==null || s.length() == 0|| k <= 0){
			return null;
		}
		char[] ch = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(int i = ch.length-1; i>=0; i--){
			if(ch[i] >= 97 && ch[i] <= 122){
				sb.append((char)(ch[i]-32));
			}
			else if (ch[i] == '-'){
				continue;
			}
			else
				sb.append(ch[i]);			
				count ++;
			if (count == k){
				sb.append('-');
				count = 0;
			}
		}
		
		return sb.reverse().toString();
		
	}
	

}
	
