package com.example.email_setting.service;

import com.example.email_setting.model.EmailSetting;

public interface IEmailSettingService {
    EmailSetting update(EmailSetting emailSetting);

    EmailSetting getDefault();
}
