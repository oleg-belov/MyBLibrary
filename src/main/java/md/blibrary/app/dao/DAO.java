package md.blibrary.app.dao;

import java.util.List;

import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;

public interface DAO<T> {
	public List<T> selectAll() throws SystemException, NoSuchEntityException;
	public T selectByID(int entityID) throws SystemException, NoSuchEntityException;
}
