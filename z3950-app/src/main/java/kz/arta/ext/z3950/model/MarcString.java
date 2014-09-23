package kz.arta.ext.z3950.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timur on 8/21/2014 9:14 PM.
 */
public class MarcString {
//    private String marc;
    private List<MarcTextFiled> fields;
    private MarcTextFiled leader;

    public MarcString() {
    }

    public MarcString(MarcTextFiled leader) {
        this.leader = leader;
        fields = new ArrayList<MarcTextFiled>();
    }

    public List<MarcTextFiled> getFields() {
        return fields;
    }

    public void setFields(List<MarcTextFiled> fields) {
        this.fields = fields;
    }

    public MarcTextFiled getLeader() {
        return leader;
    }

    public void setLeader(MarcTextFiled leader) {
        this.leader = leader;
    }

}
