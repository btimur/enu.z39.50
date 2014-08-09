package kz.arta.ext.api.data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 03.04.14
 * Time: 19:43
 */
public class RegistryWrapper {
    private String registryUUID;
    private List<RegistryRecord> records;

    public String getRegistryUUID() {
        return registryUUID;
    }

    public void setRegistryUUID(String registryUUID) {
        this.registryUUID = registryUUID;
    }

    public List<RegistryRecord> getRecords() {
        return records;
    }

    public void setRecords(List<RegistryRecord> records) {
        this.records = records;
    }
    public void printRecords(){
        if (records!=null){
            int i=1;
            for(RegistryRecord record:records){
                System.out.println((i++)+". record = " + record);
            }
        }
    }

    public boolean hasData(){
        boolean res = false;
        if (records!=null){
            res = records.size()>0;
        }
        return res;
    }

    @Override
    public String toString() {
        return "RegistryWrapper uuid="+registryUUID + ", records count = "+((records!=null)?records.size():"0");
    }
}
