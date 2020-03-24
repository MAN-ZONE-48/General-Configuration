package id.project.skripsi.manzone.service.impl;

import com.java.common.lib.dto.Response;
import id.project.skripsi.manzone.service.GeneralConfigService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class GeneralConfigServiceImpl implements GeneralConfigService {

    @Override
    public Response getUserConfig(Authentication authentication) {
        return null;
    }
}
