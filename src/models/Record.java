package models;

public class Record implements Cloneable, Comparable<Record>{
    public String name;
    public int    year;
    public double average;
    public int    rbi;
    public int    homerun;
    public int    hits;
    public double baseProb;
    public double ops;
    public int    steal;
    public int    walk;
    public int    struckOut;

    public Record(String name, int year, double average, int rbi, int homerun, int hits, double baseProb,
                  double ops, int steal, int walk, int struckOut)
    {
        this.name      = name;
        this.year      = year;
        this.rbi       = rbi;
        this.average   = average;
        this.homerun   = homerun;
        this.hits      = hits;
        this.baseProb  = baseProb;
        this.ops       = ops;
        this.steal     = steal;
        this.walk      = walk;
        this.struckOut = struckOut;
    }

    // 参考: https://qiita.com/SUZUKI_Masaya/items/8da8c0038797f143f5d3
    @Override
    public Record clone(){
        Record record = null;
        try {
            record = (Record) super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return record;

    }

    @Override
    public int compareTo(Record that){
        if(this.average > that.average){
            return 1;
        } else if(this.average < that.average){
            return -1;
        } else {
            return 0;
        }
//        return this.average.compareTo(that.average);
    }

    public String toString(){
        return this.name;
    }

//    public Boolean equals(Record that){
//        return this.average == that.average;
//    }

}