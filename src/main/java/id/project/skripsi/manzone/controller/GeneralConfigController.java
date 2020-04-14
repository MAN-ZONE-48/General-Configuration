package id.project.skripsi.manzone.controller;

import com.java.common.lib.constant.StatusConstant;
import com.java.common.lib.dto.Response;
import id.project.skripsi.manzone.constant.AppConstant;
import id.project.skripsi.manzone.domain.GeneralConfigurationWording;
import id.project.skripsi.manzone.dto.GeneralConfigDTO;
import id.project.skripsi.manzone.dto.GeneralConfigWordingDTO;
import id.project.skripsi.manzone.service.GeneralConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class GeneralConfigController {

    final GeneralConfigService generalConfigService;

    @Autowired
    public GeneralConfigController(GeneralConfigService generalConfigService) {
        this.generalConfigService = generalConfigService;
    }

    @PostMapping("/getGeneralConfig")
    public ResponseEntity getGeneralConfig(@RequestBody GeneralConfigDTO configDTO, HttpServletResponse response){
        Response currentGeneralConfig = generalConfigService.getUserConfig(configDTO, response);
        return new ResponseEntity(currentGeneralConfig, HttpStatus.OK);
    }

    @PostMapping("/insertWording")
    public ResponseEntity insertGeneralWording(@RequestBody GeneralConfigWordingDTO configWordingDTO, HttpServletResponse response){
        Response currentGeneralWording = generalConfigService.insertGeneralConfigWording(configWordingDTO,response);
        return new ResponseEntity(currentGeneralWording,HttpStatus.OK);
    }

    @GetMapping("/getAllWording")
    public ResponseEntity getWordingBasedOnLanguage(@RequestParam(required = false) String language, HttpServletResponse response){
        if(language.equals(null) ||language.isEmpty()) language = AppConstant.DEFAULT_LANGUAGE;
        List<GeneralConfigurationWording> currentWording = generalConfigService.getGeneralWordingByLanguage(language);
        return new ResponseEntity(new Response(false, response.getStatus(), StatusConstant.OK.getMessage(),currentWording) , HttpStatus.OK);

    }
}
