package id.project.skripsi.manzone.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "general_configuration_wording")
public class GeneralConfigurationWording {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "last_modified")
    private Date lastModified;

    @Column(name = "gco_key_wording_eng")
    private String gcoKeyWordingEng;

    @Column(name = "gco_key_wording_ina")
    private String gcoKeyWordingIna;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

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

    public String getGcoKeyWordingEng() {
        return gcoKeyWordingEng;
    }

    public void setGcoKeyWordingEng(String gcoKeyWordingEng) {
        this.gcoKeyWordingEng = gcoKeyWordingEng;
    }

    public String getGcoKeyWordingIna() {
        return gcoKeyWordingIna;
    }

    public void setGcoKeyWordingIna(String gcoKeyWordingIna) {
        this.gcoKeyWordingIna = gcoKeyWordingIna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralConfigurationWording that = (GeneralConfigurationWording) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(lastModified, that.lastModified) &&
                Objects.equals(gcoKeyWordingEng, that.gcoKeyWordingEng) &&
                Objects.equals(gcoKeyWordingIna, that.gcoKeyWordingIna);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, lastModified, gcoKeyWordingEng, gcoKeyWordingIna);
    }

    @Override
    public String toString() {
        return "GeneralConfigurationWording{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", lastModified=" + lastModified +
                ", gcoKeyWordingEng='" + gcoKeyWordingEng + '\'' +
                ", gcoKeyWordingIna='" + gcoKeyWordingIna + '\'' +
                '}';
    }
}
