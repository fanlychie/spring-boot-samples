package org.fanlychie.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by fanlychie on 2017/7/10.
 */
@Service
@Profile("dev")
public class DevAuthorityServiceImpl implements AuthorityService {

    @Override
    public boolean hasRole(String role) {
        return true;
    }

}