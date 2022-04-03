import java.util.ArrayList;
import java.util.List;

public class Table {
    public class Column{
        private String name;
        private List<Cell> elems;

        public Column(String name){
            this.name = name;
            elems = new ArrayList<>();
            for (int i = 0; i < rows.size(); i++){
                elems.add(new Cell());
            }
        }
        public String getName(){
            return name;
        }

        public Cell cell(int index){
            return elems.get(index);
        }

        public int getElemsSize(){
            return elems.size();
        }
    }

    public class Row{
        private List<Cell> elems;

        public Row(){
            elems = new ArrayList<>();
            for (int i = 0; i < columns.size(); i ++){
                elems.add(new Cell());
            }

        }

        public Cell cell(String name){
            return elems.get(getColumnIndex(name));
        }

        public int getElemsSize(){
            return elems.size();
        }
    }

    public class Cell{
        private String value;

        public void setValue(String value){
            this.value = value;
        }

        public int getValueAsInt(){
            return Integer.parseInt(value);
        }

        public int getValueAsInt(String value){
            setValue(value);
            return getValueAsInt();
        }
    }


    private List<Column> columns;
    private List<Row> rows;

    public Table(){
        columns = new ArrayList<>();
        rows = new ArrayList<>();
    }

    public Row row(int index){
        return rows.get(index);
    }

    public Column column(String name){
        return columns.get(getColumnIndex(name));
    }

    public void addColumn(String name){
        columns.add(new Column(name));
        int i = 0;
        for (Row elem : rows){
            elem.elems.add(columns.get(columns.size()-1).elems.get(i));
            i++;
        }
    }
    public void addRow(){
        rows.add(new Row());
        int i = 0;
        for (Column elem : columns){
            elem.elems.add(rows.get(rows.size()-1).elems.get(i));
            i++;
        }
    }

    public void deleteColumn(String name){
        for (Row elem : rows){
            elem.elems.remove(getColumnIndex(name));
        }
        columns.remove(getColumnIndex(name));
    }

    public void deleteRow(int index){
        rows.remove(index);
        for (Column elem : columns){
            elem.elems.remove(index);
        }
    }


    public int getColumnIndex(String name){
       int i = 0;
       for (Column elem : columns){
           if (elem.getName().equals(name)){
               return i;
           }
           i++;
       }

       return -1;
    }

   public Cell cell(String name, int index){
        return rows.get(index).cell(name);
   }

    public Cell cell(int index, String name){
        return cell(name, index);
    }

    public int getRowsSize(){
        return rows.size();
    }

    public int getColumnsSize(){
        return columns.size();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (Column elem : columns){
            sb.append(elem.name).append("\s");
        }

        for (Row elem : rows){
            sb.append("\n");
            for (Cell cell : elem.elems){
                if (cell.value == null){
                    sb.append("#").append("\s");
                } else {
                    sb.append(cell.value).append("\s");
                }
            }
        }

        return sb.toString();
    }
}
