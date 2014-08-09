package kz.arta.ext.api.data;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 09.04.14
 * Time: 21:13
 */
public class Dictionary implements Comparable{
    private String id;
    private String name;

    private String professionId;

    public Dictionary() {
    }

    public Dictionary(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getProfessionId() {
        return professionId;
    }

    public void setProfessionId(String professionId) {
        this.professionId = professionId;
    }

    @Override
    public int compareTo(Object o) {
        if (o==null){
            return 1;
        }
        if (!(o instanceof Dictionary)){
            return 1;
        }
        Dictionary d = (Dictionary) o;
        if (name==null){
            return -1;
        }
        return name.compareTo(d.getName());
    }
}
