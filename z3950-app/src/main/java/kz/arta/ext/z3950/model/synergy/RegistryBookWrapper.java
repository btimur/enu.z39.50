package kz.arta.ext.z3950.model.synergy;

/**
 * Created by timur on 9/10/14.
 * обертка для вида реестров
 */
public class RegistryBookWrapper {
    private String name;
    private String registryUUID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistryUUID() {
        return registryUUID;
    }

    public void setRegistryUUID(String registryUUID) {
        this.registryUUID = registryUUID;
    }
}
