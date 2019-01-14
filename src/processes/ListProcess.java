package processes;

import models.Record;

import java.util.List;

public abstract class ListProcess implements Process{

    public List<Record> list;

    public ListProcess(List<Record> list){
        this.list = list;
    };

    public abstract void run();
}
