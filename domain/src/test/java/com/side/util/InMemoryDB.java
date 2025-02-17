package com.side.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class InMemoryDB<ID, Data extends TestEntity<ID>> {

	protected LinkedHashMap<ID, Data> db = new LinkedHashMap<ID, Data>();

	/**
	 * InMemoryDB Save
	 * @param data Entity
	 */
	public Data save(Data data) {
		if (db.containsValue(data.id())) {
			return null;
		}

		db.put(data.id(), data);
		return data;
	}

	/**
	 * InMemoryDB findById
	 * @param id Entity's id
	 */
	public Data findById(ID id) {
		return db.get(id);
	}

	/**
	 * InMemoryDB findAll
	 */
	public List<Data> findAll() {
		return new ArrayList<>(db.values());
	}

	/**
	 * InMemoryDB deleteById
	 * @param id Entity's id
	 */
	public void deleteById(ID id) {
		if (db.remove(id) == null) {
			throw new IllegalStateException("No data with id#" + id);
		} else {
			db.remove(id);
		}
	}

	/**
	 * InMemoryDB deleteAll
	 */
	public void deleteAll() {
		db.clear();
	}

}
