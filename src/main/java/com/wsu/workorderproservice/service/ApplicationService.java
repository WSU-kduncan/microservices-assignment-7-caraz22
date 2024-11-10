package com.wsu.workorderproservice.service;

import com.wsu.workorderproservice.exception.InvalidRequestException;
import com.wsu.workorderproservice.exception.DatabaseErrorException;
import com.wsu.workorderproservice.model.Application;
import com.wsu.workorderproservice.repository.ApplicationRepository;

import jakarta.transaction.Transactional;

import java.util.Optional;

public class ApplicationService {
    
    private final ApplicationRepository applicationRepository;

    public Application get(Integer application_id) {
        Optional<Application> application = applicationRepository.findById(application_id);
        if (application.isEmpty()) {
            throw new InvalidRequestException("Invalid application ID");
        } 
        try {
            return applicationRepository.findById(application_id).orElse(null);
        } catch (Exception e) {
            log.error("Failed to retrieve application details. application_id:{}, Exception:{}", application_id, e);
            throw new DatabaseErrorException("Failed to retrieve application details.", e);
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public Application add(Application application) {
        try {
            // stuff???
        } catch (Exception e) {
            log.error("Failed to add application. Exception: ", e);
            throw new DatabaseErrorException("Failed to add application", e);
        }
    }

    @Transactional(rollbackOn = Exception.class) 
    public Application update(Integer application_id, Application application) {
        Optional<Application> applicationResp = applicationRepository.findById(application_id);
        if (applicationResp.isEmpty()) {
            throw new InvalidRequestException("Invalid application ID");
        }
        
        try {
            // stuff
        } catch (Exception e) {
            log.error("Failed to update application. application_id:{}, Exception:{}", application_id, e);
            throw new DatabaseErrorException("Failed to update application.", e);
        }
    }
}
