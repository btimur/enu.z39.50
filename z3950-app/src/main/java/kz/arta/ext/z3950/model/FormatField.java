package kz.arta.ext.z3950.model;

import kz.arta.ext.common.model.IEntity;

import javax.persistence.*;

/**
 * Created by timur on 8/22/2014 12:15 PM.
 */
@Entity
@Table(name = "format_fields", schema = "", catalog = "z3950")
public class FormatField implements IEntity {
    private Long id;
    private String mformat;
    private String fieldName;
    private Long blockId;
    private String descr;
    private Boolean isSubField;
    private Boolean isMandatory;
    private Boolean isRepeatable;
    private String fieldComment;
    private Long parentFieldId;
    private String notes;
    private String fieldAlias;
    private String objectField;

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MFORMAT")
    public String getMformat() {
        return mformat;
    }

    public void setMformat(String mformat) {
        this.mformat = mformat;
    }

    @Basic
    @Column(name = "FIELD_NAME")
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Basic
    @Column(name = "BLOCK_ID")
    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    @Basic
    @Column(name = "DESCR")
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Basic
    @Column(name = "IS_SUB_FIELD")
    public Boolean getIsSubField() {
        return isSubField;
    }

    public void setIsSubField(Boolean isSubField) {
        this.isSubField = isSubField;
    }

    @Basic
    @Column(name = "IS_MANDATORY")
    public Boolean getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(Boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    @Basic
    @Column(name = "IS_REPEATABLE")
    public Boolean getIsRepeatable() {
        return isRepeatable;
    }

    public void setIsRepeatable(Boolean isRepeatable) {
        this.isRepeatable = isRepeatable;
    }

    @Basic
    @Column(name = "FIELD_COMMENT")
    public String getFieldComment() {
        return fieldComment;
    }

    public void setFieldComment(String fieldComment) {
        this.fieldComment = fieldComment;
    }

    @Basic
    @Column(name = "PARENT_FIELD_ID")
    public Long getParentFieldId() {
        return parentFieldId;
    }

    public void setParentFieldId(Long parentFieldId) {
        this.parentFieldId = parentFieldId;
    }

    @Basic
    @Column(name = "NOTES")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "FIELD_ALIAS")
    public String getFieldAlias() {
        return fieldAlias;
    }

    public void setFieldAlias(String fieldAlias) {
        this.fieldAlias = fieldAlias;
    }

    @Basic
    @Column(name = "OBJECT_FIELD")
    public String getObjectField() {
        return objectField;
    }

    public void setObjectField(String objectField) {
        this.objectField = objectField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormatField that = (FormatField) o;

        if (blockId != null ? !blockId.equals(that.blockId) : that.blockId != null) return false;
        if (descr != null ? !descr.equals(that.descr) : that.descr != null) return false;
        if (fieldComment != null ? !fieldComment.equals(that.fieldComment) : that.fieldComment != null) return false;
        if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (isMandatory != null ? !isMandatory.equals(that.isMandatory) : that.isMandatory != null) return false;
        if (isRepeatable != null ? !isRepeatable.equals(that.isRepeatable) : that.isRepeatable != null) return false;
        if (isSubField != null ? !isSubField.equals(that.isSubField) : that.isSubField != null) return false;
        if (mformat != null ? !mformat.equals(that.mformat) : that.mformat != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (parentFieldId != null ? !parentFieldId.equals(that.parentFieldId) : that.parentFieldId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (mformat != null ? mformat.hashCode() : 0);
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        result = 31 * result + (blockId != null ? blockId.hashCode() : 0);
        result = 31 * result + (descr != null ? descr.hashCode() : 0);
        result = 31 * result + (isSubField != null ? isSubField.hashCode() : 0);
        result = 31 * result + (isMandatory != null ? isMandatory.hashCode() : 0);
        result = 31 * result + (isRepeatable != null ? isRepeatable.hashCode() : 0);
        result = 31 * result + (fieldComment != null ? fieldComment.hashCode() : 0);
        result = 31 * result + (parentFieldId != null ? parentFieldId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
