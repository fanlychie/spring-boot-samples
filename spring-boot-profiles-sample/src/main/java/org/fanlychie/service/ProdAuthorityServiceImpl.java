package org.fanlychie.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by fanlychie on 2017/7/10.
 */
@Service
@Profile("prod")
public class ProdAuthorityServiceImpl implements AuthorityService {

    @Override
    public boolean hasRole(String role) {
        return role == "admin";
    }

}