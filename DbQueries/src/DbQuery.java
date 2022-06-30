import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

interface Query
{
    void setTableName(String tableName);
}

interface Query_RUD extends Query
{
    void setCriteria(Criteria criteria);
    void setJoins();
}

class Condition
{
    private String columnName;
    private String comparator;
    private String value;

    public Condition(String columnName, String comparator, String value)
    {
        this.columnName = columnName;
        this.comparator = comparator;
        this.value = value;
    }

    public String toString()
    {
        return "("+this.columnName + " " + this.comparator + " " + this.value+")";
    }
}

class Criteria
{
    private LinkedHashMap<Condition, String> conditions;
    private Condition lastCondition;

    public Criteria(Condition condition)
    {
        conditions = new LinkedHashMap<>();
        conditions.put(condition, "");
        lastCondition = condition;
    }

    public void addCondition(String andOr, Condition condition)
    {
        conditions.put(lastCondition, andOr);
        conditions.put(condition, "");
        lastCondition = condition;
    }

    public String toString()
    {
        StringBuilder criteriaString = new StringBuilder("(");
        for (Map.Entry<Condition, String> entry : conditions.entrySet())
        {
            Condition condition = entry.getKey();
            String andOr = entry.getValue();

            criteriaString.append(condition.toString()).append(" ").append(andOr);
        }
        criteriaString.append(")");
        return criteriaString.toString();
    }
}

class SelectQuery implements Query_RUD
{
    private String tableName;
    private String[] columnNames;
    private Criteria criteria = null;

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public void setColumnNames(String... columnNames)  // using  (...) itself will create new String object instead of using String{}
    {
        this.columnNames = columnNames;
    }

    public String toQueryString()
    {
        StringBuilder queryString = new StringBuilder();
        queryString.append("select ");

        StringJoiner columns = new StringJoiner(",");
        for (String columnName : this.columnNames)
        {
            columns.add(columnName);
        }
        queryString.append(columns);

        queryString.append(" from ").append(this.tableName);

        if(criteria!=null)
        {
            queryString.append(" ").append(criteria);
        }

        return queryString.toString();
    }

    @Override
    public void setCriteria(Criteria criteria)
    {
        this.criteria = criteria;
    }

    @Override
    public void setJoins()
    {

    }
}

public class DbQuery
{
    public static void main(String[] args)
    {
        SelectQuery selectQuery = new SelectQuery();
        selectQuery.setTableName("table");
        selectQuery.setColumnNames("col1", "col2", "col3");
    }
}
