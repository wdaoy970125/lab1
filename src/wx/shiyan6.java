package wx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class shiyan6 {
	private static String str;
	public static void main(String[] args) {
		    char a;
		    String express = null;
		    String express1 = null;
		    int posth = 0;
		    while(posth == 0){
	        Scanner s = new Scanner(System.in);
	        String str = null;
	        str = s.nextLine();
			int posth1 = str.indexOf("!");
			a = str.charAt(0);
			if( a == '!'){
				int pos1 = str.indexOf("!simplify");
				if(pos1 == 0){
					simplify(str,express);
				}
				int pos2 = str.indexOf("!d/d");
				if(pos2 == 0){
					derivative(str,express);
				}
			}
			if(a != '!'){
				express = str;
				expression(express);
			}
		    }
	}
	public static  void expression(String express) {
		int num[]={0,1,2,3,4,5,6,7,8,9};
		String sim1 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQQRST+*";
		String sim2 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQQRST";
		String sim3 = "+*";
		char num1 = 0;
		char num2 = 0;
		int Len1 = express.length();
		int x = 0;
		for(int i = 0;i < Len1;i ++){
			num1 = express.charAt(i);
			int position = sim1.indexOf(num1);
			if( position == -1){
				x = x+1;
				break;
			}
		}
		for(int i = 0;i < Len1-1;i ++){
			num1 = express.charAt(i);
			num2 = express.charAt(i+1);
			int position1 = sim2.indexOf(num1);
			int position2 = sim2.indexOf(num2);
			if(position1 > 0 & position2 >0){
				x = x+1;
				break;
			}
		}
		for(int i = 0;i < Len1-1;i ++){
			num1 = express.charAt(i);
			num2 = express.charAt(i+1);
			int position1 = sim3.indexOf(num1);
			int position2 = sim3.indexOf(num2);
			if(position1 > 0 & position2 >0){
				x = x+1;
				break;
			}
		}
		if(x > 0){
			System.out.println("Error,no variable");
		}
		else{
			System.out.printf("%s",express);
			return ;
			
		}
	
	}
	public static void simplify(String str,String express){
		express = "3x+2y";
		String st = null;
		int j = 13;
		String str3 = " ";
		int len = str.length();
		char []Arr = str.toCharArray();
		while(j<len-1){             //�ж������Ƿ�Ϸ�
			String str2 = String.valueOf(Arr[j]);
			int b = str3.indexOf(str2);
			if(b == 0){
				j = j + 4;
				
			}
			else{
				System.out.println("Error,no variable");  //���Ϸ����Error,no variable
				st = "Error";
				break;
			}
		}
		if(st == null){
			String simplifyNew = str.replaceAll(" ","");
			int len1 = simplifyNew.length();//�������ֵʽ���鳤��
			int len2 = express.length();//���ʽ���鳤��
			simplifyNew = simplifyNew.substring(9,len1);
			char [] Arr1 = simplifyNew.toCharArray();  //�������ֵʽ����
			char [] Arr2 = express.toCharArray();   //���ʽ����
			int i = 0;
			int l = 0;
			if(Arr1 == null){                   //�������Ϊ!simplify,���������ʽ
				System.out.println(express);
			}
			else{
				while(l<len1-10){             //�Ա���������֬���滻
					
					for(i = 0;i < len2;i++){
						String str4 = String.valueOf(Arr1[l]);
						String str1 = String.valueOf(Arr2[i]);
						
						int a = str4.indexOf(str1);
						if(a == 0){
							String expressNew = express.replace(Arr1[l],Arr1[l+2]);
							express = expressNew;
						}
					}
					l = l + 3;
				}
				System.out.println(express);       //����滻��ֵ��Ķ���ʽ
			}		
		}

		
	
    }
	public static void derivative(String str,String express){
		char num1;
		num1 = str.charAt(4);
		int position1 = express.indexOf(num1);
		if(position1 == -1){
			System.out.println("Error,no variable");
		}
		if(position1 >= 0){
			int position2 = express.indexOf("+");
			String str5 = null;
			String str1,str2;
			while(position2 >= 0){
				int a = express.length();
				str1 = express.substring( 0, position2 );
				express = express.substring( position2 + 1,a);
				int position3 = str1.indexOf(num1);
				if(position3 >= 0);{
					int num3 = str1.length();
					int ad = 0;
					for(int j = 0; j < num3;j++){
						if(num1 == str1.charAt(j)){
							ad = ad + 1;
						}
					}
					String a1[] = str1.split("%c",num1);
					a1[0] = a1[0] + "*"+ad;
					for(int x = 0;x < ad;x++){
						a1[0] = a1[0] + "*"+ num1;
					}
					StringBuffer sb = new StringBuffer();
					for(int i = 0; i < a1.length; i++){
					 sb. append(a1[i]);
					}
					String s = sb.toString();
					str5 = str5 + s;
				}
				System.out.printf("%s",str5);
			}
		}
	}

}
