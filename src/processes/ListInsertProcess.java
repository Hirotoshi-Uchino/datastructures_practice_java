package processes;

import models.Record;

import java.util.ArrayList;
import java.util.List;

public class ListInsertProcess extends ListProcess{

    List<Record> clonedList;
    int index;

    public ListInsertProcess(List<Record> list){
        super(list);
        this.index = 1;
//        this.index = list.size() - 1;
//        this.index = list.size() / 2;
        // deepCopyを実施
        this.clonedList = cloneList(list);
    };

    @Override
    public void run() {
        for(Record record: this.clonedList){
            this.list.add(this.index, record);
        }
    }

    private List<Record> cloneList(List<Record> list){
        List<Record> clone = new ArrayList<>(list.size());
        for(Record record: list){
            clone.add(record.clone());
        }
        return clone;
    }
}
