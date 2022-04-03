public class Main {
    public static void main(String [] args){
        Table table = new Table();
        table.addColumn("0");
        table.addColumn("1");
        table.addColumn("2");
        table.addRow();
        table.addRow();
        table.addRow();
        table.cell("2", 0).setValue("1");
        table.cell("1", 2).setValue("2");
        table.deleteColumn("2");
        table.deleteRow(2);

        System.out.println(table);
    }
}
