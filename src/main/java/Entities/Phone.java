package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "phone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p")
    , @NamedQuery(name = "Phone.findById", query = "SELECT p FROM Phone p WHERE p.id = :id")
    , @NamedQuery(name = "Phone.findByNumber", query = "SELECT p FROM Phone p WHERE p.number = :number")
    , @NamedQuery(name = "Phone.findByDescription", query = "SELECT p FROM Phone p WHERE p.description = :description")})
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "number")
    private String number;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "idperson", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person idperson;

    public Phone() {
    }

    public Phone(Integer id) {
        this.id = id;
    }

    public Phone(Integer id, String number, String description) {
        this.id = id;
        this.number = number;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getIdperson() {
        return idperson;
    }

    public void setIdperson(Person idperson) {
        this.idperson = idperson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Phone[ id=" + id + " ]";
    }
    
}
