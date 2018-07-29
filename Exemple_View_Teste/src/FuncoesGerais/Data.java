package FuncoesGerais;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {
	//Lib Datas
	//Formato YYYYMMDD (20180705)
	public static String dataYYYYMMDD(){
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		    Date date = new Date();
		    return(dateFormat.format(date));
		}

	//Formato DDdMMmYYYY (05/07/2018)
		public static String dataDDbMMbYYYY(int dias){
			return(new SimpleDateFormat("dd/MM/yyyy").
					format(new Date().getTime()+(dias*24*3600*1000)));
		}

	//Formato ddMMyyyy (05072018)
		public static String dataDDMMYYYY(int dias){
			return(new SimpleDateFormat("ddMMyyyy").
					format(new Date().getTime()+(dias*24*3600*1000)));
		}

	//Formato DDdMMmYYYY_30 (*)
		/* public static String dataDDbMMbYYYY_30(){
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		    Date date = new Date();
		    String dia = dateFormat.format(date);
		    int a = Integer.parseInt(dia.substring(3, 5));
		    
		    if(a==1){
		    	a = 12;
		    	dia = dia.substring(0,3)+a+dia.substring(5,10);
		    }else if(a<=10){
		    	a = a - 1;
		    	dia = dia.substring(0,3)+"0"+a+dia.substring(5,10);
		    	System.out.println(a);
		    }else{
		    	a = a - 1;
		    	dia = dia.substring(0,3)+a+dia.substring(5,10);
		    }
		    return(dia);
		} */

	//Formato YYYY_MM_DD (2018_07_05)
		public static String dataYYYY_MM_DD(int dias){
			return(new SimpleDateFormat("yyyy_MM_dd").
					format(new Date().
							getTime()+(dias*24*3600*1000)));
		}
		
	//Formato DDMMYY (050718)
		public static String dataDDMMYY(int dias){
			return(new SimpleDateFormat("ddMMYY").
					format(new Date().
							getTime()+(dias*24*3600*1000)));
		}

	//Formato DD_MM (05_07)
		
		public static String dataDD_MM(){
			DateFormat dateFormat1 = new SimpleDateFormat("dd");
			DateFormat dateFormat2 = new SimpleDateFormat("_MM");
		    Date date = new Date();
		    int a = Integer.parseInt(dateFormat1.format(date)) - 1;
		    if(a<10){
		    	return("0"+ a + dateFormat2.format(date));
		    }
		    else{
		    	return(a + dateFormat2.format(date));
		    }
		}
}
