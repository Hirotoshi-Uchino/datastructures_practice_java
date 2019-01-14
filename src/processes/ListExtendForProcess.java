package processes;

import models.Record;

import java.util.List;

public class ListExtendForProcess extends ListProcess {

    public ListExtendForProcess(List<Record> list){
        super(list);
    };

    @Override
    public void run() {
        for(Record record: this.list){
            int a = record.homerun + record.steal; // 無駄な処理をする
        }

    }

}
