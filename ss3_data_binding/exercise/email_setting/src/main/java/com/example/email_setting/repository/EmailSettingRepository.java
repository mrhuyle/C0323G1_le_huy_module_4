package com.example.email_setting.repository;

import com.example.email_setting.model.EmailSetting;
import org.springframework.stereotype.Repository;

@Repository
public class EmailSettingRepository implements IEmailSettingRepository {
    private static EmailSetting defaultEmailSetting = new EmailSetting("English",25,true,"Default Signature");


    @Override
    public EmailSetting update(EmailSetting emailSetting) {
        EmailSetting newEmailSetting = new EmailSetting(emailSetting.getLanguage(),emailSetting.getPageSize(), emailSetting.isSpam(), emailSetting.getSignature());
        return newEmailSetting;
    }

    @Override
    public EmailSetting getDefault() {
        return defaultEmailSetting;
    }
}
