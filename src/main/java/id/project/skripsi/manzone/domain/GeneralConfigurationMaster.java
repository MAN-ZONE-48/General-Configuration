package id.project.skripsi.manzone.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "general_configuration_master")
public class GeneralConfigurationMaster {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "gco_id")
    private String id;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastModified;

    @Column(name = "gco_lang_select")
    private String gcoLangSelect;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getGcoLangSelect() {
        return gcoLangSelect;
    }

    public void setGcoLangSelect(String gcoLangSelect) {
        this.gcoLangSelect = gcoLangSelect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralConfigurationMaster that = (GeneralConfigurationMaster) o;
        return id.equals(that.id) &&
                createdAt.equals(that.createdAt) &&
                lastModified.equals(that.lastModified) &&
                gcoLangSelect.equals(that.gcoLangSelect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, lastModified, gcoLangSelect);
    }

    @Override
    public String toString() {
        return "GeneralConfigurationMaster{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", lastModified=" + lastModified +
                ", gcoLangSelect='" + gcoLangSelect + '\'' +
                '}';
    }
}
