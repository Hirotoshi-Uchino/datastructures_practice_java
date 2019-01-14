package processes;

import models.Record;

import java.util.ArrayList;
import java.util.List;

public class ListAddProcess extends ListProcess{

    List<Record> clonedList;

    public ListAddProcess(List<Record> list){
        super(list);
        // deepCopyを実施
        this.clonedList = cloneList(list);
    };

    @Override
    public void run() {
        for(Record record: this.clonedList){
            this.list.add(record);
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
