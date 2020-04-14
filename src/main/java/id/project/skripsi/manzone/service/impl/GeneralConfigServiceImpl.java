package id.project.skripsi.manzone.service.impl;


import com.java.common.lib.constant.StatusConstant;
import com.java.common.lib.dto.Response;
import id.project.skripsi.manzone.constant.AppConstant;
import id.project.skripsi.manzone.dao.AppSettingRepository;
import id.project.skripsi.manzone.dao.GeneralConfigWordingRepository;
import id.project.skripsi.manzone.domain.GeneralConfigurationWording;
import id.project.skripsi.manzone.dto.GeneralConfigDTO;
import id.project.skripsi.manzone.dto.GeneralConfigWordingDTO;
import id.project.skripsi.manzone.dto.response.GeneralConfigResponse;
import id.project.skripsi.manzone.service.GeneralConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Service
public class GeneralConfigServiceImpl implements GeneralConfigService {

    final AppSettingRepository appSettingRepository;
    final GeneralConfigWordingRepository generalConfigWordingRepository;

    @Autowired
    public GeneralConfigServiceImpl(AppSettingRepository appSettingRepository, GeneralConfigWordingRepository generalConfigWordingRepository) {
        this.appSettingRepository = appSettingRepository;
        this.generalConfigWordingRepository = generalConfigWordingRepository;
    }

    @Override
    public Response getUserConfig(GeneralConfigDTO configDTO, HttpServletResponse response) {
        Map<String,String> currentSetting = appSettingRepository.getSettingsAsMap(configDTO.getCategory());
        String[] settings = currentSetting.get(AppConstant.LANG_SELECT).split(",");

        return new Response(false,response.getStatus(), StatusConstant.OK.getMessage(),insertGeneralConfig(configDTO,settings));
    }

    @Override
    public Response insertGeneralConfigWording(GeneralConfigWordingDTO configWordingDTO, HttpServletResponse response) {
        GeneralConfigurationWording currentConfigurationWording = new GeneralConfigurationWording();
        currentConfigurationWording.setGcoKeyWordingIna(configWordingDTO.getWordingIndonesia());
        currentConfigurationWording.setGcoKeyWordingEng(configWordingDTO.getWordingEnglish());

        generalConfigWordingRepository.save(currentConfigurationWording);
        return new Response(false, response.getStatus(),StatusConstant.OK.getMessage(),AppConstant.SUCCESS_INSERT);

    }

    @Override
    public List<GeneralConfigurationWording> getGeneralWordingByLanguage(String language) {
        List<GeneralConfigurationWording> currentWording = language.equals(AppConstant.INDONESIA_LANGUAGE) ?
                generalConfigWordingRepository.getAllIndonesiaWording() :
                generalConfigWordingRepository.getAllEnglishWording();
        return currentWording;
    }

    @Override
    public List<GeneralConfigurationWording> getAllWording() {
        List<GeneralConfigurationWording> wordingList = generalConfigWordingRepository.findAll();
        return wordingList;
    }

    private GeneralConfigResponse insertGeneralConfig(GeneralConfigDTO configDTO,String[] settings) {
        GeneralConfigResponse configResponse = new GeneralConfigResponse();
        configResponse.setUser_lang_select(checkLanguage(configDTO,settings));

        return configResponse;
    }

    private String checkLanguage(GeneralConfigDTO configDTO, String[] settings) {
        String currentLanguage = "";
        for(int index = 0; index < settings.length ; index++){
            if(configDTO.getLanguageSelect().equals(settings[0]))
                currentLanguage = settings[0];
            else
                currentLanguage = settings[1];
        }
        return currentLanguage;
    }

}
