package processes;

import java.util.List;
import java.util.ArrayList;
import models.Record;


public class ListGetProcess extends ListProcess{

    public ListGetProcess(List<Record> list){
        super(list);
    };

    @Override
    public void run() {
        for(int i = 0; i < this.list.size(); i++){
            this.list.get(i);
        }
    }


}
