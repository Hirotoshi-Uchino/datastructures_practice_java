import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import Util.TD;
import models.Record;
import processes.Process;
import processes.*;
import property.PropertiesManager;
//import processes.ListSearchProcess;
//import processes.TreapSearchProcess;

public class Main {

    public static void main(String[] args) {

        PropertiesManager conf = new PropertiesManager("/Users/hirotoshi/IdeaProjects/HPC_playground/config/conf.properties");

        String dataPath = conf.getProperty("dataPath");
        System.out.println(dataPath);

        List<Record> recordArrayList  = loadData(dataPath);
        List<Record> recordLinkedList = createLinkedListData(recordArrayList);

//        1. list get =======================================================
//        Process arrayListGetProcess  = new ListGetProcess(recordArrayList);
//        Process linkedListGetProcess = new ListGetProcess(recordLinkedList);
//        TimeMeasurement.execute(arrayListGetProcess, "ArrayList Get");
//        TimeMeasurement.execute(linkedListGetProcess, "LinkedList Get");

//        2. list extend for =======================================================
//        Process arrayListEFProcess  = new ListExtendForProcess(recordArrayList);
//        Process linkedListEFProcess = new ListExtendForProcess(recordLinkedList);
//        TimeMeasurement.execute(arrayListEFProcess, "ArrayList Extend For");
//        TimeMeasurement.execute(linkedListEFProcess, "LinkedList Extend For");

//        3. list add =======================================================
//        Process arrayListAddProcess  = new ListAddProcess(recordArrayList);
//        Process linkedListAddProcess = new ListAddProcess(recordLinkedList);
//        TimeMeasurement.execute(arrayListAddProcess, "ArrayList Add");
//        TimeMeasurement.execute(linkedListAddProcess, "LinkedList Add");

//        4. list insert =======================================================
//        Process arrayListInsertProcess  = new ListInsertProcess(recordArrayList);
//        Process linkedListInsertProcess = new ListInsertProcess(recordLinkedList);
//        TimeMeasurement.execute(arrayListInsertProcess, "ArrayList Insert");
//        TimeMeasurement.execute(linkedListInsertProcess, "LinkedList Insert");

//        5. list iterator remove =======================================================
//        Process arrayListIteratorRemoveProcess  = new ListIteratorRemoveProcess(recordArrayList);
//        Process linkedListIteratorRemoveProcess = new ListIteratorRemoveProcess(recordLinkedList);
//        TimeMeasurement.execute(arrayListIteratorRemoveProcess, "ArrayList Iterator Remove");
//        TimeMeasurement.execute(linkedListIteratorRemoveProcess, "LinkedList Iterator Remove");
//
//        6. stack and queue =======================================================
        Process stackProcess = new StackProcess((ArrayList)recordArrayList);
        Process queueProcess = new QueueProcess((ArrayList)recordArrayList);
        TimeMeasurement.execute(stackProcess, "Stack ");
        TimeMeasurement.execute(queueProcess, "Queue ");

//        7. search by list and treap ==============================================
//        Process listSearchProcess  = new ListSearchProcess(recordArrayList);
//        Process treapSearchProcess = new TreapSearchProcess(recordArrayList);
//        TimeMeasurement.execute(listSearchProcess,  "List Search");
//        TimeMeasurement.execute(treapSearchProcess, "Treap Search");

    }


    private static List<Record> loadData(String dataPath){

        List<Record> recordArrayList = new ArrayList<>();

        try{
            File file = new File(dataPath);
            if (!file.exists()){
                System.out.print("File not found.");
                return null;
            }

            // BufferedReaderクラスのreadLineメソッドを使って1行ずつ読み込み表示する
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;

            while ((data = bufferedReader.readLine()) != null) {
                String[] cols = data.split("\t");
                if(cols[0].equals("名前")){ // 1行目は捨てる
                    continue;
                }

                String name     = cols[0];
                int    year     = Integer.valueOf(cols[1]);
                double average   = TD.truncate(Double.valueOf(cols[2]));
                int rbi         = Integer.valueOf(cols[3]);
                int homerun     = Integer.valueOf(cols[4]);
                int hits        = Integer.valueOf(cols[5]);
                double baseProb  = TD.truncate(Double.valueOf(cols[6]));
                double ops       = TD.truncate(Double.valueOf(cols[7]));
                int steal       = Integer.valueOf(cols[8]);
                int walk        = Integer.valueOf(cols[9]);
                int struckOut   = Integer.valueOf(cols[10]);

                Record record   = new Record(name, year, average, rbi, homerun, hits, baseProb, ops, steal, walk, struckOut);

                recordArrayList.add(record);


            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {

        }

        return recordArrayList;
    };


    public static List<Record> createLinkedListData(List<Record> list){
        List<Record> recordLinkedList = new LinkedList<>();
        for(Record record: list){
            recordLinkedList.add(record);
            System.out.println(record.toString());
        }
        return recordLinkedList;
    };

}
