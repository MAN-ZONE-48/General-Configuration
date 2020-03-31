package id.project.skripsi.manzone.service;

import com.java.common.lib.dto.Response;
import id.project.skripsi.manzone.dto.GeneralConfigDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public interface GeneralConfigService {

    Response getUserConfig(GeneralConfigDTO configDTO, HttpServletResponse response);

}
