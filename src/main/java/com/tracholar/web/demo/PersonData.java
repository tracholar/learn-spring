package com.tracholar.web.demo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by zuoyuan on 2018/12/27.
 */
public class PersonData {
    @NotNull
    @Size(min = 5, max = 30)
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Min(10)
    @Max(100)
    private Integer age;

    public String toString() {
        return "Name = " + name + "; Age = " + age;
    }

}
