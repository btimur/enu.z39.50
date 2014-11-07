package kz.arta.ext.sport.model.synergy;

import javax.persistence.*;
import java.util.List;

/**
 * Created by admin on 28.10.14.
 */
@Entity
@Table(name = "spt_region")
public class RegionLocation {

    /**
     * идентификатор
     */
    @Id
    @Column(name = "ID")
    private Long  Id;

    /**
     * наименование
     */
    @Column(name = "NAME_RU")
    private String nameRu;

    @JoinColumn(name="PARENT_ID")
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH })
    private RegionLocation parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RegionLocation> childs;

    /**
     * тип
     */
    @Column(name = "TYPE")
    private Integer typeLocation;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public RegionLocation getParent() {
        return parent;
    }

    public void setParent(RegionLocation parent) {
        this.parent = parent;
    }

    public List<RegionLocation> getChilds() {
        return childs;
    }

    public void setChilds(List<RegionLocation> childs) {
        this.childs = childs;
    }

    public Integer getTypeLocation() {
        return typeLocation;
    }

    public void setTypeLocation(Integer typeLocation) {
        this.typeLocation = typeLocation;
    }
}
