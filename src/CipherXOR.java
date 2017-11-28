import java.io.UnsupportedEncodingException;

public class CipherXOR {

    /*
Метод для шифрування тексту. Може викидати помилки типу UnsupportedEncodingException
     */
    public static byte[] xorЕncrypt(String text, byte[] keyWord) throws UnsupportedEncodingException {
        byte[] arr = text.getBytes("UTF-8");

        byte[] result = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = (byte) (arr[i] ^ keyWord[i % keyWord.length]);
        }
        return result;
    }
/*
Метод для дешифрування тексту
 */
    public static String xorDecrypt(String text, byte[] keyWord) throws UnsupportedEncodingException {
        byte[] result = text.getBytes("UTF-8");
        byte[] keyarr = keyWord;
        for (int i = 0; i < result.length; i++) {
            result[i] = (byte) (result[i] ^ keyarr[i % keyarr.length]);
        }
        return new String(result);
    }
}
