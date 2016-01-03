package sql;

import proparty.S;

public class AccesarrySQL {
	public void setString(String TBL,S s){
		String SQL;
		SQL = "update " + TBL + " a "
			+ "set ID = "
			+ " ( "
			+ " select count(b.ID) + 1"
			+ " from " + TBL + " b "
			+ " where b.ID < a.ID "
			+ " ) ";
			System.out.println(SQL);
//		update NoTable a
//		set No = (select count(b.No)+1 from NoTable b
//		           where b.No < a.No);
//

//		s.freeUpdateQuery(SQL);

	}
}
