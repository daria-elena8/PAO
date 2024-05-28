package Database.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface GenericDAO<T> {


    void create(T t);
    T read(int id);
    List<T> readAll();
    void update(T t);
    void delete(int id);
}
