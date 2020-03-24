package id.project.skripsi.manzone.controller;

import com.java.common.lib.dto.Response;
import id.project.skripsi.manzone.service.GeneralConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class GeneralConfigController {

    final GeneralConfigService generalConfigService;

    @Autowired
    public GeneralConfigController(GeneralConfigService generalConfigService) {
        this.generalConfigService = generalConfigService;
    }

    @GetMapping("/getGeneralConfig")
    public ResponseEntity getGeneralConfig(@RequestHeader(name = "Authorization") String token){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer "+token);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Response currentGeneralConfig = generalConfigService.getUserConfig(auth);
        return new ResponseEntity(currentGeneralConfig, HttpStatus.OK);
    }

}
