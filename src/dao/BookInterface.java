package dao;

public interface BookInterface <T,P>{
	T insert(P p);
	T remove(P p);
}
