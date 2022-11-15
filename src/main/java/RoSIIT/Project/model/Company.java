package RoSIIT.Project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "firme")
public class Company {
    @Id
    private UUID id;
    @Column(name = "numeFirma")
    private String name;
    @Column(name = "CUI")
    private String codF;
    @Column(name = "Activ")
    private boolean activity;
    @Column(name = "Adresa")
    private String adress;


    public Company(){}

    public Company(UUID id, String name, String codF, boolean activity, String adress) {
        this.id = id;
        this.name = name;
        this.codF = codF;
        this.activity = activity;
        this.adress = adress;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodF() {
        return codF;
    }

    public void setCodF(String codF) {
        this.codF = codF;
    }

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
