package processes;

import Util.TD;
import models.Record;

import java.util.List;
import java.util.Random;

public class ListSearchProcess extends ListProcess{
    public ListSearchProcess(List<Record> list){
        super(list);
    };

    @Override
    public void run() {
        Random r = new Random(100);
        for(int i = 0; i < 100; ++i){
            boolean eq = false;
            double target = TD.truncate(r.nextDouble());
            Record dummy = new Record("dummy", 0, target, 0, 0, 0,
                    TD.truncate(0.), TD.truncate(0.), 0, 0, 0);
            for(Record record: this.list){
                if(record.average == dummy.average){
                    eq = true;
                    break;
                }
            }

            System.out.println("search: " + eq);
        }
    }


}
