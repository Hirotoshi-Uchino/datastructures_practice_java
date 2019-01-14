package processes;

import java.util.ArrayList;
import java.util.Stack;
import models.Record;

public class StackProcess implements Process{

    ArrayList<Record> list;
    Stack<Record> stack = new Stack<>();

    public StackProcess(ArrayList<Record> list){
        this.list  = list;
    }


    @Override
    public void run(){
        // Stackを積み上げる
        for(Record record: this.list){
            this.stack.push(record);
        }

        // Stackから取得 (最初と最後のみ表示)
        Record tmpRecord = this.stack.pop();
        System.out.println("stackの先頭: " + tmpRecord.name);
        while (!this.stack.isEmpty()){
            tmpRecord = this.stack.pop();
        }
        System.out.println("stackの最後尾: " + tmpRecord.name);

    }
}
