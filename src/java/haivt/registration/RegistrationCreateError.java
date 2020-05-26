/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.registration;

import java.io.Serializable;

/**
 *
 * @author vuthi
 */
public class RegistrationCreateError implements Serializable {

    private String emailErr;
    private String nameErr;
    private String passwordErr;
    private String confirmNotMatch;
    private String emailIsExisted;

    public RegistrationCreateError(String emailErr, String nameErr, String passwordErr, String confirmNotMatch, String emailIsExisted) {
        this.emailErr = emailErr;
        this.nameErr = nameErr;
        this.passwordErr = passwordErr;
        this.confirmNotMatch = confirmNotMatch;
        this.emailIsExisted = emailIsExisted;
    }

    public RegistrationCreateError() {
    }

    public String getEmailErr() {
        return emailErr;
    }

    public void setEmailErr(String emailErr) {
        this.emailErr = emailErr;
    }

    public String getNameErr() {
        return nameErr;
    }

    public void setNameErr(String nameErr) {
        this.nameErr = nameErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getConfirmNotMatch() {
        return confirmNotMatch;
    }

    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }

    public String getEmailIsExisted() {
        return emailIsExisted;
    }

    public void setEmailIsExisted(String emailIsExisted) {
        this.emailIsExisted = emailIsExisted;
    }

}
