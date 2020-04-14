package id.project.skripsi.manzone.dao;

import id.project.skripsi.manzone.domain.GeneralConfigurationWording;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface GeneralConfigWordingRepository extends JpaRepository<GeneralConfigurationWording, String> {

    @Query(value = "SELECT a.gcoKeyWordingIna FROM GeneralConfigurationWording a")
    List<GeneralConfigurationWording> getAllIndonesiaWording();

    @Query(value = "SELECT a.gcoKeyWordingEng FROM GeneralConfigurationWording a")
    List<GeneralConfigurationWording>getAllEnglishWording();
}
