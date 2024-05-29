package Model;

import java.util.ArrayList;

public interface IDao<E,I> {

    //public int delete(Integer bean);
    //public int update(E bean);
    public ArrayList<E> findAll(E bean);

}
