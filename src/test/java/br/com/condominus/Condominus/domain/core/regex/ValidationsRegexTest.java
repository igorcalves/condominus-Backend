package br.com.condominus.Condominus.domain.core.regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationsRegexTest {

    private ValidationsRegex validationsRegex = new ValidationsRegex();

    @Test
    public void testRightEmail(){
        String email1 = "example@example.com.br";
        String email2 = "example@example.com";
        String email3 = "123example123@example.com.br";
        assertTrue(validationsRegex.regexDefault(RegexModels.regexEmail,email1));
        assertTrue(validationsRegex.regexDefault(RegexModels.regexEmail,email2));
        assertTrue(validationsRegex.regexDefault(RegexModels.regexEmail,email3));
    }

    @Test
    public void testWrongtEmail(){
        String email1 = "example@e1xample.com.br";
        String email2 = "exa mple@example.com";
        String email3 = "123example123@example.co1m";
        String email4 = "123example123@example.com.br1";
        String email5 = "123example123@example.com.  ";
        String email6 = "123example123@example.  .br";
        String email7 = "exa mple exa mple.com";
        assertFalse(validationsRegex.regexDefault(RegexModels.regexEmail,email1));
        assertFalse(validationsRegex.regexDefault(RegexModels.regexEmail,email2));
        assertFalse(validationsRegex.regexDefault(RegexModels.regexEmail,email3));
        assertFalse(validationsRegex.regexDefault(RegexModels.regexEmail,email4));
        assertFalse(validationsRegex.regexDefault(RegexModels.regexEmail,email5));
        assertFalse(validationsRegex.regexDefault(RegexModels.regexEmail,email6));
        assertFalse(validationsRegex.regexDefault(RegexModels.regexEmail,email7));

    }


    @Test
    void isValidName() {

        String name1 = "igor Alves";

        assertTrue(validationsRegex.regexDefault(RegexModels.regexName,name1));
    }
}