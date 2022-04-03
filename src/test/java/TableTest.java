import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TableTest {

    @Test
    void test1(){
        Table table = new Table();
        table.addColumn("0");
        table.addRow();
        table.cell("0", 0).setValue("153152");

        Assertions.assertEquals(153152, table.cell("0", 0).getValueAsInt());
    }

    @Test
    void test2(){
        Table table = new Table();
        table.addColumn("0");
        table.addColumn("1");
        table.addColumn("2");
        table.addRow();
        table.addRow();
        table.addRow();
        table.cell("2", 0).setValue("153152");

        Assertions.assertEquals(153152, table.cell("2", 0).getValueAsInt());
    }

    @Test
    void test3(){
        Table table = new Table();
        table.addColumn("0");
        table.addColumn("1");
        table.addColumn("2");
        table.addRow();
        table.addRow();
        table.addRow();
        table.cell("2", 0).setValue("153152");

        Assertions.assertEquals(153152, table.column("2").cell(0).getValueAsInt());
    }

    @Test
    void test4(){
        Table table = new Table();
        table.addColumn("0");
        table.addColumn("1");
        table.addColumn("2");
        table.addRow();
        table.addRow();
        table.addRow();
        table.cell("2", 0).setValue("153152");

        Assertions.assertEquals(153152, table.row(0).cell("2").getValueAsInt());
    }

    @Test
    void test5(){
        Table table = new Table();
        table.addColumn("0");
        table.addColumn("1");
        table.addColumn("2");
        table.addRow();
        table.addRow();
        table.addRow();
        table.cell("2", 0).setValue("153152");
        table.deleteRow(1);

        Assertions.assertEquals(2, table.getRowsSize());
        Assertions.assertEquals(3, table.getColumnsSize());
        Assertions.assertEquals(2, table.column("0").getElemsSize());
        Assertions.assertEquals(3, table.row(1).getElemsSize());
    }

    @Test
    void test6(){
        Table table = new Table();
        table.addColumn("0");
        table.addColumn("1");
        table.addColumn("2");
        table.addRow();
        table.addRow();
        table.addRow();
        table.cell("2", 0).setValue("153152");
        table.deleteColumn("0");

        Assertions.assertEquals(3, table.getRowsSize());
        Assertions.assertEquals(2, table.getColumnsSize());
        Assertions.assertEquals(3, table.column("1").getElemsSize());
        Assertions.assertEquals(2, table.row(1).getElemsSize());
        Assertions.assertEquals(153152, table.cell("2", 0).getValueAsInt());
    }
}