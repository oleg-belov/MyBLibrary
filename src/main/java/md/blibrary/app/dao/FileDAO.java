package md.blibrary.app.dao;

import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;

public interface FileDAO {
	public byte[] selectFileById(String sql, int fileId) throws SystemException, NoSuchEntityException;
}
