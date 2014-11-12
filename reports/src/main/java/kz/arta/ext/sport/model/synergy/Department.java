package kz.arta.ext.sport.model.synergy;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by timur on 8/28/2014 11:00 AM.
 */
@Entity
@Table(name = "spt_department")
public class Department {

    @Id
    @Column(name = "DEPARTMENT_ID")
    private String  departmentID;

    @Column(name = "NUMBER")
    private int  number;

    @Column(name = "BRANCH")
    private boolean  branch;

    @Transient
    private String  parentDepartmentID;

    @ManyToOne
    @JoinColumn(name="PARENT_ID")
//    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
//            CascadeType.REFRESH })
    private Department parent;

    @Transient
    private String name;

    @Column(name = "NAME_RU")
    private String nameRu;

    @Column(name = "NAME_KZ")
    private String nameKz;

    @Column(name = "NAME_EN")
    private String nameEn;

    @Column(name = "POINTERS_CODE")
    private String pointersCode;

//    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Department> childs;

    @Transient
    private Position manager;

//    public List<Department> getChilds() {
//        return childs;
//    }
//
//    public void setChilds(List<Department> childs) {
//        this.childs = childs;
//    }

    public Position getManager() {
        return manager;
    }

    public void setManager(Position manager) {
        this.manager = manager;
    }

    public String getPointersCode() {
        return pointersCode;
    }

    public void setPointersCode(String pointersCode) {
        this.pointersCode = pointersCode;
    }

    public String getNameKz() {
        return nameKz;
    }

    public void setNameKz(String nameKz) {
        this.nameKz = nameKz;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public int getNumber() {
        return number;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBranch() {
        return branch;
    }

    public void setBranch(boolean branch) {
        this.branch = branch;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getParentDepartmentID() {
        return parentDepartmentID;
    }

    public void setParentDepartmentID(String parentDepartmentID) {
        this.parentDepartmentID = parentDepartmentID;
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }
}

