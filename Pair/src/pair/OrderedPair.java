package pair;

/**
 *
 * @author Jayuk
 */
public class OrderedPair <K extends String,N extends String> implements Pair<K,N>
{
    private K key;
    private N value;
    
    public OrderedPair(K key, N value)
    {
        this.key = key;
        this.value = value;
    }
            
    public K getKey()
    {
        return key;
    }
    public N getValue()
    {
        return value;
    }
    
}
