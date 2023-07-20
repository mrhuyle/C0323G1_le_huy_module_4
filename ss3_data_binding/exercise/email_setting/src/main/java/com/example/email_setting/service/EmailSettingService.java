package com.example.email_setting.service;

import com.example.email_setting.model.EmailSetting;
import com.example.email_setting.repository.IEmailSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSettingService implements IEmailSettingService {
    @Autowired
    public IEmailSettingRepository emailSettingRepository;

    @Override
    public EmailSetting update(EmailSetting emailSetting) {
        return emailSettingRepository.update(emailSetting);
    }

    @Override
    public EmailSetting getDefault() {
        return emailSettingRepository.getDefault();
    }
}
