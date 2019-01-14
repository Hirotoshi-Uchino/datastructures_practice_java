package tests;

//import Util.BD;
import Util.TD;
import models.Record;
import models.TreapInEr;

class TreapInErTest {

    static TreapInEr<Record> treap = new TreapInEr<>();

    @org.junit.jupiter.api.BeforeAll
    static void prepare(){
        Record record1 = new Record("金井", 2018, TD.truncate(0.1), 10, 11, 200,
                TD.truncate(2.22), TD.truncate(1.50), 10, 80, 100);
        Record record2 = new Record("斉藤", 2018, TD.truncate(0.8), 10, 11, 200,
                TD.truncate(2.22), TD.truncate(1.50), 10, 80, 100);
        Record record3 = new Record("菅井", 2018, TD.truncate(0.2), 10, 11, 200,
                TD.truncate(2.22), TD.truncate(1.50), 10, 80, 100);
        Record record4 = new Record("羽生", 2018, TD.truncate(0.6), 10, 11, 200,
                TD.truncate(2.22), TD.truncate(1.50), 10, 80, 100);
        Record record5 = new Record("三浦", 2018, TD.truncate(0.3), 10, 11, 200,
                TD.truncate(2.22), TD.truncate(1.50), 10, 80, 100);
        treap.add(record1, 0.111111);
        treap.add(record2, 0.211111);
        treap.add(record3, 0.811111);
        treap.add(record4, 0.011111);
        treap.add(record5, 0.411111);

        System.out.println(treap.toString());
        System.out.println(treap.getSize(treap.root));


    }


    @org.junit.jupiter.api.Test
    void getKthTarget() {

        System.out.println("getKthTargetTest");
        System.out.println(treap.toString());
        Record record = treap.getKthTarget(2);
        System.out.println(record.toString());

//        assert "斉藤" == treap.getKthTarget(8).name;
    }

    @org.junit.jupiter.api.Test
    void add() {
        System.out.println("addTest");
        Record record6 = new Record("森内", 2018, TD.truncate(0.35), 10, 11, 200,
                TD.truncate(2.22), TD.truncate(1.50), 10, 80, 100);
        Record record7 = new Record("豊島", 2018, TD.truncate(0.7), 10, 11, 200,
                TD.truncate(2.22), TD.truncate(1.50), 10, 80, 100);
        Record record8 = new Record("阿久津", 2018, TD.truncate(0.25), 10, 11, 200,
                TD.truncate(2.22), TD.truncate(1.50), 10, 80, 100);

        treap.add(record6, 0.911111);
        System.out.println(treap.toString());
        System.out.println(treap.getSize(treap.root));
        treap.add(record7, 0.311111);
        System.out.println(treap.toString());
        System.out.println(treap.getSize(treap.root));
        treap.add(record8, 0.051111);
        System.out.println(treap.toString());
        System.out.println(treap.getSize(treap.root));
    }

    @org.junit.jupiter.api.Test
    void search(){
        Record record = new Record("羽生", 2018, TD.truncate(0.6), 10, 11, 200,
                TD.truncate(2.22), TD.truncate(1.50), 10, 80, 100);

        System.out.println(treap.search(treap.root, record));

    }

}