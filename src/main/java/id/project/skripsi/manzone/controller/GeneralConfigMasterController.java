package id.project.skripsi.manzone.controller;

import com.java.common.lib.dto.Response;
import id.project.skripsi.manzone.dto.GeneralConfigDTO;
import id.project.skripsi.manzone.service.GeneralConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/v1")
public class GeneralConfigMasterController {

    final GeneralConfigService generalConfigService;

    @Autowired
    public GeneralConfigMasterController(GeneralConfigService generalConfigService) {
        this.generalConfigService = generalConfigService;
    }

    @PostMapping("/getGeneralConfig")
    public ResponseEntity getGeneralConfig(@RequestBody GeneralConfigDTO configDTO, HttpServletResponse response){
        Response currentGeneralConfig = generalConfigService.getUserConfig(configDTO, response);
        return new ResponseEntity(currentGeneralConfig, HttpStatus.OK);
    }

}
