package RoSIIT.Project.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "records")
public class Decl {
    @Id
    @NonNull
    private UUID idRecord;
    @Column(name = "An_depunere")
    private String year;
    @Column(name = "Luna_depunere")
    private String month;
    @Column(name = "Nume_declaratie")
    private String nameRecord;
    @Column(name = "Tip_declaratie")
    private String typeRecord;
    @Column(name = "Observatii")
    private String obs;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "company_decl_relation",
            joinColumns = @JoinColumn(name="company_id"),
            inverseJoinColumns = @JoinColumn(name = "decl_id")
    )
    private List<Decl> decl;
    public Decl(){
    }

    public Decl(@NonNull UUID idRecord, String year, String month, String nameRecord, String typeRecord, String obs) {
        this.idRecord = idRecord;
        this.year = year;
        this.month = month;
        this.nameRecord = nameRecord;
        this.typeRecord = typeRecord;
        this.obs = obs;

    }

    @NonNull
    public UUID getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(@NonNull UUID idRecord) {
        this.idRecord = idRecord;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getNameRecord() {
        return nameRecord;
    }

    public void setNameRecord(String nameRecord) {
        this.nameRecord = nameRecord;
    }

    public String getTypeRecord() {
        return typeRecord;
    }

    public void setTypeRecord(String typeRecord) {
        this.typeRecord = typeRecord;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
