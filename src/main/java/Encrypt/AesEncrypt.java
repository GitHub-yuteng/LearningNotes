package Encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author Yu
 */
public class AesEncrypt {
    public static void main(String[] args) throws Exception {

        String clearText = "abc";

        //TODO 提供原始密钥：长度64位，8个字节 如果超过8位：java.security.InvalidKeyException: Wrong key size
        //TODO 优化长度
        String originkey = "1";

        String cipherText = aesEncrypt(clearText, originkey);
        System.out.println(cipherText);//TODO 乱码  clearText.getBytes() GBK  -> DES 加密(出错) -> GBK 解码  使用Base64解码

        String clear = aesDecrypt(cipherText, originkey);
        System.out.println(clear);

    }

    private static String aesDecrypt(String cipherText, String originkey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = getKey(originkey);
        cipher.init(Cipher.DECRYPT_MODE, key);

        Base64.Decoder decoder = Base64.getDecoder();//TODO 先用Base64 解码，然后在用 Cipher解码
        byte[] decode = decoder.decode(cipherText.getBytes());

        byte[] doFinal = cipher.doFinal(decode);
        return new String(doFinal);
    }

    /**
     * @param clearText 明文
     * @param originkey 密钥
     * @return
     * @throws NoSuchPaddingException    填充异常
     * @throws NoSuchAlgorithmException  算法异常
     * @throws InvalidKeyException       无效密钥异常
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    private static String aesEncrypt(String clearText, String originkey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance("AES");//TODO 获取加密工具类，指定加密算法 DES
        SecretKeySpec key = getKey(originkey);
        /**
         * ENCRYPT_MODE 加密模式
         * key：对原始密钥处理之后的密钥
         */
        cipher.init(Cipher.ENCRYPT_MODE, key);//TODO 对加密工具类对象进行初始化

        //TODO 用加密工具类对明文进行加密  -> 密文
        byte[] bytes = cipher.doFinal(clearText.getBytes());//TODO GBK -> 换Base64 解码

        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodeBase64 = encoder.encode(bytes);

        return new String(encodeBase64);
    }

    /**
     * @param originkey
     * @return
     */
    private static SecretKeySpec getKey(String originkey) {

        byte[] buffer = new byte[16];//TODO 默认数组元素初始化 0
        byte[] originkeyBytes = originkey.getBytes();

        for (int i = 0; i < 16 && i < originkeyBytes.length; i++) {
            buffer[i] = originkeyBytes[i];
        }

        //TODO 根据给定的字节数组，构造一个密钥
        SecretKeySpec key = new SecretKeySpec(buffer, "AES");
        return key;
    }
}
