package haui.vn.util.dao;
import java.util.*;

public interface DAOInterface<T> {
	
	public List<T> selectAll();
	
	public T selectById(T t);
	
	public boolean insert(T t);
	
	public boolean update(T t);
	
	public boolean delete(T t);
}
