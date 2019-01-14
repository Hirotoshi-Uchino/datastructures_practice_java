package processes;

import Util.TD;
import models.Record;
import models.TreapInEr;

import java.util.List;
import java.util.Random;

public class TreapSearchProcess implements Process{

    public TreapInEr treap;

    public TreapSearchProcess(List<Record> list){
        this.treap = createTreap(list);
    }

    @Override
    public void run(){
        Random r = new Random(1);
        for(int i = 0; i < 100; ++i){
            double target = TD.truncate(r.nextDouble());
            Record dummy = new Record("dummy", 0, target, 0, 0, 0,
                    TD.truncate(0.), TD.truncate(0.), 0, 0, 0);
            System.out.println("search: " + this.treap.search(this.treap.root, dummy));
        }
    }

    private TreapInEr<Record> createTreap(List<Record> list){
        TreapInEr<Record> treap = new TreapInEr<>();
        double priority;
        Random r = new Random(1);
        for(Record record: list){
            priority = r.nextDouble();
            treap.add(record, priority);
        }
        return treap;
    }

}
