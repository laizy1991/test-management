package utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数字相关工具类
 * 
 * @createDate 2015年5月5日
 * 
 */
public class NumberUtil {

	public static int getBinary(String[] postions) {
		int result = 0;
		
		for(String position: postions) {
			int pos = Integer.parseInt(position) - 1;
			result |= (1 << pos);
		}
		
		return result;
	}
	
	public static String fen2yuan(Integer fen){
	    if( fen == null ){
            return "0.00";
        }
		return fen2yuan(new Long(fen));
	}
	
	public static String fen2yuan(Long fen){
        if( fen == null ){
            return "0.00";
        }
        final int MULTIPLIER = 100;  
        Pattern pattern = Pattern.compile("^[1-9][0-9]*{1}");  
        Matcher matcher = pattern.matcher(fen.toString());  
        
        if (matcher.matches()) {  
            return  new BigDecimal(fen).divide(new BigDecimal(MULTIPLIER)).setScale(2).toString();  
        } else {  
            return "0.00";  
        }  
    }
	private static final DecimalFormat decimalF = new DecimalFormat("###.##");
	public static float formatFloat(float val)
    {
        try {
            String num =  decimalF.format(val);
            return Float.parseFloat(num);
        } catch (Exception e) {
            //igore
        }
        return val;
    }
}
