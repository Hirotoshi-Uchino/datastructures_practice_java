package processes;

import models.Record;

import java.util.List;
import java.util.Iterator;

public class ListIteratorRemoveProcess extends ListProcess{

    public ListIteratorRemoveProcess(List<Record> list){
        super(list);
    };

    @Override
    public void run() {
        Iterator<Record> iterator = list.iterator();
        int index = 0;

        while(iterator.hasNext()){
            iterator.next();
            if (index % 2 == 0) {
                iterator.remove();
            }
            index++;
        }
    }

}
