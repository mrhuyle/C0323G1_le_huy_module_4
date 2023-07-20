package com.example.email_setting.repository;

import com.example.email_setting.model.EmailSetting;

public interface IEmailSettingRepository {
    EmailSetting update(EmailSetting emailSetting);
    EmailSetting getDefault();
}
