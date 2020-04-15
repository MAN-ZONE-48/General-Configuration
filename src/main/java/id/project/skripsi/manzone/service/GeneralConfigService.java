package id.project.skripsi.manzone.service;

import com.java.common.lib.dto.Response;
import id.project.skripsi.manzone.domain.GeneralConfigurationWording;
import id.project.skripsi.manzone.dto.GeneralConfigDTO;
import id.project.skripsi.manzone.dto.GeneralConfigWordingDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public interface GeneralConfigService {

    Response getUserConfig(GeneralConfigDTO configDTO, HttpServletResponse response);
    Response insertGeneralConfigWording(GeneralConfigWordingDTO configWordingDTO, HttpServletResponse response);
    List<GeneralConfigurationWording> getGeneralWordingByLanguage(String language);
    List<GeneralConfigurationWording> getAllWording();
    String updateWording(int id, GeneralConfigWordingDTO configWordingDTO);
}
