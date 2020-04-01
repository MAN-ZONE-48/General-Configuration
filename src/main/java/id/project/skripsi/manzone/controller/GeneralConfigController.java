package id.project.skripsi.manzone.controller;

import com.java.common.lib.dto.Response;
import id.project.skripsi.manzone.dto.GeneralConfigDTO;
import id.project.skripsi.manzone.service.GeneralConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/v1")
public class GeneralConfigController {

    final GeneralConfigService generalConfigService;

    @Autowired
    public GeneralConfigController(GeneralConfigService generalConfigService) {
        this.generalConfigService = generalConfigService;
    }

    @PostMapping("/getGeneralConfig")
    public ResponseEntity getGeneralConfig(@RequestHeader(name = "Authorization") String token, @RequestBody GeneralConfigDTO configDTO, HttpServletResponse response){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer "+token);

        Response currentGeneralConfig = generalConfigService.getUserConfig(configDTO, response);
        return new ResponseEntity(currentGeneralConfig, HttpStatus.OK);
    }

}
