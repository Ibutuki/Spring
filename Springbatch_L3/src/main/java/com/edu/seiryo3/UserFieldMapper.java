package com.edu.seiryo3;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.edu.seiryo.User;

public class UserFieldMapper implements FieldSetMapper<User>{

	@Override
	public User mapFieldSet(FieldSet fieldSet) throws BindException {
		//自己定义映射逻辑
        User User = new User();
        User.setId(fieldSet.readLong("id"));
        User.setAge(fieldSet.readInt("age"));
        User.setName(fieldSet.readString("name"));
        String addr = fieldSet.readString("province") + " "
                + fieldSet.readString("city") + " " + fieldSet.readString("area");
        User.setAddress(addr);
        return User;
	}

}
