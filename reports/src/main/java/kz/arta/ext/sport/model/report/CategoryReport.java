package kz.arta.ext.sport.model.report;

/**
 * Created by admin on 21.10.14.
 */
public class CategoryReport {

    private String  name;
    private SexEntity adult;
    private SexEntity youth;
    private SexEntity junior;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SexEntity getAdult() {
        return adult;
    }

    public void setAdult(SexEntity adult) {
        this.adult = adult;
    }

    public SexEntity getYouth() {
        return youth;
    }

    public void setYouth(SexEntity youth) {
        this.youth = youth;
    }

    public SexEntity getJunior() {
        return junior;
    }

    public void setJunior(SexEntity junior) {
        this.junior = junior;
    }

    public long getAllCount()
    {
        long all =0;
        if(adult!=null)
        {
            all = all+adult.getCountFemale();
            all = all+adult.getCountMale();
        }
        if(youth!=null)
        {
            all = all+youth.getCountFemale();
            all = all+youth.getCountMale();
        }
        if(junior!=null)
        {
            all = all+junior.getCountFemale();
            all = all+junior.getCountMale();
        }
        return all;
    }
    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        if(adult!=null)
        {
            result = (int) (31 * result + adult.getCountMale());
            result = (int) (31 * result + adult.getCountFemale());
        }else{
            result = 31 * result + 0;
        }
        if(youth!=null)
        {
            result = (int) (31 * result + youth.getCountMale());
            result = (int) (31 * result + youth.getCountFemale());
        }else{
            result = 31 * result + 0;
        }
        if(junior!=null)
        {
            result = (int) (31 * result + junior.getCountMale());
            result = (int) (31 * result + junior.getCountFemale());
        }else{
            result = 31 * result + 0;
        }
        return result;
    }

}
