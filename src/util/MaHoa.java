package util;

import java.security.MessageDigest;
import java.util.Base64;
//import javax.xml.bind.DatatypeConverter;
//import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class MaHoa {
    // md5
    // sha-1 => thường được sử dụng

    public static String toMD5(String str) {
        String salt = "nguyenhungcuongdangmahoamatkhaunay";// Làm cho mật khẩu phức tap
//        String result = null;

        str = str + salt;

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));

            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
//        }
        }
        return null;
    }

    public static void main(String[] args) {
        // System.out.println(toSHA1("123456"));
        MaHoa md5 = new MaHoa();
        System.out.println(md5.toMD5("123456"));
    }

}
