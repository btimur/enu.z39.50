package kz.arta.ext.sport.model.synergy;

import java.util.ArrayList;

/**
 * Created by admin on 20.10.14.
 */
public class Position extends Element{
    public String branchID;
    public String code;
    public String name;
    public String nameEn;
    public String nameKz;
    public String nameRu;
    public int needed;
    public int number;
    public int objectivesSetType;
    public Element parentDepartment;
    public String parentDepartmentID;
    public int parentDepartmentType;
    public java.util.ArrayList<SimplePerson>  persons;
    public String pointersCode;
    public String positionID;
    public String managerID;
    public int positionType;
    public double salary;
    public boolean appointmentAllowed;
    public boolean editable;

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getBranchID() {
        return branchID;
    }

    public String getPointersCode() {
        return pointersCode;
    }

    public void setPointersCode(String pointersCode) {
        this.pointersCode = pointersCode;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameKz() {
        return nameKz;
    }

    public void setNameKz(String nameKz) {
        this.nameKz = nameKz;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public int getNeeded() {
        return needed;
    }

    public void setNeeded(int needed) {
        this.needed = needed;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getObjectivesSetType() {
        return objectivesSetType;
    }

    public void setObjectivesSetType(int objectivesSetType) {
        this.objectivesSetType = objectivesSetType;
    }

    public Element getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(Element parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    public String getParentDepartmentID() {
        return parentDepartmentID;
    }

    public void setParentDepartmentID(String parentDepartmentID) {
        this.parentDepartmentID = parentDepartmentID;
    }

    public int getParentDepartmentType() {
        return parentDepartmentType;
    }

    public void setParentDepartmentType(int parentDepartmentType) {
        this.parentDepartmentType = parentDepartmentType;
    }

    public ArrayList<SimplePerson> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<SimplePerson> persons) {
        this.persons = persons;
    }



    public String getPositionID() {
        return positionID;
    }

    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }

    public int getPositionType() {
        return positionType;
    }

    public void setPositionType(int positionType) {
        this.positionType = positionType;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isAppointmentAllowed() {
        return appointmentAllowed;
    }

    public void setAppointmentAllowed(boolean appointmentAllowed) {
        this.appointmentAllowed = appointmentAllowed;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}
