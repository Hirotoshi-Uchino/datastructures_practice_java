package processes;

import models.Record;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;

public class QueueProcess implements Process{
    ArrayList<Record> list;
    Queue<Record> queue = new ArrayDeque<>();

    public QueueProcess(ArrayList<Record> list){
        this.list  = list;
    }


    @Override
    public void run(){
        // Queueを積み上げる
        for(Record record: this.list){
            this.queue.add(record);
        }

        // Queueから取得 (最初と最後のみ表示)
        Record tmpRecord = this.queue.poll();
        System.out.println("Queueの先頭: " + tmpRecord.name);
        while (!this.queue.isEmpty()){
            tmpRecord = this.queue.poll();
        }
        System.out.println("Queueの最後尾: " + tmpRecord.name);

    }

}
