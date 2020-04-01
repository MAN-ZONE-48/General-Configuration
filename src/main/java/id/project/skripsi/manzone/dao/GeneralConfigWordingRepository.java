package id.project.skripsi.manzone.dao;

import id.project.skripsi.manzone.domain.GeneralConfigurationWording;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GeneralConfigWordingRepository extends JpaRepository<GeneralConfigurationWording, String> {
}
