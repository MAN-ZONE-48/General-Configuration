package id.project.skripsi.manzone.service;

import com.java.common.lib.dto.Response;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface GeneralConfigService {

    Response getUserConfig(Authentication authentication);

}
