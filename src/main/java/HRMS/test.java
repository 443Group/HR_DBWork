package HRMS;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;

public class test {
    public static void main(String[] args) {
//        用户名3015216117 密码nmklp666
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//        String result = encoder.encode("nmklp666");
        String result = "$2a$16$O460J26yZO6eFiFE/cHF3emOwugkDRfaEYm1wPnPkKi.OahqsIcKG";
//        assertTrue(encoder.matches("myPassword",result));
        ;
//        System.out.println(encoder.matches("myPassword",result));
//        System.out.println(encoder.matches("myPassword","$2a$16$5ouLSQFyt2Or9lA36Ag1DuZfiUybzSzAUMndwjvqCFVQR0163Rudm"));
        System.out.println(result);
        System.out.println(result.length());
    }
}
