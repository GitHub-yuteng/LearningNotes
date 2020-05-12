package Encrypt;

/**
 * @author Yu
 */
public class CaesarEncrypt {
    public static void main(String[] args) {
        //TODO 明文：原始信息
        String clearText = "information security";
        //TODO 加密规则：将字母按照字母表的顺序向右移动 key 位
        int key = 3;
        //TODO 密文
        String cipher = encrypt(clearText, key);
        System.out.println(cipher);

        //TODO 解密规则：将字母按照字母表的顺序向左移动 key 位
        String text = decrypt(cipher, key);
        System.out.println(text);
    }

    public static String encrypt(String clearText, int key) {

        char[] charArray = clearText.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
//            char c = (char) (charArray[i] + 3);
//            charArray[i] = c;
            charArray[i] += key;
        }
        return new String(charArray);
    }

    public static String decrypt(String cipherText, int key) {

        char[] charArray = cipherText.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            charArray[i] -= key;
        }
        return new String(charArray);
    }
}
