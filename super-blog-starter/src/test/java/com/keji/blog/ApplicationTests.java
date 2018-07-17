package com.keji.blog;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Sets;
import com.keji.blog.util.JsonUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

	@Autowired
	private ThreadPoolExecutor executor;


	@Test
	public void contextLoads() {
		System.out.println(executor);
	}

	@Test
	public void testname() {
		String s = "[\\u4e00-\\u9fa5]{2,6}";
		String name = "聂毅";
		boolean matches = name.matches(s);
		System.out.println(matches);
	}

	@Test
	public void testPhone() {
		String regx = "^1[0-9]{10}$";
		String phone = "15271888457";
		System.out.println(phone.matches(regx));
	}

	@Test
	public void testMap() {
		HashMap<String ,String > map = new HashMap<>();
		map.put("test", "1");
		map.put("test2", "2");

		String test3 = map.get("test3");
		System.out.println(test3);
	}

	@Test
	public void testJson() throws IOException {
		String json
				= "{\"policyNo\":\"\",\"operateMessage\":\"该订单号已经存在!\",\"importSN\":\"\",\"OrderNumber\":\"ghzf2016061213025898334226745\"}";

		PolicyRemoteResponseDTO policyRemoteResponseDTO = JsonUtil.json2Object(json, PolicyRemoteResponseDTO.class);
		System.out.println(policyRemoteResponseDTO);
	}

	@Test
	public void testBigdecimal() {
		BigDecimal bigDecimal = new BigDecimal(123);
		BigDecimal subtract = bigDecimal.subtract(null);
		System.out.println(subtract);
	}

	public static void main(String[] args) {
		System.out.println(1<<4);
		Set<String> set = Sets.newHashSet();
		set.add("test");

		for (String s : set) {
			String s1 = s.toLowerCase();
		}


		boolean b = set.contains("Test");
		System.out.println(b);
	}

}

class PolicyRemoteResponseDTO {

	/**
	 * 保险单号
	 */
	private String policyNo;

	/**
	 * 结果
	 */
	private String operateMessage;

	/**
	 * 君远投保单号
	 */
	private String importSN;

	/**
	 * 微脉投保单号
	 */
	@JsonFormat()
	public String orderNumber;

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getOperateMessage() {
		return operateMessage;
	}

	public void setOperateMessage(String operateMessage) {
		this.operateMessage = operateMessage;
	}

	public String getImportSN() {
		return importSN;
	}

	public void setImportSN(String importSN) {
		this.importSN = importSN;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	@JsonProperty(value = "OrderNumber")
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

