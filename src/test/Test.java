package test;

import java.util.List;

import com.itany.jdbc.util.JDBCTemplate;
import com.itany.rent.entity.User;

public class Test {

	private JDBCTemplate jt = new JDBCTemplate();

	public User selectById(int id) {

		// 写代码所有的规范：提高代码的可读性（让别人（一周后的你自己）能看懂你的代码）
		// sql 语句使用StringBuffer拼接
		// 错误
		// String sql =
		// "select * from t_user u left join t_a a on a.uid= u.id left join t_b b on b.uid = a.id where id = ? ";

		// 所有的关键字 和 列名 独占一行 每个append 中 前后请保留一个空格
		// 禁止写 select *
		String sql = new StringBuffer()
				.append(" select ")
				.append("	u.username , ")
				.append("	u.password , ")
				.append("   u.age , ")
				.append("   u.addr , ")
				.append("   u.email  ")
				.append(" from")
				.append("	t_user u ")
				.append(" where ")
				.append("    u.id = ? ")
				.toString();
		// select ==> query |  update/insert/delete ==> update
		// sql 查询sql rm RomMapper对象， params 占位符参数（注意 个数和顺序）
//		List<User> list = jt.query(sql, rm, params);
		
//		return jt.query4Object(sql, rm, params);
		return null;
	}

	public void update() {
		/*
		 * 	update
		 * 		t_user
		 *  set
		 *  	username=?,
		 *  	password=?,
		 *  	age = ?,
		 *  	addr = ?
		 *  where
		 *  	id = ?	
		 */
	}

	public void deleteById(int id) {
		/*
		 * delete
		 * from
		 * 		t_user
		 * where
		 * 		id = ?
		 */
	}

	public void insert(Object obj) {
		/*
		 * insert
		 * into
		 * 		t_user
		 * 		(username,password,age,addr)
		 * values
		 * 		(?,?,?,?)
		 */
	}

}
