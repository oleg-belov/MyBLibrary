package md.blibrary.app.dao;

import java.util.Map;

import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;

public interface CaregoryMenuDAO<I, S> {
	public Map<Integer, String> selectAll() throws SystemException, NoSuchEntityException;
}
