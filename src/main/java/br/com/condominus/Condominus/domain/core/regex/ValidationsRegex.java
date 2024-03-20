package br.com.condominus.Condominus.domain.core.regex;

import br.com.condominus.Condominus.domain.User;
import br.com.condominus.Condominus.domain.dto.UserDTO;
import br.com.condominus.Condominus.domain.interfaces.UserValidations;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Data
@NoArgsConstructor
public class ValidationsRegex implements UserValidations {


    public Boolean regexDefault(String regex, String data) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    @Override
    public boolean isValidUser(User user) {
        return false;
    }

    @Override
    public boolean isValidDto(UserDTO data) {
        return false;
    }

    public boolean isValidEmail(String email){
        return regexDefault(RegexModels.regexEmail,email);

    }

    public boolean isValidName(String email){
        return regexDefault(RegexModels.regexEmail,email);

    }



}
