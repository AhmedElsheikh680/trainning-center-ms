
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class PasswordUtil {
    
    @Autowired
    static PasswordEncoder  passwordEncoder;
    public static void main(String[] args) {
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String en = encoder.encode("0000");
//       boolean  dd = encoder.matches(en,"$2a$10$2I4ewkm40/crDkTr.NdfueYGHxTc1UH3W6.zhY6Wlm0Qdu7DYqec2");
//        System.out.println(dd);
//        System.out.println(en);
    }
}
