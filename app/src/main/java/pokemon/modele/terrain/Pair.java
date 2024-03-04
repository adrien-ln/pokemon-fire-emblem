package pokemon.modele.terrain;

import java.util.Objects;

public class Pair {
    private int first, second;
    private int distance;

    public Pair(int first, int second, int distance) 
    {
        this.first = first;
        this.second = second;
        this.distance=distance;
    }   
    public int getFirst() {
        return first;
    }
    public int getSecond() {
        return second;
    }
    public int getDistance(){
        return distance;
    }

    @Override
    public boolean equals(Object p){
        if( ! (p instanceof Pair))
            return false;
        Pair pair=(Pair)p;
        if( first==pair.getFirst() && second==pair.getSecond() )
            return true;
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(first,second);
    }
}
