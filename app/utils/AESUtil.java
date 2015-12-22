package utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import play.Logger;
import play.libs.Codec;

/**
 * AES编码/解码工具类
 */
public class AESUtil {
	
	private static final String KEY = "hGRqjyGiG41WlvKw";

	/**
	 * 加密,给统计日志使用
	 * @param value
	 * @return
	 */
    public static String encryptAES(String value) {
        try {
            byte[] raw = KEY.getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            return Codec.byteToHexString(cipher.doFinal(value.getBytes()));
        } catch (Exception ex) {
        	Logger.warn(ex, "value"+value);
            return value;
        }
    }
    
    /**
     * 解密,给统计日志使用
     * @param value
     * @param privateKey
     * @return
     */
    public static String decryptAES(String value) {
        try {
            byte[] raw = KEY.getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            return new String(cipher.doFinal(Codec.hexStringToByte(value)));
        } catch (Exception ex) {
        	Logger.warn(ex, "value"+value);
            return value;
        }
    }
}
