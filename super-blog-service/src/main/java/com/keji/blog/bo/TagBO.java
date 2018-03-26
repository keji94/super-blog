package com.keji.blog.bo;

import java.io.Serializable;

import lombok.Data;

/**
 * @author wb-ny291824
 * @version $Id: TagBO.java, v 0.1 2018-03-26 14:53 wb-ny291824 Exp $$
 */
@Data
public class TagBO implements Serializable{

    private static final long serialVersionUID = 5644294095786946274L;

    private Long id;

    private String name;

    private Integer count;
}
